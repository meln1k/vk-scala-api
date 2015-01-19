package io.github.meln1k.vkApi.models.geo


class Longitude private (val value: Double) extends AnyVal {
  override def toString = value.toString
}

object Longitude {
  private val min = -180
  private val max = 180
  def apply(long: Double): Longitude = {
    if (long < min && long > max)
      throw new IllegalArgumentException(s"expected longitude in range between $min and $max, but got $long")
    new Longitude(long)
  }
}