package io.github.meln1k.vkApi.models.wall

import play.api.libs.json.Json


case class PostedPhoto(id: Long,
                       owner_id: Long,
                       photo_130: String,
                       photo_604: String)

object PostedPhoto {
  implicit val postedPhotoReads = Json.reads[PostedPhoto]
}
