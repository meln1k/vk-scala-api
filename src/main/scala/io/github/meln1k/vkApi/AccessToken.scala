package io.github.meln1k.vkApi

sealed abstract class AccessToken {
  def token: String
}

case class RealAccessToken(token: String) extends AccessToken

case object FakeAccessToken extends AccessToken {
  def token = ""
}
