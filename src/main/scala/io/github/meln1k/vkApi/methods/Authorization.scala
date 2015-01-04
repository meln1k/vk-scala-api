package io.github.meln1k.vkApi.methods

import io.github.meln1k.vkApi.utils.{AccessToken, InjectHelper}
import InjectHelper._
import io.github.meln1k.vkApi.models.auth.{AuthConfirmation, Sid}
import io.github.meln1k.vkApi.services.HttpLayerService
import io.github.meln1k.vkApi.utils.ApiFutureUtils._

import scala.concurrent.ExecutionContext.Implicits.global

class Authorization(implicit accessToken: AccessToken) {

  val httpLayerService = inject[HttpLayerService]

  /** Checks a user's phone number for correctness.
    *
    * This is an open method; it does not require an access_token.
    *
    * @param phone Phone number.
    * @param clientId User ID.
    * @param clientSecret
    * @return Returns 1 if the phone number is correct; otherwise returns 0.
    */
  def checkPhone(phone: String, clientId: Int, clientSecret: String) = {
    httpLayerService.apiRequest("auth.checkPhone", Vector(
      "phone" -> phone,
      "client_id" -> clientId.toString,
      "client_secret" -> clientSecret
    )).map2[Int].map(_ != 0)
  }

  /** Registers a new user by phone number.
    *
    * This is an open method; it does not require an access_token.
    *
    * @param firstName User's first name.
    * @param lastName User's surname.
    * @param clientId Your application ID.
    * @param clientSecret
    * @param phone User's phone number. Can be pre-checked with the [[Authorization.checkPhone]] method.
    * @param password User's password (minimum of 6 characters). Can be specified later with the [[Authorization.confirm]] method.
    * @param testMode {{{
    * `true` — test mode, in which the user will not be registered and the phone number will not be checked for availability
    * `false` — default mode (default)
    * }}} ''flag, either true or false''
    * @param voice {{{
    * 1 — call the phone number and leave a voice message of the authorization code
    * 0 — send the code by SMS (default)
    * }}} ''flag, either true or false''
    * @param sex {{{
    * 1 — female
    * 2 — male
    * }}}
    * @param sid Session ID required for method recall when SMS was not delivered.
    * @return Returns an SMS with an authorization code, which is sent to the user's phone number.
    *         The authorization code is used by the auth.confirm method to complete the registration.
    *         The sid field returned in the reply is required to resend the SMS in case of delivery failure.
    */
  def signup(firstName: String,
             lastName: String,
             clientId: String,
             clientSecret: String,
             phone: String,
             password: String,
             testMode: Boolean = false,
             voice: Boolean = false,
             sex: Int,
             sid: String) = {
    httpLayerService.apiRequest("auth.signup", Vector(
      "first_name" -> firstName,
      "last_name" -> lastName,
      "client_id" -> clientId,
      "client_secret" -> clientSecret,
      "phone" -> phone,
      "password" -> password,
      "test_mode" -> {if (testMode) 1 else 0}.toString,
      "voice" -> {if (voice) 1 else 0}.toString,
      "sex" -> sex.toString,
      "sid" -> sid
    )).map2[Sid]
  }

  /** Completes a user's registration (begun with the [[Authorization.signup]] method) using an authorization code.
    *
    * This is an open method; it does not require an access_token.
    *
    * @param clientId
    * @param clientSecret
    * @param phone
    * @param code
    * @param password
    * @param testMode
    * @param intro
    * @return Returns an object containing the following fields: {{{
    *         success — 1
    *         uid — ID of the registered user.}}}
    */
  def confirm(clientId: String,
              clientSecret: String,
              phone: String,
              code: String,
              password: String,
              testMode: Boolean,
              intro: Int) = {
    httpLayerService.apiRequest("auth.confirm", Vector(
      "client_id" -> clientId,
      "client_secret" -> clientSecret,
      "phone" -> phone,
      "code" -> code,
      "password" -> password,
      "test_mode" -> {if (testMode) 1 else 0}.toString,
      "intro" -> intro.toString
    )).map2[AuthConfirmation]
  }

  /** Allows to restore account access using a code received via SMS.
    *
    * This method is only available for apps with Direct authorization access.
    *
    * This is an open method; it does not require an access_token.
   *
   * @param phone User phone number.
   * @return In case of success the method returns an object containing following fields:{{{
    *           success – 1
    *           sid – parameter required to get access by code
    * }}} To finish the restoration refer to the following address:
    * https://oauth.vk.com/token?grant_type=restore_code&client_id={Application ID}&client_secret={Secret key}
    * &username={Phone number}&scope={Permissions list}
    * &sid={Parameter received with this method}&code={Received SMS code}
   */
  def restore(phone: String) = httpLayerService.apiRequest("auth.restore", Vector(
    "phone" -> phone
  )).map2[AuthConfirmation]
}
