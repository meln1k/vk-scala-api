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
}
