package io.github.meln1k.vkApi.guice

import javax.inject.Singleton

import com.google.inject.AbstractModule
import io.github.meln1k.vkApi.services.{HttpLayerService, PlayWSHttpLayerService}
import net.codingwell.scalaguice.ScalaModule


class ApiModule extends AbstractModule with ScalaModule{
  def configure {
    bind[HttpLayerService].to[PlayWSHttpLayerService].in[Singleton]
  }
}
