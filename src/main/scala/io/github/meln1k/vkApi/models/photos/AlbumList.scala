package io.github.meln1k.vkApi.models.photos

import play.api.libs.json.Json

/**
 * Created by user on 02.02.2015.
 */
case class AlbumList(count: Int, items: Seq[Album])

object AlbumList {
  implicit val albumListReads = Json.reads[AlbumList]
}
