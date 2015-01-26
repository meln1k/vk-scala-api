package io.github.meln1k.vkApi.models.notes

import play.api.libs.json.Json


case class Note(id: Long,
                owner_id: Long,
                title: String,
                text: Option[String],
                date: Long,
                comments: Int,
                read_comments: Option[Int],
                view_url: String)

object Note {
  implicit val noteReads = Json.reads[Note]
}
