package io.github.meln1k.vkApi.models.audio

import play.api.libs.json.Json


case class Audio(id: Long,
                 owner_id: Long,
                 artist: String,
                 title: String,
                 duration: Int,
                 url: String,
                 lyrics_id: Option[Long],
                 album_id: Option[Long],
                 genre_id: Long)

object Audio {
  implicit val audioReads = Json.reads[Audio]
}
