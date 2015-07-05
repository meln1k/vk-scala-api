import io.github.meln1k.vkApi.methods.Users
import io.github.meln1k.vkApi.models.geo.{Longitude, Latitude}
import io.github.meln1k.vkApi.models.users._
import io.github.meln1k.vkApi.services.PlayWSHttpLayerService
import io.github.meln1k.vkApi.utils.{ApiError, FakeAccessToken, PredefinedAccessToken}
import org.specs2.mutable._
import org.specs2.time.NoTimeConversions

import scala.concurrent.Await
import scala.concurrent.duration._

class UsersSpec extends Specification with NoTimeConversions {
  implicit val testToken = PredefinedAccessToken("66caf3a8a168a24755695a644492a41d4de2a5e117acc36b23920593bbe3dd7eeeb691b4a615d45dd9c46")
  val users = new Users with PlayWSHttpLayerService
  val timeout = 5.second
  sequential
  "Users methods" should {
    "retrieve user profile with selected fields in users.get" in {
      import NameCase._
      import UserField._
      val user = users.get(userIds = Set("1"), fields = Set(
        uid,
        first_name,
        last_name,
        online,
        photo_200,
        counters,
        status
      ), nameCase = Some(nom))
      Await.result(user, timeout) must beAnInstanceOf[Seq[User]]
    }

    "find users by some criteria" in {
      val user  = users.search(query = Some("Vasya Babich"))
      Await.result(user, timeout) must beAnInstanceOf[UserList]
    }

    "throw an exception when searching without read accessToken" in {
      val usersWOToken = new Users()(FakeAccessToken) with PlayWSHttpLayerService
      val user  = usersWOToken.search(query = Some("Vasya Babich"))
      Await.result(user, timeout) must throwA[ApiError]
    }

    "tell if current user is app user" in {
      val isAppUser = users.isAppUser()
      Await.result(isAppUser, timeout) must haveClass[java.lang.Boolean]
    }

    "get extended user subscriptions" in {
      val subscriptions = users.getSubscriptions(userId = Some(testUserId), count = Some(21))
      Await.result(subscriptions, timeout) must beAnInstanceOf[SubscriptionsList]
    }

    "get followers" in {
      val followers = users.getFollowers(userId = Some(testUserId), count = Some(10))
      Await.result(followers, timeout) must beAnInstanceOf[UserList]
    }

    "report" in {
      val reportStatus = users.report(userId = testUserId, ComplaintType.spam)
      Await.result(reportStatus, timeout) must be equalTo(1)
    }.pendingUntilFixed("User can't be reported for some reason")

    "find someone is some area" in {
      val foundUsers = users.getNearby(Latitude(55.414327), Longitude(37.90047))
      Await.result(foundUsers, timeout) must beAnInstanceOf[UserList]
    }.pendingUntilFixed("Wrong search set")
  }
}
