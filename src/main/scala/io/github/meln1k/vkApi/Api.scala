package io.github.meln1k.vkApi

import io.github.meln1k.vkApi.methods.users.Users


class Api(token: AccessToken) {

  implicit val at = token

  lazy val users = new Users

  def auth = ???

  def wall = ???

  def photos = ???

  def friends = ???

  def widgets = ???

  def storage = ???

  def status = ???

  def audio = ???

  def pages = ???

  def groups = ???

  def board = ???

  def video = ???

  def notes = ???

  def places = ???

  def accout = ???

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

  def fromLoginPass(login: String, password: String) = ???

  def withAccessToken(accessToken: String) = ???

  def anonymous = new Api(FakeAccessToken)

}
