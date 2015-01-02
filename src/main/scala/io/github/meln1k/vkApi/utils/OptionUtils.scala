package io.github.meln1k.vkApi.utils


object OptionUtils {
  implicit def intOpt2Str(i: Option[Int]): String = i.fold("")(_.toString)

  implicit def strOpt2Str(s: Option[String]): String = s.getOrElse("")

  implicit def boolOpt2Str(b: Option[Boolean]): String = b.fold("")(if (_) "1" else "0")
}
