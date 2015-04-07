package io.github.meln1k.vkApi.utils

import io.github.meln1k.vkApi.models.auth.Permission
import io.github.meln1k.vkApi.models.auth.Permission.Permission

sealed abstract class AccessToken {
  def token: Option[String]
}

case class PredefinedAccessToken(predefined: String) extends AccessToken {
  override def token = Some(predefined)
}

case class DeferredAccessToken(login: String, password: String, appId: String,
                               scope: Set[Permission] = Permission.values) extends AccessToken {
  override def token: Option[String] = {
    None
  }

  def url: String = {
    ("http://oauth.vk.com/oauth/authorize?" +
      "redirect_uri=http://oauth.vk.com/blank.html&response_type=token&" +
      "client_id=%s&display=wap&scope=%s") format(appId, scope.mkString(","))
  }
}

case object FakeAccessToken extends AccessToken {
  def token = Some("")
}
