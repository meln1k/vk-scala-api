package io.github.meln1k.vkApi.methods.users

import io.github.meln1k.vkApi.models.error.ErrorMessage
import io.github.meln1k.vkApi.models.user._
import io.github.meln1k.vkApi.services.HttpLayerService
import io.github.meln1k.vkApi.AccessToken
import io.github.meln1k.vkApi.utils.ApiFutureUtils._
import NameCase.NameCase
import UserField.UserField
import io.github.meln1k.vkApi.InjectHelper._
import io.github.meln1k.vkApi.utils.ApiError
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import UserUtils._

class Users(implicit accessToken: AccessToken) {

  val httpLayerService = inject[HttpLayerService]

  def get(userIds: Seq[String] = Seq.empty,
          fields: Seq[UserField] = Seq.empty,
          nameCase: Option[NameCase] = None): Future[Seq[User]] = {
    httpLayerService.apiRequest("users.get", Vector(
      "user_ids" -> userIds.mkString(","),
      "fields" -> fields.mkString(","),
      "name_case" -> nameCase.fold("")(_.toString)
    )).map2seq[User]
  }

  def search(query: Option[String] = None,
             sort: Option[Int] = None,
             offset: Option[Int] = None,
             count: Option[Int] = None,
             fields: Seq[UserField] = Vector.empty,
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
             groupId: Option[Int] = None): Future[Seq[User]] = {
    httpLayerService.apiRequest("users.search", Vector(
      "q" -> query,
      "sort" -> sort,
      "offset" -> offset,
      "count" -> count,
      "fields" -> fields.mkString(","),
      "city" -> city,
      "country" -> country,
      "hometown" -> hometown,
      "universityCountry" -> universityCountry,
      "university" -> university,
      "universityYear" -> universityYear,
      "universityFaculty" -> universityFaculty,
      "universityChair" -> universityChair,
      "sex" -> sex,
      "status" -> status,
      "ageFrom" -> ageFrom,
      "ageTo" -> ageTo,
      "birthDay" -> birthDay,
      "birthMonth" -> birthMonth,
      "birthYear" -> birthYear,
      "online" -> online,
      "hasPhoto" -> hasPhoto,
      "schoolCountry" -> schoolCountry,
      "schoolCity" -> schoolCity,
      "schoolClass" -> schoolClass,
      "school" -> school,
      "schoolYear" -> schoolYear,
      "religion" -> religion,
      "interests" -> interests,
      "company" -> company,
      "position" -> position,
      "groupId" -> groupId
    )).map2seq[User]
  }

  def isAppUser(userId: Option[Int] = None) = {
    httpLayerService.apiRequest("users.isAppUser", Vector(
      "user_id" -> userId
    )).map2[Int].map(_ != 0)
  }

  def getSubscriptions = ???

  def getFollowers = ???

  def report = ???

  def getNearby = ???
}

object UserUtils {
  implicit def intOpt2Str(i: Option[Int]): String = i.fold("")(_.toString)

  implicit def strOpt2Str(s: Option[String]): String = s.getOrElse("")

  implicit def boolOpt2Str(b: Option[Boolean]): String = b.fold("")(if (_) "1" else "0")
}
