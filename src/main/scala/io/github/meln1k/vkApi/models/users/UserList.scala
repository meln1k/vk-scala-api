package io.github.meln1k.vkApi.models.users

import play.api.libs.json.Json


case class UserList(count: Int, items: Seq[User])

object UserList {
  implicit val userListReads = Json.reads[UserList]
}

case class User2List(count: Int, items: Seq[User2])

object User2List {
  implicit val user2ListReads = Json.reads[User2List]
}

case class UserIdsList(count: Int, items: Seq[Long])

object UserIdsList {
  implicit val user2ListReads = Json.reads[UserIdsList]
}