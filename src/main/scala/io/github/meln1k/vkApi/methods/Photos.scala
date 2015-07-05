package io.github.meln1k.vkApi.methods

import io.github.meln1k.vkApi.utils.AccessToken
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



  /** Creates album in specified group/user page, and returns info back.
    * Application must have access to user's/group photos.
    *
    * @param title Title of the album. ''Minimum two characters.''
    * @param group_id  ''id'' of group/user page, where album is created. Requires "0" to create album on your page.
    *                Throws "Access denied" otherwise.
    * @param description Short description of the album shown under the name on mouse hover.
    * @param privacy Integer which sets access level to the album: {{{
    * ''0'' - all users;
    * ''1'' - friends only;
    * ''2'' - friends and their friends only;
    * ''3'' - no one (only me).
    * User's album only
    * }}}
    * @param comment_privacy Integer which sets access level to commentaries of the album: {{{
    * ''0'' - all users;
    * ''1'' - friends only;
    * ''2'' - friends and their friends only;
    * ''3'' - no one (only me).
    * User's album only
    * }}}
    * @param upload_by_admins_only Integer which grants access to uploading function: {{{
    * ''0'' - all users;
    * ''1'' - admins and moderators only.
    * Group album only
    * }}}
    * @param comments_disabled Integer which sets comments availability: {{{
    * ''0'' - comments enabled;
    * ''1'' - comments disabled.
    * Group album only
    * }}}
    * @return Returns structure with album's creation info if successful, otherwise throws ApiError.
    * */
  def createAlbum(title: String,
                  group_id: Long,
                  description: String,
                  privacy: Option[Int] = None,
                  comment_privacy: Option[Int] = None,
                  upload_by_admins_only: Option[Int] = None,
                  comments_disabled: Option[Int] = None): Future[CreateAlbumResult] = {
    apiRequest("photos.createAlbum", Vector(
      "title" -> title,
      "group_id" -> group_id.toString,
      "description" -> description,
      "privacy" -> privacy,
      "comment_privacy" -> comment_privacy,
      "upload_by_admins_only" -> upload_by_admins_only,
      "comments_disabled" -> comments_disabled
    )).map2[CreateAlbumResult]
  }


  /** Edits album's info. Application must have access to user's/group photos.
   *
   * @param album_id ''id'' of album being edited.
   * @param title New title for album.
   * @param description New description for album.
   * @param owner_id ''id'' of album's owner. Group's id must be negative.
   * @param privacy Integer which sets access level to the album: {{{
   * ''0'' - all users;
   * ''1'' - friends only;
   * ''2'' - friends and their friends only;
   * ''3'' - no one (only me).
   * User's album only
   * }}}
   * @param comment_privacy Integer which sets access level to commentaries of the album: {{{
   * ''0'' - all users;
   * ''1'' - friends only;
   * ''2'' - friends and their friends only;
   * ''3'' - no one (only me).
   * User's album only
   * }}}
   * @param upload_by_admins_only Integer which grants access to uploading function: {{{
   * ''0'' - all users;
   * ''1'' - admins and moderators only.
   * Group album only
   * }}}
   * @param comments_disabled Integer which sets comments availability: {{{
   * ''0'' - comments enabled;
   * ''1'' - comments disabled.
   * Group album only
   * @return Returns 1 if successful.
   */
  def editAlbum(album_id: Long,
                title: Option[String] = None,
                description: Option[String] = None,
                owner_id: Long,
                privacy: Option[Int] = None,
                comment_privacy: Option[Int] = None,
                upload_by_admins_only: Option[Int] = None,
                comments_disabled: Option[Int] = None): Future[Boolean] = {
    apiRequest("photos.editAlbum", Vector(
      "album_id" -> album_id.toString,
      "title" -> title,
      "description" -> description,
      "owner_id" -> owner_id.toString,
      "privacy" -> privacy,
      "comment_privacy" -> comment_privacy,
      "upload_by_admins_only" -> upload_by_admins_only,
      "comments_disabled" -> comments_disabled
    )).map2[Int].map(_ != 0)
  }

  def getAlbums(owner_id: Long,
                album_ids: Set[Long] = Set.empty,
                offset: Option[Long] = None,
                count: Option[Long] = None,
                need_system: Option[Int] = None,
                need_covers: Option[Int] = None,
                photo_sizes: Option[Int] = None): Future[AlbumList] = {
    apiRequest("photos.getAlbums", Vector(
      "owner_id" -> owner_id.toString,
      "album_ids" -> album_ids.mkString(","),
      "offset" -> offset,
      "count" -> count,
      "need_system" -> need_system,
      "need_covers" -> need_covers,
      "photo_sizes" -> photo_sizes
    )).map2[AlbumList]
  }



}
