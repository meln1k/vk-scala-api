package io.github.meln1k.vkApi.methods


import io.github.meln1k.vkApi.models.geo.{Longitude, Latitude}
import io.github.meln1k.vkApi.models.wall.{PostId, Post, PostsList}
import io.github.meln1k.vkApi.models.wall.WallFilter._
import io.github.meln1k.vkApi.services.HttpLayerService
import io.github.meln1k.vkApi.utils.AccessToken
import io.github.meln1k.vkApi.utils.ToStringConverters._
import io.github.meln1k.vkApi.utils.ApiFutureUtils.FutureOps
import io.github.meln1k.vkApi.utils.ToStringConverters._
import scala.concurrent.Future


class Wall(implicit accessToken: AccessToken) { this: HttpLayerService =>

  def get(ownerId: Long = 0,
          domain: Option[String] = None,
          offset: Int = 0,
          count: Int = 20,
          filter: WallFilter = all,
          extended: Boolean = false): Future[PostsList] = {
    apiRequest("wall.get", Vector(
      "owner_id" -> ownerId.toString,
      "domain" -> domain,
      "offset" -> offset.toString,
      "count" -> count.toString,
      "filter" -> filter.toString,
      "extended" -> extended
    )).map2[PostsList]
  }

  def search(ownerId: Long = 0,
             domain: Option[String] = None,
             query: String,
             ownersOnly: Boolean = false,
             offset: Int = 0,
             count: Int = 20,
             extended: Boolean = false): Future[PostsList] = {
    apiRequest("wall.get", Vector(
      "owner_id" -> ownerId.toString,
      "domain" -> domain,
      "query" -> query,
      "offset" -> offset.toString,
      "count" -> count.toString,
      "extended" -> extended
    )).map2[PostsList]
  }

  def getById(posts: Seq[String], copyHistoryDepth: Int = 2) = {
    apiRequest("wall.getById", Vector(
      "posts" -> posts.mkString(","),
      "copy_history_depth" -> copyHistoryDepth.toString
    )).map2seq[Post]
  }
}
