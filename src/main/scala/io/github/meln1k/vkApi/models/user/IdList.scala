package io.github.meln1k.vkApi.models.user

import play.api.libs.json.Json


case class IdList(count: Int, items: Seq[Int])

object IdList {
  implicit val idListReads = Json.reads[IdList]
}