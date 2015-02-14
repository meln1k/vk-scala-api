package io.github.meln1k.vkApi.models.wall

object WallFilter extends Enumeration {

  type WallFilter = Value

  val owner, others, all, postponed, suggests = Value
}
