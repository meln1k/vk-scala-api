package io.github.meln1k.vkApi.models.wall

import play.api.libs.json.Json


case class Graffiti(id: Long,
                    owner_id: Long,
                    photo_200: Long,
                    photo_586: Long)

object Graffiti {
  implicit val graffitiReads = Json.reads[Graffiti]
}