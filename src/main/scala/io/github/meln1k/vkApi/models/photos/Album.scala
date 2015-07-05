package io.github.meln1k.vkApi.models.photos

import play.api.libs.json.Json

/**
 * Created by user on 02.02.2015.
 */
case class Album (id: Long,
                   thumb_id: Long,
                   owner_id: Long,
                   title: String,
                   description: String,
                   created: Long,
                   updated: Long,
                   size: Int,
                   privacy_view: Option[PrivacyType],
                   privacy_comment: Option[PrivacyType],
                   upload_by_admins_only: Option[Int],
                   comments_disabled: Option[Int],
                   can_upload: Option[Int],
                   thumb_src: Option[String])

object Album {
  implicit val albumReads = Json.reads[Album]
}
