package io.github.meln1k.vkApi.models.users

import play.api.libs.json.{JsSuccess, JsResult, JsValue, Reads}

/**
 * Created by nmelkozerov on 23/12/14.
 */
case class ItemsWrapper(data: Either[Community, User])

object ItemsWrapper {
  implicit val itemsWrapperReads: Reads[ItemsWrapper] = new Reads[ItemsWrapper] {
    def reads(json: JsValue): JsResult[ItemsWrapper] = {
      (json \ "type").as[String] match {
        case "page" | "group" | "event" =>
          JsSuccess(ItemsWrapper(Left(json.as[Community])))
        case "profile" =>
          JsSuccess(ItemsWrapper(Right(json.as[User])))
      }
    }
  }
}
