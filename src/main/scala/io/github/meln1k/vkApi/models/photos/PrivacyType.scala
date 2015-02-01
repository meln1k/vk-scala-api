package io.github.meln1k.vkApi.models.photos

import play.api.libs.json.Json

/**
 * Created by user on 19.01.2015.
 */
case class PrivacyType (`type`: String)

object PrivacyType {
  implicit val privacyTypeReads = Json.reads[PrivacyType]
}
