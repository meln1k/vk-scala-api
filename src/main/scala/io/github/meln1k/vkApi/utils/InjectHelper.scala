package io.github.meln1k.vkApi.utils

import com.google.inject.Guice
import io.github.meln1k.vkApi.guice.ApiModule


object InjectHelper {
  private val injector = Guice.createInjector(new ApiModule)

  import net.codingwell.scalaguice.InjectorExtensions._
  def inject[T](implicit mf: Manifest[T]): T  = injector.instance[T]
}
