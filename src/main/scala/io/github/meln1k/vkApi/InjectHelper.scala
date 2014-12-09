package io.github.meln1k.vkApi

import com.google.inject.Guice


object InjectHelper {
  private val injector = Guice.createInjector(new ApiModule)

  import net.codingwell.scalaguice.InjectorExtensions._
  def inject[T](implicit mf: Manifest[T]): T  = injector.instance[T]
}
