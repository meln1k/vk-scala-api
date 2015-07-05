package io.github.meln1k.vkApi.models

import play.api.libs.json.Json

case class GroupList(count: Int, items: Seq[Group])



case class Group(id: Long,
                 name: String,
                 screen_name: String,
                 is_closed:Int,
                 `type`: String,
                 is_admin: Int,
                 is_member: Int,
                 members_count: Long,
                 photo_50: String,
                 photo_100: String,
                 photo_200: String
                  )


object Group {
  implicit val groupReads = Json.reads[Group]
}

object GroupList {
  implicit val groupListReads = Json.reads[GroupList]
}