package io.github.meln1k.vkApi.models.wall

import play.api.libs.json.Json

/** PostSource class contains information how (using site interface, widget, etc.) post was added to the wall.
  * With data from this field you can use additional data on how the post was created on the wall in your application.
  *
  * @param type Types of wall post source {{{
  * vk — post was created using the site main interface (http://vk.com/);
  * widget — post was created using a widget on a third party site;
  * api — post was created by an application via API;
  * rss — post was created using import of RSS feed from a third party site;
  * sms — post was created using an SMS sent to a special number.
  * }}}
  * @param platform Name of the platform, if exists. (ex. android, iphone, wphone)
  * @param data Contains the following data depending on type field value: {{{
  * * vk, api — contains the type of activity the post was created due to:
  * * profile_activity — status change below user's name;
  * * profile_photo — change of user's profile photo;
  *
  * widget — contains the type of the widget the post was created with:
  * * comments — Comments widget;
  * * like — Like widget;
  * * poll — Polls widget;
  *
  * For other values of type field is not returned.
  * }}}
  * @param url External link to post source.
  */
case class PostSource(`type`: String, platform: Option[String], data: Option[String], url: Option[String])

object PostSource {
  implicit val postSourceReads = Json.reads[PostSource]
}