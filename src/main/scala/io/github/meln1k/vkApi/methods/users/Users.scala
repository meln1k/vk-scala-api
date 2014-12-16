package io.github.meln1k.vkApi.methods.users

import io.github.meln1k.vkApi.models.user._
import io.github.meln1k.vkApi.services.HttpLayerService
import io.github.meln1k.vkApi.AccessToken
import NameCase.NameCase
import UserField.UserField
import io.github.meln1k.vkApi.InjectHelper._
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

class Users(implicit accessToken: AccessToken) {

  val httpLayerService = inject[HttpLayerService]

  def get(userIds: Seq[String] = Seq.empty, fields: Seq[UserField] = Seq.empty, nameCase: Option[NameCase] = None): Future[Vector[User]] = {
    httpLayerService.apiRequest("users.get", Vector(
      "user_ids" -> userIds.mkString(","),
      "fields" -> fields.mkString(","),
      "name_case" -> nameCase.fold("")(_.toString)
    )).map{json =>
      (json \ "response").validate[Vector[User]].get
    }
  }

  def search = ???

  def isAppUser = ???

  def getSubscriptions = ???

  def getFollowers = ???

  def report = ???

  def getNearby = ???
}
