package io.github.meln1k.vkApi.models.wall

import play.api.libs.json.Json


case class App(id: Long,
               name: String,
               photo_130: String,
               photo_604: String)

object App {
  implicit val appReads = Json.reads[App]
}