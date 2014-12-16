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

  def get(userIds: Seq[String] = Seq.empty,
          fields: Seq[UserField] = Seq.empty,
          nameCase: Option[NameCase] = None): Future[Seq[User]] = {
    httpLayerService.apiRequest("users.get", Vector(
      "user_ids" -> userIds.mkString(","),
      "fields" -> fields.mkString(","),
      "name_case" -> nameCase.fold("")(_.toString)
    )).map{json =>
      (json \ "response").validate[Vector[User]].get
    }
  }

  def search( q: Option[String] = None,
              sort: Option[Int] = None,
              offset: Option[Int] = None,
              count: Option[Int]= None,
              fields: Seq[UserField]= Vector.empty,
              city: Option[Int] = None,
              country: Option[Int] = None,
              hometown: Option[String] = None,
              universityCountry: Option[Int] = None,
              university: Option[Int] = None,
              universityYear: Option[Int] = None,
              universityFaculty: Option[Int] = None,
              universityChair: Option[Int] = None,
              sex: Option[Int] = None,
              status: Option[Int] = None,
              ageFrom: Option[Int] = None,
              ageTo: Option[Int] = None,
              birthDay: Option[Int] = None,
              birthMonth: Option[Int] = None,
              birthYear: Option[Int] = None,
              online: Option[Boolean] = None,
              hasPhoto: Option[Boolean] = None,
              schoolCountry: Option[Int] = None,
              schoolCity: Option[Int] = None,
              schoolClass: Option[Int] = None,
              school: Option[Int] = None,
              schoolYear: Option[Int] = None,
              religion: Option[String] = None,
              interests: Option[String] = None,
              company: Option[String] = None,
              position: Option[String] = None,
              groupId: Option[Int] = None): Future[Seq[User]] = ???

  def isAppUser = ???

  def getSubscriptions = ???

  def getFollowers = ???

  def report = ???

  def getNearby = ???
}
