package io.github.meln1k.vkApi.methods.auth

import io.github.meln1k.vkApi.AccessToken
import io.github.meln1k.vkApi.InjectHelper._
import io.github.meln1k.vkApi.services.HttpLayerService
import io.github.meln1k.vkApi.utils.ApiFutureUtils._

class Auth(implicit accessToken: AccessToken) {

  val httpLayerService = inject[HttpLayerService]

  def checkPhone(phone: String, clientId: Int, clientSecret: String) = {
    httpLayerService.apiRequest("auth.checkPhone", Vector(
      "phone" -> phone,
      "client_id" -> clientId.toString,
      "client_secret" -> clientSecret
    )).map2[Int].map(_ != 0)
  }

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

}
