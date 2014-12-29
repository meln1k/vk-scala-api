package io.github.meln1k.vkApi.models.auth

import play.api.libs.json.Json


case class Sid(sid: String)

object Sid {
  implicit val sidReads = Json.reads[Sid]
}
