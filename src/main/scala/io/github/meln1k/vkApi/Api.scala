package io.github.meln1k.vkApi

import io.github.meln1k.vkApi.methods._
import io.github.meln1k.vkApi.models.auth.Permission
import io.github.meln1k.vkApi.models.auth.Permission.Permission
import io.github.meln1k.vkApi.services.PlayWSHttpLayerService
import io.github.meln1k.vkApi.utils.{AccessToken, DeferredAccessToken, FakeAccessToken, PredefinedAccessToken}


class Api(token: AccessToken) {

  private implicit val at = token

  lazy val users = new Users with PlayWSHttpLayerService

  lazy val auth = new Authorization with PlayWSHttpLayerService

  lazy val groups = new Groups with PlayWSHttpLayerService

  def wall = ???

  def photos = ???

  def friends = ???

  def widgets = ???

  def storage = ???

  def status = ???

  def audio = ???

  def pages = ???

  def board = ???

  def video = ???

  def notes = ???

  def places = ???

  def account = ???

  def messages = ???

  def newsfeed = ???

  def likes = ???

  def polls = ???

  def docs = ???

  def fave = ???

  def notifications = ???

  def stats = ???

  def search = ???

  def apps = ???

  def utils = ???

  def database = ???

  def gifts = ???

  def execute = ???

}

object Api extends {

  def fromLoginPass(login: String, password: String, appId: String, scope: Set[Permission] = Permission.values) =
    new Api(DeferredAccessToken(login, password, appId, scope))

  def withAccessToken(accessToken: String) = new Api(PredefinedAccessToken(accessToken))

  def anonymous = new Api(FakeAccessToken)

}
