package io.github.meln1k.vkApi.models.wall

import play.api.libs.json.Json


case class CopiedPost(id: Long,
                 owner_id: Long,
                 from_id: Long,
                 date: Long,
                 text: String,
                 post_type: String,
                 post_source: Option[PostSource],
                 attachments: Option[Seq[Attachment]])

object CopiedPost {
  implicit val copiedPostReads = Json.reads[CopiedPost]
}
