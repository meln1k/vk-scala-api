package io.github.meln1k.vkApi.models.wall

import play.api.libs.json.Json

/** Information about likes to the post; an object containing:
  *
  * @param count Number of users who liked the post.
  * @param user_likes Whether the user liked the post (0 — not liked, 1 — liked). ''Desktop apps only.''
  * @param can_like Whether the user can like the post (0 — cannot, 1 — can). ''Desktop apps only.''
  * @param can_publish Whether the user can repost (0 — cannot, 1 — can). ''Desktop apps only.''
  */
case class LikesInfo(count: Int, user_likes: Option[Int], can_like: Option[Int], can_publish: Option[Int])

object LikesInfo {
  implicit val likesInfoReads = Json.reads[LikesInfo]
}
