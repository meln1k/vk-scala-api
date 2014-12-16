import io.github.meln1k.vkApi
import io.github.meln1k.vkApi.models.user.{UserField, User, NameCase}
import vkApi.FakeAccessToken
import vkApi.methods.users.Users
import org.specs2.mutable._

import scala.concurrent.Await
import scala.concurrent.duration._

class UsersSpec extends Specification {
  implicit val token = FakeAccessToken
  val users = new Users
  "Users methods" should {
    "retrieve user profile with selected fields" in {
      import UserField._
      import NameCase._
      val user = users.get(userIds = List("1"), fields = List(
        uid,
        first_name,
        last_name,
        online,
        photo_200,
        counters,
        status
      ), nameCase = Some(nom))
      val res = Await.result(user, 2000 milli)
      res must beAnInstanceOf[Vector[User]]
    }
  }
}
