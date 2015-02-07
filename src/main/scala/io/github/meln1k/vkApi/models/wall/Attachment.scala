package io.github.meln1k.vkApi.models.wall

import io.github.meln1k.vkApi.models.audio.Audio
import io.github.meln1k.vkApi.models.docs.Document
import io.github.meln1k.vkApi.models.notes.Note
import io.github.meln1k.vkApi.models.pages.Page
import io.github.meln1k.vkApi.models.photos.Photo
import io.github.meln1k.vkApi.models.video.Video
import julienrf.variants.Variants


/** Description of Format of Media Attachments in Wall Posts
  *
  * Information about media attachments in posts is returned as '''attachments''' array with elements,
  * each containing '''type''' field and an object with a field set defined by attachment type.
  * {{{
  * type field may have the following values:
  *
  * photo — photo from an album;
  * posted_photo — photo uploaded directly from user's computer;
  * video — video;
  * audio — audio;
  * doc — document;
  * graffiti — graffiti;
  * url — web page URL;
  * note — note;
  * app — image uploaded with a third party application;
  * poll — poll;
  * page — wiki page.
  * }}}
  */
sealed trait Attachment

/** Photo from an Album (type = photo)
  *
  * @param photo [[Photo]] object;
  */
case class PhotoAttachment(photo: Photo) extends Attachment

case class PostedphotoAttachment(photo: PostedPhoto) extends Attachment

case class AudioAttachment(audio: Audio) extends Attachment

case class VideoAttachment(video: Video) extends Attachment

case class DocumentAttachment(audio: Document) extends Attachment

case class GraffitiAttachment(graffiti: Graffiti) extends Attachment

case class LinkAttachment(link: WallLink) extends Attachment

case class NoteAttachment(note: Note) extends Attachment

case class AppAttachment(app: App) extends Attachment

case class PollAttachment(poll: WallPoll) extends Attachment

case class PageAttachment(page: Page) extends Attachment

case class AlbumAttachment(album: Album) extends Attachment

object Attachment {
  implicit val attachmentReads = Variants.reads[Attachment](
    "type", (s: String) => s"${s.filterNot(_=='_').capitalize}Attachment"
  )
}

