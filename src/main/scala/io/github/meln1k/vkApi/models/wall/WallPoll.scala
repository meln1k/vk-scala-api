package io.github.meln1k.vkApi.models.wall

import play.api.libs.json.Json


case class WallPoll(id: Long, question: String)

object WallPoll {
  implicit val wallPollReads = Json.reads[WallPoll]
}
