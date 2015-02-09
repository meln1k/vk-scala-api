package io.github.meln1k.vkApi.models.wall

import play.api.libs.json.Json


case class PostId(post_id: Long)

object PostId {
  implicit val postIdReads = Json.reads[PostId]
}
