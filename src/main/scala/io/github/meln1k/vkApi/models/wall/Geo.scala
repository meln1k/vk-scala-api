package io.github.meln1k.vkApi.models.wall

import play.api.libs.json.Json


case class Geo(`type`: String,
               coordinates: String,
               place: Place)

object Geo {
  implicit val geoReads = Json.reads[Geo]
}
