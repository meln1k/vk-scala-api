package io.github.meln1k.vkApi.models.wall

import play.api.libs.json.Json


case class PostsList(count: Int, items: Seq[Post])

object PostsList {
  implicit val postsListReads = Json.reads[PostsList]
}
