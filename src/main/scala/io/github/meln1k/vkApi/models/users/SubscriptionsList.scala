package io.github.meln1k.vkApi.models.users

import play.api.libs.json._


case class SubscriptionsList(count: Int, items: Seq[Either[Community, User]])

object SubscriptionsList {
  implicit val subscriptionsListReads = Json.reads[SubscriptionsList]

  implicit def eitherReads[A, B](implicit A: Reads[A], B: Reads[B]): Reads[Either[A, B]] =
    Reads[Either[A, B]] { json =>
      A.reads(json) match {
        case JsSuccess(value, path) => JsSuccess(Left(value), path)
        case JsError(e1) => B.reads(json) match {
          case JsSuccess(value, path) => JsSuccess(Right(value), path)
          case JsError(e2) => JsError(JsError.merge(e1, e2))
        }
      }
    }
}
