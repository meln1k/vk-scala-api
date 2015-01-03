package io.github.meln1k.vkApi.methods.users

import io.github.meln1k.vkApi.models.users.ComplaintType.ComplaintType
import io.github.meln1k.vkApi.models.users._
import io.github.meln1k.vkApi.services.HttpLayerService
import io.github.meln1k.vkApi.AccessToken
import io.github.meln1k.vkApi.utils.ApiFutureUtils._
import NameCase.NameCase
import UserField.UserField
import io.github.meln1k.vkApi.InjectHelper._
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import io.github.meln1k.vkApi.utils.OptionUtils._

class Users(implicit accessToken: AccessToken) {

  val httpLayerService = inject[HttpLayerService]

  /** Returns detailed information on users.
    *
    * This is an open method; it does not require an access_token.
    *
    * @param userIds User IDs or screen names (screen_name). By default, current user ID.
    *                ''The maximum number of elements allowed is 1000''
    * @param fields Profile fields to return.
    * @param nameCase Case for declension of user name and surname: {{{
    * `nom` — nominative (default)
    * `gen` — genitive
    * `dat` — dative
    * `acc` — accusative
    * `ins` — instrumental
    * `abl` — prepositional
    * }}}
    * @return Returns a list of [[io.github.meln1k.vkApi.models.users.User]] objects.
    */
  def get(userIds: Set[String] = Set.empty,
          fields: Set[UserField] = Set.empty,
          nameCase: Option[NameCase] = None): Future[Seq[User]] = {
    httpLayerService.apiRequest("users.get", Vector(
      "user_ids" -> userIds.mkString(","),
      "fields" -> (fields + UserField.uid).mkString(","),
      "name_case" -> nameCase.fold("")(_.toString)
    )).map2seq[User]
  }

  /** Returns a list of users matching the search criteria.
    *
    * This method doesn't require any specific rights.
    *
    * @param query Search query string (e.g., Vasya Babich).
    * @param sort Sort order: {{{
    * 1 — by date registered
    * 0 — by rating
    * }}} ''positive number''
    * @param offset Offset needed to return a specific subset of users. ''positive number''
    * @param count Number of users to return. ''positive number, default 20, maximum value 1000''
    * @param fields Profile fields to return.
    * @param city City ID. ''positive number''
    * @param country Country ID. ''positive number''
    * @param hometown City name in a string.
    * @param universityCountry ID of the country where the user graduated. ''positive number''
    * @param university ID of the institution of higher education. ''positive number''
    * @param universityYear Year of graduation from an institution of higher education. ''positive number''
    * @param universityFaculty ''positive number''
    * @param universityChair ''positive number''
    * @param sex {{{
    * 1 — female
    * 2 — male
    * 0 — any (default)
    * }}} ''positive number''
    * @param status Relationship status: {{{
    * 1 — Not married
    * 2 — In a relationship
    * 3 — Engaged
    * 4 — Married
    * 5 — It's complicated
    * 6 — Actively searching
    * 7 — In love
    * }}} ''positive number''
    * @param ageFrom Minimum age. ''positive number''
    * @param ageTo Maximum age. ''positive number''
    * @param birthDay Day of birth. ''positive number''
    * @param birthMonth Month of birth. ''positive number''
    * @param birthYear Year of birth. ''positive number''
    * @param online {{{
    * 1 — online only
    * 0 — all users
    * }}} ''flag, either true or false''
    * @param hasPhoto {{{
    * 1 — with photo only
    * 0 — all users
    * }}} ''flag, either true or false''
    * @param schoolCountry ID of the country where users finished school. ''positive number''
    * @param schoolCity ID of the city where users finished school. ''positive number''
    * @param schoolClass ''positive number''
    * @param school ID of the school. ''positive number''
    * @param schoolYear School graduation year. ''positive number''
    * @param religion Users' religious affiliation.
    * @param interests Users' interests.
    * @param company Name of the company where users work.
    * @param position Job position.
    * @param groupId ID of a community to search in communities. ''positive number''
    * @return Returns a list of [[io.github.meln1k.vkApi.models.users.User]] objects.
    */
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

  /** Returns information whether a user installed the application.
    *
    * This method doesn't require any specific rights.
    *
    * @param userId User ID.
    * @return Returns `true` if the user installed the application; otherwise returns `false`.
    */
  def isAppUser(userId: Option[Int] = None): Future[Boolean] = {
    httpLayerService.apiRequest("users.isAppUser", Vector(
      "user_id" -> userId
    )).map2[Int].map(_ != 0)
  }

  /** Returns a list of IDs of users and communities followed by the user.
    *
    * This is an open method; it does not require an access_token.
    *
    * @param userId User ID. ''positive number, current user id is used by default''
    * @param extended {{{
    * 1 — to return a combined list of users and communities
    * 0 — to return separate lists of users and communities (default)
    * }}} ''flag, either true or false''
    * @param offset Offset needed to return a specific subset of subscriptions. ''positive number''
    * @param count Number of users and communities to return. ''positive number, default 20, maximum value 200''
    * @param fields
    * @return Returns user and community objects, each containing the following fields: {{{
    * count — The number of results.
    * items — The list of IDs of users/communities followed by the user.
    * }}}
    * If extended is set to 1, returns a combined list of [[io.github.meln1k.vkApi.models.users.User]] objects
    * and [[io.github.meln1k.vkApi.models.users.Community]] objects.
    */
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

  /** Returns a list of IDs of followers of the user in question, sorted by date added, most recent first.
    *
    * This is an open method; it does not require an access_token.
    *
    * @param userId User ID. ''positive number, current user id is used by default''
    * @param offset Offset needed to return a specific subset of followers. ''positive number''
    * @param count Number of followers to return. ''positive number, default 100, maximum value 1000''
    * @param fields Profile fields to return.
    * @param nameCase Case for declension of user name and surname: {{{
    * `nom` — nominative (default)
    * `gen` — genitive
    * `dat` — dative
    * `acc` — accusative
    * `ins` — instrumental
    * `abl` — prepositional
    * }}}
    * @return Returns a [[io.github.meln1k.vkApi.models.users.UserList]].
    */
  def getFollowers(userId: Option[Int] = None,
                   offset: Option[Int] = None,
                   count: Option[Int] = None,
                   fields: Set[UserField] = Set.empty,
                   nameCase: Option[NameCase] = None): Future[UserList] = {
    httpLayerService.apiRequest("users.getFollowers", Vector(
      "user_ids" -> userId,
      "fields" -> (fields + UserField.uid).mkString(","), //dirty hach for correct user processing
      "offset" -> offset,
      "count" -> count,
      "name_case" -> nameCase.fold("")(_.toString)
    )).map2[UserList]
  }

  /** Reports (submits a complain about) a user.
    *
    * This method is available only to standalone-applications.
    *
    * @param userId ID of the user about whom a complaint is being made.
    * @param typeComp Type of complaint: {{{
    * porn – pornography
    * spam – spamming
    * insult – abusive behavior
    * advertisment – disruptive advertisements
    * }}}
    * @param comment Comment describing the complaint.
    * @return Returns 1.
    */
  def report(userId: Int, typeComp: ComplaintType, comment: String = ""): Future[Int] = {
    httpLayerService.apiRequest("users.report", Vector(
      "user_id" -> userId.toString,
      "type" -> typeComp.toString,
      "comment" -> comment
    )).map2[Int]
  }

  /**
   * This method is available only to standalone-applications.
   *
   * @param latitude
   * @param longitude
   * @param accuracy
   * @param timeout
   * @param radius
   * @param fields
   * @param nameCase
   * @return
   */
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

