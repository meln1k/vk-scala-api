package io.github.meln1k.vkApi.models.photos

import play.api.libs.json.Json

/** A photo object describes a photo and contains the following fields:
  *
  * @param id Photo ID.
  * @param album_id Photo album ID.
  * @param owner_id ID of the user or community that owns the photo (if the photo located in community).
  *                 For photos, uploaded by community, id = 100.
  * @param user_id ID of the user that uploaded the photo.
  * @param photo_75 URL of image with maximum size 75x75px.
  * @param photo_130 URL of image with maximum size 130x130px.
  * @param photo_604 URL of image with maximum size 604x604px.
  * @param photo_807 URL of image with maximum size 807x807px.
  * @param photo_1280 URL of image with maximum size 1280x1024px.
  * @param photo_2560 URL of image with maximum size 2560x2048px.
  * @param width Width (in pixels) of the original photo.
  * @param height Height (in pixels) of the original photo.
  * @param text Text describing the photo.
  * @param date Date (in Unix time) the photo was added.
  */
case class Photo(id: Long,
                 album_id: Long,
                 owner_id: Long,
                 user_id: Long,
                 photo_75: String,
                 photo_130: String,
                 photo_604: String,
                 photo_807: String,
                 photo_1280: String,
                 photo_2560: String,
                 width: Int,
                 height: Int,
                 text: String,
                 date: Long)

object Photo {
  implicit val photoReads = Json.reads[Photo]
}