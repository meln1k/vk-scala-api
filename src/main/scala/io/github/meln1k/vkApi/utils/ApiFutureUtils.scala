package io.github.meln1k.vkApi.utils

import io.github.meln1k.vkApi.models.error.ErrorMessage
import play.api.libs.json.{Reads, JsValue}

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object ApiFutureUtils {
  implicit class FutureOps[T](val f: Future[JsValue]) extends AnyVal {
    def map2seq[A : Reads] = f.map { json =>
      (json \ "response").validate[Seq[A]].getOrElse {
        (json \ "error").validate[ErrorMessage]
          .fold(
            (invalid) => throw new Exception(s"Unknown json: ${json.toString}"),
            (valid) => throw new ApiError(code = valid.error_code, message = valid.error_msg))
      }
    }
  }
}
