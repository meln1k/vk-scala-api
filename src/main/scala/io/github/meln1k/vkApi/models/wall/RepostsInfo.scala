package io.github.meln1k.vkApi.models.wall

import play.api.libs.json.Json

/** Information about reposts (Share with friends); an object containing:
  *
  * @param count Number of users who copied the post.
  * @param user_reposted Whether the user reposted the post (0 — not reposted, 1 — reposted). ''Desktop apps only.''
  */
case class RepostsInfo(count: Int, user_reposted: Option[Int])

object RepostsInfo {
  implicit val repostsInfoReads = Json.reads[RepostsInfo]
}