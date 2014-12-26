package io.github.meln1k.vkApi.methods.users

import io.github.meln1k.vkApi.models.error.ErrorMessage
import io.github.meln1k.vkApi.models.user.ComplaintType.ComplaintType
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

  def get(userIds: Set[String] = Set.empty,
          fields: Set[UserField] = Set.empty,
          nameCase: Option[NameCase] = None): Future[Seq[User]] = {
    httpLayerService.apiRequest("users.get", Vector(
      "user_ids" -> userIds.mkString(","),
      "fields" -> (fields + UserField.uid).mkString(","),
      "name_case" -> nameCase.fold("")(_.toString)
    )).map2seq[User]
  }

  def search(query: Option[String] = None,
             sort: Option[Int] = None,
             offset: Option[Int] = None,
             count: Option[Int] = None,
             fields: Set[UserField] = Set.empty,
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
             groupId: Option[Int] = None): Future[UserList] = {
    httpLayerService.apiRequest("users.search", Vector(
      "q" -> query,
      "sort" -> sort,
      "offset" -> offset,
      "count" -> count,
      "fields" -> (fields + UserField.uid).mkString(","),
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
    )).map2[UserList]
  }

  def isAppUser(userId: Option[Int] = None): Future[Boolean] = {
    httpLayerService.apiRequest("users.isAppUser", Vector(
      "user_id" -> userId
    )).map2[Int].map(_ != 0)
  }

  def getSubscriptions(userId: Option[Int] = None,
                       extended: Option[Boolean] = None,
                       offset: Int = 0,
                       count: Option[Int] = None,
                       fields: Set[String] = Set.empty): Future[Either[SubscriptionsList, ExtendedSubscriptionsList]] = {
    val jsVal = httpLayerService.apiRequest("users.getSubscriptions", Vector(
      "user_id" -> userId,
      "extended" -> extended,
      "offset" -> offset.toString,
      "count" -> count,
      "fields" -> fields.mkString(",")
    ))
    if (extended.getOrElse(false)) {
      jsVal.map2[ExtendedSubscriptionsList].map(Right(_))
    } else {
      jsVal.map2[SubscriptionsList].map(Left(_))
    }
  }

  def getFollowers(userId: Option[Int] = None,
                   fields: Set[UserField] = Set.empty,
                   offset: Option[Int] = None,
                   count: Option[Int] = None,
                   nameCase: Option[NameCase] = None): Future[UserList] = {
    httpLayerService.apiRequest("users.getFollowers", Vector(
      "user_ids" -> userId,
      "fields" -> (fields + UserField.uid).mkString(","), //dirty hach for correct user processing
      "offset" -> offset,
      "count" -> count,
      "name_case" -> nameCase.fold("")(_.toString)
    )).map2[UserList]
  }

  def report(userId: Int, typeComp: ComplaintType, comment: String = ""): Future[Int] = {
    httpLayerService.apiRequest("users.report", Vector(
      "user_id" -> userId.toString,
      "type" -> typeComp.toString,
      "comment" -> comment
    )).map2[Int]
  }

  def getNearby(latitude: Double,
                longitude: Double,
                accuracy: Option[Int] = None,
                timeout: Int = 7200,
                radius: Int = 1,
                fields: Set[UserField] = Set.empty,
                nameCase: Option[NameCase] = None): Future[UserList] = {
    httpLayerService.apiRequest("users.getNearby", Vector(
      "latitude" -> latitude.toString,
      "longitude" -> longitude.toString,
      "accuracy" -> accuracy,
      "timeout" -> timeout.toString,
      "radius" -> radius.toString,
      "fields" -> (fields + UserField.uid).mkString(","),
      "name_case" -> nameCase.fold("")(_.toString)
    )).map2[UserList]
  }
}

object UserUtils {
  implicit def intOpt2Str(i: Option[Int]): String = i.fold("")(_.toString)

  implicit def strOpt2Str(s: Option[String]): String = s.getOrElse("")

  implicit def boolOpt2Str(b: Option[Boolean]): String = b.fold("")(if (_) "1" else "0")
}
