import io.github.meln1k.vkApi.models.users.UserId
import io.github.meln1k.vkApi.utils.RealAccessToken
import org.specs2.mutable._
import org.specs2.time.NoTimeConversions
import scala.concurrent.duration._


trait VkSpecification extends Specification with NoTimeConversions {
  implicit val testToken = RealAccessToken("66caf3a8a168a24755695a644492a41d4de2a5e117acc36b23920593bbe3dd7eeeb691b4a615d45dd9c46")
  val timeout = 5.second
  val testUserId = UserId(185014513.toString)
  sequential
}
