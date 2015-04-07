package io.github.meln1k.vkApi.utils

import io.github.meln1k.vkApi.models.auth.Permission
import org.specs2.mutable.Specification

class DeferredAccessTokenTest extends Specification {

  sequential
  "Deferred AccessToken" should {
    "Form correct url" in {
      val testedUrl = DeferredAccessToken("woid@list.ru", ",tutvjn31415926", "3731033", Set(Permission.wall, Permission.docs)).url
      testedUrl mustEqual "http://oauth.vk.com/oauth/authorize?" +
      "redirect_uri=http://oauth.vk.com/blank.html&response_type=token&" +
        "client_id=3731033&display=wap&scope=wall,docs"
    }
  }
}
