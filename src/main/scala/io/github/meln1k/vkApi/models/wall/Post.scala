package io.github.meln1k.vkApi.models.wall

import play.api.libs.json.Json


case class Post(id: Long,
               owner_id: Long,
               from_id: Long,
               date: Long,
               text: String,
               reply_owner_id: Option[Long],
               reply_post_id: Option[Long],
               friends_only: Option[Int],
               comments: CommentInfo,
               likes: LikesInfo,
               reposts: RepostsInfo,
               post_type: String,
               post_source: Option[PostSource],
               attachments: Option[Seq[Attachment]],
               geo: Option[Geo],
               signer_id: Option[Long],
               copy_history: Option[Seq[CopiedPost]],
               can_pin: Option[Int],
               is_pinned: Option[Int])

object Post {
  implicit val postReads = Json.reads[Post]
}
