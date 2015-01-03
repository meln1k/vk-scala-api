package io.github.meln1k.vkApi.services

import io.github.meln1k.vkApi.utils.AccessToken

import scala.concurrent.Future
import play.api.libs.json._

abstract class HttpLayerService {
  def apiRequest(methodName: String, params: Seq[(String,String)])(implicit accessToken: AccessToken): Future[JsValue]
}
