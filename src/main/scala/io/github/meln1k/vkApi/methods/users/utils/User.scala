package io.github.meln1k.vkApi.methods.users.utils

/**
 * Created by nmelkozerov on 16/11/14.
 */

case class User(uid: Long,
                 first_name: String,
                 last_name: String,
                 verified: Option[Int],
                 blacklisted: Option[Int],
                 sex: Option[Int],
                 bdate: Option[String],
                 city: Option[String],
                 country: Option[Int],
                 home_town: Option[String],
                 photo_50: Option[String],
                 photo_100: Option[String],
                 photo_200_orig: Option[String],
                 photo_200: Option[String],
                 photo_400_orig: Option[String],
                 photo_max: Option[String],
                 photo_max_orig: Option[String],
                 online: Option[Int],
                 lists: Option[String],
                 domain: Option[String],
                 has_mobile: Option[Int],
                 contacts: Option[String],
                 site: Option[String],
                 education: Option[Education],
                 universities: Option[Seq[University]],
                 schools: Option[Seq[School]],
                 status: Option[String],
                 last_seen: Option[LastSeen],
                 followers_count: Option[Int],
                 common_count: Option[Int],
                 counters: Option[Counters],
                 occupation: Option[Occupation],
                 nickname: Option[String]
                 // TODO: implement it
                 /*relatives: Option[],
                 relation: Option[],
                 personal: Option[],
                 connections: Option[],
                 exports: Option[],
                 wall_comments: Option[],
                 activities: Option[],
                 interests: Option[],
                 music: Option[],
                 movies: Option[],
                 tv: Option[],
                 books: Option[],
                 games: Option[],
                 about: Option[],
                 quotes: Option[],
                 can_post: Option[],
                 can_see_all_posts: Option[],
                 can_see_audio: Option[],
                 can_write_private_message: Option[],
                 timezone: Option[],
                 screen_name: Option[]*/)

case class Education(university: Int, university_name: String, faculty: Int, faculty_name: String, graduation: Int)

case class University(id: Int,
                      country: Int,
                      city: Int,
                      name: String,
                      faculty: Int,
                      faculty_name: String,
                      chair: Int,
                      chair_name: String,
                      graduation: Int)

case class School(id: Int,
                  country: Int,
                  city: Int,
                  name: String,
                  year_from: Int,
                  year_to: Int,
                  year_graduated: Int,
                  classFoo: String, //class is a reserved keyword, using classFoo instead
                  speciality: String,
                  typeFoo: Int, //type is a reserved keyword, using typeFoo instead
                  type_str: String)

case class LastSeen(time: Long, platform: Int)

case class Counters(albums: Int,
                     videos: Int,
                     audios: Int,
                     notes: Int,
                     friends: Int,
                     groups: Int,
                     online_friends: Int,
                     mutual_friends: Int,
                     user_videos: Int,
                     followers: Int)

case class Occupation(typeFoo: String, //type is a reserved keyword, using typeFoo instead
                       id: Int,
                       name: String)
