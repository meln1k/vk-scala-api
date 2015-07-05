name := "vk-scala-api"

version := "0.1-SNAPSHOT"

scalaVersion := "2.11.4"

libraryDependencies ++= Seq(
  "com.typesafe.play" %% "play-json" % "2.3.4",
  "com.typesafe.play" %% "play-ws" % "2.3.4",
  "org.julienrf" %% "play-json-variants" % "1.1.0",
  "net.databinder.dispatch" %% "dispatch-core" % "0.11.2",
  "com.typesafe" % "config" % "1.2.1",
  "org.specs2" %% "specs2-core" % "2.4.14" % "test")

resolvers += "Typesafe Repo" at "http://repo.typesafe.com/typesafe/releases/"
