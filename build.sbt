name := "vk-scala-api"

version := "0.1-SNAPSHOT"

scalaVersion := "2.11.4"

libraryDependencies ++= Seq(
  "com.google.inject" % "guice" % "4.0-beta5",
  "net.codingwell" %% "scala-guice" % "4.0.0-beta5",
  "com.typesafe.play" %% "play-json" % "2.3.4",
  "com.typesafe.play" %% "play-ws" % "2.3.4",
  "org.specs2" %% "specs2-core" % "2.4.14" % "test")

resolvers += "Typesafe Repo" at "http://repo.typesafe.com/typesafe/releases/"
