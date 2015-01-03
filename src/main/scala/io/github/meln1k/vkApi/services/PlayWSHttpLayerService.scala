package io.github.meln1k.vkApi.services

import com.ning.http.client.AsyncHttpClientConfig
import io.github.meln1k.vkApi.utils.AccessToken
import play.api.libs.ws.{WSClient, DefaultWSClientConfig}
import play.api.libs.ws.ning.{NingWSClient, NingAsyncHttpClientConfigBuilder}
import javax.inject.Singleton
import scala.concurrent.ExecutionContext.Implicits.global


@Singleton
class PlayWSHttpLayerService extends HttpLayerService {

  private val apiUrl = "https://api.vk.com/method/"

  private val apiVersion = "5.27"

  val config = new NingAsyncHttpClientConfigBuilder(DefaultWSClientConfig()).build()
  val builder = new AsyncHttpClientConfig.Builder(config)
  val wsClient: WSClient = new NingWSClient(builder.build())

  def apiRequest(methodName: String, params: Seq[(String,String)])(implicit accessToken: AccessToken) = {
    wsClient.url(apiUrl+methodName)
      .withQueryString(params.filter(_._2.nonEmpty):_*)
      .withQueryString("access_token" -> accessToken.token)
      .withQueryString("v" -> apiVersion)
      .get()
      .map(_.json)
  }
}
