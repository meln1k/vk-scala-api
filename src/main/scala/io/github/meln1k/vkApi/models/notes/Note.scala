package io.github.meln1k.vkApi.models.notes

import play.api.libs.json.Json

/**
 * A note object describes a note and contains the following fields:
 * @param id Note ID. positive number
 * @param owner_id Note owner ID. positive number
 * @param title Note title.
 * @param text Note text.
 * @param date Date (in Unix time) when the note was created.
 * @param comments Number of comments.
 * @param read_comments Number of read comments (only if owner_id is the current user).
 * @param view_url Address of web page to view note.
 */
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
