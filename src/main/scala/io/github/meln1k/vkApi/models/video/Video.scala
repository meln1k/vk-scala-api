package io.github.meln1k.vkApi.models.video

import play.api.libs.json.Json


case class Video(id: Long,
                 owner_id: Long,
                 title: String,
                 description: String,
                 duration: Int,
                 link: Option[String],
                 photo_130: Option[String],
                 photo_320: Option[String],
                 photo_640: Option[String],
                 date: Long,
                 views: Long,
                 comments: Int,
                 player: Option[String],
                 access_key: Option[String])

object Video {
  implicit val videoReads = Json.reads[Video]
}