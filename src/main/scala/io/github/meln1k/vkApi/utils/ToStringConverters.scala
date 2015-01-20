package io.github.meln1k.vkApi.utils


object ToStringConverters {
  implicit def intOpt2Str(i: Option[Int]): String = i.fold("")(_.toString)

  implicit def longOpt2Str(l: Option[Long]): String = l.fold("")(_.toString)

  implicit def strOpt2Str(s: Option[String]): String = s.getOrElse("")

  implicit def boolOpt2Str(b: Option[Boolean]): String = b.fold("")(if (_) "1" else "0")

  implicit def bool2Str(b: Boolean): String = {if (b) 1 else 0}.toString

  implicit def seq2Str(s: Seq[String]): String = s.mkString(",")
}
