package io.github.meln1k.vkApi.models.users

import play.api.libs.json._

/**
 * v5.27
 */
case class User(id: Long,
                first_name: String,
                last_name: String,
                online: Option[Int],
                photo_200: Option[String],
                counters: Option[Counters],
                status: Option[String])

object User {
  implicit val userReads = Json.reads[User]
}
