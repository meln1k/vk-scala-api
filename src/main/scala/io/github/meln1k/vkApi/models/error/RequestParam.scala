package io.github.meln1k.vkApi.models.error

import play.api.libs.json.Json

case class RequestParam(key: String, value: String)

object RequestParam {
  implicit val requestParamReads = Json.reads[RequestParam]
}