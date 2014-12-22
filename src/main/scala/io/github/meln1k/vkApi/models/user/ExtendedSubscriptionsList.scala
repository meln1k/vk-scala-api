package io.github.meln1k.vkApi.models.user

import play.api.libs.json._
import play.api.libs.json.Reads._
import play.api.libs.functional.syntax._

case class ExtendedSubscriptionsList(count: Int, items: Seq[Either[Community, User]])

object ExtendedSubscriptionsList {
  implicit val extendedSubscriptionsListReads = Json.reads[ExtendedSubscriptionsList]

  implicit val eitherCommunityOrUserReads: Reads[Either[Community, User]] = new Reads[Either[Community, User]] {
    def reads(json: JsValue): JsResult[Either[Community, User]] = {
      (json \ "type").as[String] match {
        case "page" | "group" | "event" =>
          JsSuccess(Left(json.as[Community]))
        case "profile" =>
          JsSuccess(Right(json.as[User]))
      }
    }
  }
}
