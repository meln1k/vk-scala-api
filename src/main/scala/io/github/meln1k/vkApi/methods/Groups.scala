package io.github.meln1k.vkApi.methods

import io.github.meln1k.vkApi.models.GroupList
import io.github.meln1k.vkApi.models.users.{User2Field, UserIdsList, User2List}
import io.github.meln1k.vkApi.services.HttpLayerService
import io.github.meln1k.vkApi.utils.AccessToken
import io.github.meln1k.vkApi.utils.ApiFutureUtils._


class Groups(implicit accessToken: AccessToken) { this: HttpLayerService =>
  /**
   *
   * @param user_id  Идентификатор пользователя, информацию о сообществах которого требуется получить.
   *                 Положительное число, по умолчанию идентификатор текущего пользователя.
   *
   * @param extended Если указать в качестве этого параметра 1, то будет возвращена полная информация
   *                 о группах пользователя. По умолчанию 0.
   *                 Флаг, может принимать значения 1 или 0.
   *
   * @param filter   Cписок фильтров сообществ, которые необходимо вернуть, перечисленные через запятую.
   *                 Доступны значения admin, editor, moder, groups, publics, events.
   *                 По умолчанию возвращаются все сообщества пользователя.
   *                 При указании фильтра admin будут возвращены сообщества, в которых пользователь
   *                 является администратором, , editor — администратором или редактором,
   *                 moder — администратором, редактором или модератором.
   *                 Cписок строк, разделенных через запятую.
   *
   * @param fields   Cписок дополнительных полей, которые необходимо вернуть. Возможные значения: city,
   *                 country, place, description, wiki_page, members_count, counters, start_date,
   *                 finish_date, can_post, can_see_all_posts, activity, status, contacts, links,
   *                 fixed_post, verified, site, can_create_topic. Обратите внимание, этот параметр
   *                 учитывается только при extended=1. Cписок строк, разделенных через запятую.
   *
   * @param offset   Cмещение, необходимое для выборки определённого подмножества сообществ.
   *                 Положительное число.
   *
   * @param count    Количество сообществ, информацию о которых нужно вернуть.
   *                 Положительное число, максимальное значение 1000
   *
   * @return         После успешного выполнения возвращает список идентификаторов сообществ id,
   *                 в которых состоит пользователь user_id.
   *
   *                 Если был задан параметр extended=1, возвращает список объектов сообществ.
   */
  def get(user_id: Long = 0, extended: Int = 1, filter: String = "",
          fields: String = "members_count", offset: Int = 0, count: Int = 1000) = {
    require(extended == 0 || extended == 1, "extended must be equals to 0 or 1")
    require(offset >= 0, "offset must be positive number")
    require(count >= 0 && count <= 1000, " 0 <= count <= 1000")

    apiRequest("groups.get", Vector(
      "user_id" -> { if (user_id > 0) user_id.toString else "" },
      "extended" -> extended.toString,
      "filter" -> filter,
      "fields" -> fields,
      "offset" -> offset.toString,
      "count" -> count.toString
    )).map2[GroupList]
  }

  def getMembers(groupId:String, offset:String,count: Int = 1000) = {
    apiRequest("groups.getMembers", Vector(
      "group_id" -> groupId,
      "offset" -> offset,
      "count" -> count.toString,
      "fields" -> User2Field.values.mkString(",")
    )).map2[User2List]
  }

  def getMemberIds(groupId:String, offset:String,count: Int = 1000) = {
    apiRequest("groups.getMembers", Vector(
      "group_id" -> groupId,
      "offset" -> offset,
      "count" -> count.toString
    )).map2[UserIdsList]
  }
}

