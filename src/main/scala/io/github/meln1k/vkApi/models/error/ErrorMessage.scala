package io.github.meln1k.vkApi.models.error

import play.api.libs.json.Json

case class ErrorMessage(error_code: Int, error_msg: String, request_params: Seq[RequestParam])

object ErrorMessage {
  implicit val errorMessageReads = Json.reads[ErrorMessage]
}