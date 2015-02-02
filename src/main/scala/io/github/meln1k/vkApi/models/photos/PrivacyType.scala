package io.github.meln1k.vkApi.models.photos

import play.api.libs.json.Json

/**
 * Created by user on 19.01.2015.
 */
case class PrivacyType (`type`: String,
                        lists: Option[List[String]],
                        except_lists: Option[List[String]],
                        users: Option[List[String]],
                        except_users: Option[List[String]]
                        )

object PrivacyType {
  implicit val privacyTypeReads = Json.reads[PrivacyType]
}
