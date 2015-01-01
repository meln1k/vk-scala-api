package io.github.meln1k.vkApi.models.users

import play.api.libs.json.Json


case class SubscriptionsList(users: IdList, groups: IdList)

object SubscriptionsList {
  implicit val subscriptionsListReads = Json.reads[SubscriptionsList]
}
