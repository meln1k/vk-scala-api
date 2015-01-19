package io.github.meln1k.vkApi.models.geo


class Latitude private (val value: Double) extends AnyVal {
  override def toString = value.toString
}

object Latitude {
  private val min = -90
  private val max = 90
  def apply(lat: Double): Latitude = {
    if (lat < min && lat > max)
      throw new IllegalArgumentException(s"expected latitude in range between $min and $max, but got $lat")
    new Latitude(lat)
  }
}