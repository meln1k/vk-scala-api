import io.github.meln1k.vkApi
import io.github.meln1k.vkApi.models.user._
import io.github.meln1k.vkApi.utils.ApiError
import io.github.meln1k.vkApi.{RealAccessToken, FakeAccessToken}
import vkApi.methods.users.Users
import org.specs2.mutable._

import scala.concurrent.Await
import scala.concurrent.duration._

class UsersSpec extends Specification {
  implicit val testToken = RealAccessToken("66caf3a8a168a24755695a644492a41d4de2a5e117acc36b23920593bbe3dd7eeeb691b4a615d45dd9c46")
  val users = new Users
  sequential
  "Users methods" should {
    "retrieve user profile with selected fields in users.get" in {
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
      Await.result(user, 2000 milli) must beAnInstanceOf[Seq[User]]
    }

    "find users by some criteria" in {
      val user  = users.search(query = Some("Vasya Babich"))
      Await.result(user, 2000 milli) must beAnInstanceOf[UserList]
    }

    "throw an exeption when searching without read accessToken" in {
      val usersWOToken = new Users()(FakeAccessToken)
      val user  = usersWOToken.search(query = Some("Vasya Babich"))
      Await.result(user, 2000 milli) must throwA[ApiError]
    }

    "tell if current user is app user" in {
      val isAppUser = users.isAppUser()
      Await.result(isAppUser, 2000 milli) must haveClass[java.lang.Boolean]
    }

    "get user subscriptions" in {
      val subscriptions = users.getSubscriptions(userId = Some(3), extended = Some(false))
      Await.result(subscriptions, 2000 milli) must beLeft
    }

    "get extended user subscriptions" in {
      val subscriptions = users.getSubscriptions(userId = Some(3), extended = Some(true), count = Some(21))
      Await.result(subscriptions, 2000 milli) must beRight
    }

    "get user followers" in {
      val followers = users.getFollowers(Some(3))
      Await.result(followers, 2000 milli) must beAnInstanceOf[Seq[User]]
    }
  }
}
