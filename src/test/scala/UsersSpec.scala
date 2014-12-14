import io.github.meln1k.vkApi
import play.api.libs.json.{JsSuccess, Json}
import vkApi.FakeAccessToken
import vkApi.methods.users.Users
import vkApi.methods.users.utils.User
import org.specs2.mutable._

import scala.concurrent.Await
import scala.concurrent.duration._

class UsersSpec extends Specification {
  implicit val token = FakeAccessToken
  val users = new Users
  "Users methods" should {
    "retrieve user profile" in {
      val user = users.get(Seq("1"))
      val res = Await.result(user, 2000 milli)
      val validated = (res \ "response").validate[Seq[User]]
      validated must haveClass[JsSuccess[User]]
    }
  }
}
