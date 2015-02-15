import io.github.meln1k.vkApi.methods.Users
import io.github.meln1k.vkApi.models.geo.{Longitude, Latitude}
import io.github.meln1k.vkApi.models.users._
import io.github.meln1k.vkApi.services.PlayWSHttpLayerService
import io.github.meln1k.vkApi.utils.{FakeAccessToken, RealAccessToken, ApiError}
import org.specs2.mutable._
import org.specs2.time.NoTimeConversions

import scala.concurrent.Await
import scala.concurrent.duration._

class UsersSpec extends VkSpecification {
  val users = new Users with PlayWSHttpLayerService
  sequential
  "Users methods" should {
    "retrieve user profile with selected fields in users.get" in {
      import UserField._
      import NameCase._
      val user = users.get(userIds = Set(testUserId), fields = Set(
        id,
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

    "throw an exeption when searching without read accessToken" in {
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
    }

    "find someone is some area" in {
      val foundUsers = users.getNearby(Latitude(55.414327), Longitude(37.90047))
      Await.result(foundUsers, timeout) must beAnInstanceOf[UserList]
    }
  }
}
