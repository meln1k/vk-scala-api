package io.github.meln1k.vkApi.models.auth

import play.api.libs.json.Json


case class AuthConfirmation(success: Int, uid: Int)

object AuthConfirmation {
  implicit val confirmResponseReads = Json.reads[AuthConfirmation]
}