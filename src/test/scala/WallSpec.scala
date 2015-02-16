import io.github.meln1k.vkApi.methods.Wall
import io.github.meln1k.vkApi.models.wall.{Post, PostsList}
import io.github.meln1k.vkApi.services.PlayWSHttpLayerService
import io.github.meln1k.vkApi.utils.RealAccessToken
import org.specs2.mutable.Specification
import org.specs2.time.NoTimeConversions

import scala.concurrent.Await
import scala.concurrent.duration._

class WallSpec extends VkSpecification {

  val wall = new Wall with PlayWSHttpLayerService

  "Wall methods" should {
    "get posts" in {
      val post = wall.get(ownerId = 185014513, offset=4, count = 1)
      val postRes = Await.result(post, timeout)
      postRes must beAnInstanceOf[PostsList]
    }

    "find posts" in {
      val post = wall.search(ownerId = 185014513, count = 10, query = "test")
      val postRes = Await.result(post, timeout)
      postRes must beAnInstanceOf[PostsList]
      postRes.items.exists(_.text.contains("test")) must be equalTo(true)
    }
  }
}
