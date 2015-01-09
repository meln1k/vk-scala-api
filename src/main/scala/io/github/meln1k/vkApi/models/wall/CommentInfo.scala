package io.github.meln1k.vkApi.models.wall

import play.api.libs.json.Json

/** Information about comments to the post; an object containing:
  *
  * @param count Number of comments.
  * @param can_post Whether the current user can leave comments to the post (0 — cannot, 1 — can). ''Desktop apps only.''
  */
case class CommentInfo(count: Int, can_post: Option[Int])

object CommentInfo {
  implicit val commentInfoReads = Json.reads[CommentInfo]
}
