package io.github.meln1k.vkApi.models.user

import play.api.libs.json._


case class ExtendedSubscriptionsList(count: Int, items: Seq[ItemsWrapper])

object ExtendedSubscriptionsList {
  implicit val extendedSubscriptionsListReads = Json.reads[ExtendedSubscriptionsList]
}
