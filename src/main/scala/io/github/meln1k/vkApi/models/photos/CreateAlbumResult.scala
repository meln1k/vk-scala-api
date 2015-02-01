package io.github.meln1k.vkApi.models.photos

import play.api.libs.json.Json

/**
 * Created by user on 16.01.2015.
 */

/**
 * Object contains info about created album.
 * @param id id of the album.
 * @param thumb_id id of the albums's cover photo.
 * @param owner_id id of user/group, where album was created.
 * @param title Title if the album.
 * @param description Text description of the album .
 * @param created Date of creation in ''unixtime'' format.
 * @param updated Date of last update in ''unixtime'' format.
 * @param size Amount of photos in the album.
 * @param privacy_view ''Optional.'' PrivacyType structure, which contains string with privacy settings of the album.
 * @param privacy_comment ''Optional.'' PrivacyType structure, which contains string with comment privacy settings of the album.
 * @param upload_by_admins_only ''Optional.'' Shows who can upload photos to the album.
 * @param comments_disabled ''Optional.'' Shows availability of comments.
 * @param can_upload ''Optional.'' Shows is current user able to upload photos to the album.
 */
case class CreateAlbumResult(id: Long,
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
                             can_upload: Option[Int])

object CreateAlbumResult {
  implicit val createAlbumResultReads = Json.reads[CreateAlbumResult]
}


