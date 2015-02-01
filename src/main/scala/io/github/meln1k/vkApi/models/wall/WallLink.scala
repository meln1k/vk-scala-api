package io.github.meln1k.vkApi.models.wall

import play.api.libs.json.Json

/**
 * Created by nmelkozerov on 11/01/15.
 */
case class WallLink(url: String,
                    title: String,
                    description: String,
                    image_src: Option[String],
                    preview_page: Option[String],
                    preview_url: Option[String])

object WallLink {
  implicit val wallLinkReads = Json.reads[WallLink]
}
