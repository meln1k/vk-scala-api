package io.github.meln1k.vkApi.methods.users

import io.github.meln1k.vkApi.methods.users.utils.{UserField, NameCase}
import io.github.meln1k.vkApi.services.HttpLayerService
import io.github.meln1k.vkApi. AccessToken
import NameCase.NameCase
import UserField.UserField
import io.github.meln1k.vkApi.InjectHelper._

object Users  {

  val httpLayerService = inject[HttpLayerService]

  def get(userIds: Seq[String] = Seq.empty, fields: Seq[UserField] = Seq.empty, nameCase: Seq[NameCase] = Seq.empty)
         (implicit accessToken: AccessToken) = {
    httpLayerService.apiRequest("users.get", Vector(
      "user_ids" -> userIds.mkString(","),
      "fields" -> fields.mkString(","),
      "name_case" -> nameCase.mkString(",")
    ))
  }

  def search = ???

  def isAppUser = ???

  def getSubscriptions = ???

  def getFollowers = ???

  def report = ???

  def getNearby = ???
}
