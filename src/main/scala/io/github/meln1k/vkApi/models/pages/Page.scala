package io.github.meln1k.vkApi.models.pages

import play.api.libs.json.Json


case class Page(id: Long,
                group_id: Long,
                creator_id: Long,
                title: String,
                current_user_can_edit: Option[Int],
                current_user_can_edit_access: Option[Int],
                who_can_view: Int,
                who_can_edit: Int,
                edited: Long,
                created: Long,
                editor_id: Long,
                views: Long,
                parent: Option[String],
                parent2: Option[String],
                source: Option[String],
                html: Option[String],
                view_url: String)

object Page {
  implicit val pageReads = Json.reads[Page]
}
