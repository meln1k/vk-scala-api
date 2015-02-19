package io.github.meln1k.vkApi.models.geo

import scala.util.{Success, Failure, Try}


class Latitude private (val value: Double) extends AnyVal {
  override def toString = value.toString + "°"
}

object Latitude {
  private val min = -90
  private val max = 90
  def apply(lat: Double): Try[Latitude] = {
    if (lat < min && lat > max) {
      Failure(new IllegalArgumentException(s"expected latitude in range between $min and $max, but got $lat"))
    } else {
      Success(new Latitude(lat))
    }
  }
}