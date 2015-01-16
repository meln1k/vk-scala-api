package io.github.meln1k.vkApi.methods

import io.github.meln1k.vkApi.utils.AccessToken
import io.github.meln1k.vkApi.models.photos.Photo
import io.github.meln1k.vkApi.models.photos._
import io.github.meln1k.vkApi.services.HttpLayerService
import io.github.meln1k.vkApi.utils.ApiFutureUtils._
import io.github.meln1k.vkApi.utils.OptionUtils._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

/**
 * Created by user on 16.01.2015.
 */

class Photos(implicit accessToken: AccessToken) { this: HttpLayerService =>

  def createAlbum(title: String,
                  group_id: Long,
                  description: String,
                  privacy: Option[Int] = None,
                  comment_privacy: Option[Int] = None,
                  upload_by_admins_only: Option[Int] = None,
                  comments_disabled: Option[Int] = None): Future[CreateAlbumResult] = {
    apiRequest("photos.createAlbum", Vector(
      "title" -> title,
      "description" -> description,
      "privacy" -> privacy,
      "comment_privacy" -> comment_privacy,
      "upload_by_admins_only" -> upload_by_admins_only,
      "comments_disabled" -> comments_disabled
    )).map2[CreateAlbumResult]
  }
}
