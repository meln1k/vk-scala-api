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
  implicit val testToken = RealAccessToken("")
  val photos = new Photos() with PlayWSHttpLayerService
  val timeout = 5.second
  sequential
  "Photos methods" should {
    "[createAlbum]retrieve result object after successful album creation" in {
      val crAlRes = photos.createAlbum("TestAlbum", 0, "zzz", Some(0), Some(0))
      Await.result(crAlRes, timeout) must beAnInstanceOf[CreateAlbumResult]
      //Requires "0" in id field to create album on your page. Throws "Access denied" otherwise.
    }
    "[createAlbum]do the same for group" in {
      val crAlRes = photos.createAlbum("TestAlbum", 85916709, "Another test album", Some(0), Some(0), Some(0), Some(0))
      Await.result(crAlRes, timeout) must beAnInstanceOf[CreateAlbumResult]
    }
    "[editAlbum]result must be equal to 1" in {
      val res = photos.editAlbum(210842967, Some("edited album"), Some("edited description"), 23309868)
      Await.result(res, timeout) must be equalTo true
    }
    "[editAlbum]same for group" in {
      val res = photos.editAlbum(211177374, Some("edited album"), Some("edited description"), -85916709)
      Await.result(res, timeout) must be equalTo true
    }
  }
}
