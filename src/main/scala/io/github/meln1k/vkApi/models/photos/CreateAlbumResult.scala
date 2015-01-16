package io.github.meln1k.vkApi.models.photos

import play.api.libs.json.Json
import io.github.meln1k.vkApi.models.users.SubscriptionsList

/**
 * Created by user on 16.01.2015.
 */
case class CreateAlbumResult(id: Long,
                             thumb_id: Long,
                             owner_id: Long,
                             title: String,
                             description: String,
                             created: Long,
                             updated: Long,
                             size: Int,
                             privacy: Int,
                             comment_privacy: Int,
                             upload_by_admins_only: Int,
                             comments_disabled: Int,
                             can_upload: Int)

object CreateAlbumResult {
  implicit val createAlbumResultReads = Json.reads[CreateAlbumResult]
}


