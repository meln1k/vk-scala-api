package io.github.meln1k.vkApi.models.docs

import play.api.libs.json.Json


case class Document(id: Long,
                    owner_id: Long,
                    title: String,
                    size: String,
                    ext: String,
                    url: String,
                    photo_100: Option[String],
                    photo_130: Option[String])

object Document {
  implicit val documentReads = Json.reads[Document]
}
