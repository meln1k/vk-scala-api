package io.github.meln1k.vkApi.models.pages

import play.api.libs.json.Json

/**
 * Page object describes a wiki page and contains following fields:
 * @param id page identifier.
 * @param group_id community identifier.
 * @param creator_id page creator identifier.
 * @param title page name.
 * @param current_user_can_edit 1, if current user can edit the page text.
 * @param current_user_can_edit_access 1, if current user can edit access permissions for the page.
 * @param who_can_view shows who can view the page:
                        2 — everyone;
                        1 — community members only;
                        0 — community managers only.
 * @param who_can_edit shows who can edit the page:
                        2 — everyone;
                        1 — community members only;
                        0 — community managers only.
 * @param edited unixtime date of the last edit.
 * @param created unixtime date of the page creation.
 * @param editor_id id of the user last edited the page.
 * @param views page views amount.
 * @param parent parent page name for navigation, if exists.
 * @param parent2 second parent page name for navigation, if exists.
 * @param source page text in wiki format, if requested.
 * @param html page text in HTML format, if requested.
 * @param view_url address for page displaying.
 */
case class Page(id: Long,
                group_id: Long,
                creator_id: Long,
                title: String,
                current_user_can_edit: Option[Int],
                current_user_can_edit_access: Option[Int],
                who_can_view: Int,
                who_can_edit: Int,
                edited: Long,
                created: Long,
                editor_id: Long,
                views: Long,
                parent: Option[String],
                parent2: Option[String],
                source: Option[String],
                html: Option[String],
                view_url: String)

object Page {
  implicit val pageReads = Json.reads[Page]
}
