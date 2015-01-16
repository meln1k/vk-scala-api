/**
 * Created by user on 16.01.2015.
 */

import io.github.meln1k.vkApi.methods.Photos
import io.github.meln1k.vkApi.models.photos._
import io.github.meln1k.vkApi.services.PlayWSHttpLayerService
import io.github.meln1k.vkApi.utils.{FakeAccessToken, RealAccessToken, ApiError}
import org.specs2.mutable._
import org.specs2.time.NoTimeConversions

import scala.concurrent.Await
import scala.concurrent.duration._
class PhotosSpec extends Specification with NoTimeConversions {
  implicit val testToken = RealAccessToken("66caf3a8a168a24755695a644492a41d4de2a5e117acc36b23920593bbe3dd7eeeb691b4a615d45dd9c46")
  val photos = new Photos() with PlayWSHttpLayerService
  val timeout = 5.second
  sequential
  "Photos methods" should {
    "retrieve result object after successful album creation" in {
      val crAlRes = photos.createAlbum("TestAlbum", 185014513, "Some test album", Some(0), Some(0))
      Await.result(crAlRes, timeout) must beAnInstanceOf[CreateAlbumResult]
    }
  }
}
