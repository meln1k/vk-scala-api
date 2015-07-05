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

case class User2(id: Long,
                 first_name: String,
                 last_name: String,
                 sex: Option[Int],
                 domain:Option[String],
                 bdate:Option[String],
                 city: Option[City],
                 country: Option[Country]
                  )
//{"id":323,"first_name":"Алексей","last_name":"Орлов","sex":2,"domain":"id323"}
case class City(id: Long, title: String)
case class Country(id: Long, title: String)


object City {
  implicit val cityReads = Json.reads[City]
}
object Country {
  implicit val countryReads = Json.reads[Country]
}

object User2 {
  implicit val user2Reads = Json.reads[User2]
}