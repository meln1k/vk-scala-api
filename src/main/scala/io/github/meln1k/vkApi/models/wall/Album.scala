package io.github.meln1k.vkApi.models.wall

import io.github.meln1k.vkApi.models.photos.Photo
import play.api.libs.json.Json


case class Album(id: Long,
                 thumb: Photo,
                 owner_id: Long,
                 title: String,
                 description: String,
                 created: Long,
                 updated: Long,
                 size: Int)

object Album {
  implicit val albumReads = Json.reads[Album]
}