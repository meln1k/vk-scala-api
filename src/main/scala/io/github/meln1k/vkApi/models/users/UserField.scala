package io.github.meln1k.vkApi.models.users

object UserField extends Enumeration {

  type UserField = Value

  val
  id,
  first_name,
  last_name,
  online,
  photo_200,
  counters,
  status
  = Value
}
object User2Field extends Enumeration {

  type User2Field = Value

  val
  sex,
  bdate,
  city,
  country,
  domain
  = Value
}
