package io.github.meln1k.vkApi.models.wall

import play.api.libs.json.Json


case class Place(id: Option[Long],
                 title: Option[String],
                 latitude: Double,
                 longitude: Double,
                 created: Option[Long],
                 icon: String,
                 country: String,
                 city: String,
                 `type`: Option[String],
                 group_id: Option[Long],
                 group_photo: Option[String],
                 checkins: Option[Int],
                 updated: Option[Int],
                 address: Option[String])

object Place {
  implicit val placeReads = Json.reads[Place]
}
