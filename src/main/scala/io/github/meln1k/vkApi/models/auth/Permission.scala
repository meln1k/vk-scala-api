package io.github.meln1k.vkApi.models.auth

object Permission extends Enumeration {
  type Permission = Value
  
  val friends,
  photos,
  audio,
  video,
  docs,
  notes,
  pages,
  status,
  wall,
  groups,
  messages,
  notifications,
  stats = Value
}
