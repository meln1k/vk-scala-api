package io.github.meln1k.vkApi.models.users

import play.api.libs.json.Json

/** A Community object describes a community and contains the following fields:
  *
  * @param id Community ID.
  * @param name Community name.
  * @param screen_name Screen name of the community page (e.g. apiclub or club1).
  * @param is_closed Whether the community is closed (0 — open, 1 — closed, 2 — private).
  * @param deactivated Whether the community is deleted or blocked (deleted - community is deleted, blocked - community is blocked).
  * @param is_admin Whether a user is the community manager (0 — is not the manager, 1 — is the manager).
  * @param admin_level (If is_admin=1) Rights of the user (1 — moderator, 2 — editor, 3 — administrator).
  * @param is_member Whether a user is a community member (0 — is not а member, 1 — is a member).
  * @param `type` Community type (group — group, page — public page, event — event).
  * @param photo_50 URL of the 50px-wide community logo.
  * @param photo_100 URL of the 100px-wide community logo.
  * @param photo_200 URL of the 200px-wide community logo.
  */
case class Community(id: Long,
                     name: String,
                     screen_name: String,
                     is_closed: Int,
                     deactivated: Option[String],
                     is_admin: Option[Int],
                     admin_level: Option[Int],
                     is_member: Option[Int],
                     `type`: String,
                     photo_50: String,
                     photo_100: String,
                     photo_200: String)

object Community {
  implicit val communityReads = Json.reads[Community]
}


