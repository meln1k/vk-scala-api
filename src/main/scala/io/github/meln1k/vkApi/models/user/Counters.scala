package io.github.meln1k.vkApi.models.user

import play.api.libs.json.Json

case class Counters(albums: Option[Int],
                    videos: Option[Int],
                    audios: Option[Int],
                    notes: Option[Int],
                    photos: Option[Int],
                    friends: Option[Int],
                    groups: Option[Int],
                    gifts: Option[Int],
                    online_friends: Option[Int],
                    mutual_friends: Option[Int],
                    user_photos: Option[Int],
                    user_videos: Option[Int],
                    followers: Option[Int],
                    pages: Option[Int])

object Counters {
  implicit val countersReads = Json.reads[Counters]
}
