package io.github.meln1k.vkApi.models.users

import play.api.libs.json.Json


case class Community(id: Int,
                 name: String,
                 screen_name: String,
                 is_closed: Int,
                 `type`: String,
                 is_admin: Option[Int],
                 is_member: Option[Int],
                 photo_50: String,
                 photo_100: String,
                 photo_200: String)

object Community {
  implicit val communityReads = Json.reads[Community]
}


