package io.github.meln1k.vkApi.models.user

/**
 * Created by nmelkozerov on 26/12/14.
 */
object ComplaintType extends Enumeration {
  type ComplaintType = Value
  val porn, spam, insult, advertisment = Value
}
