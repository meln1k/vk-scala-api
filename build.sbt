lazy val root = (project in file(".")).
  settings(
    name := "vk-scala-api",
    version := "0.1-SNAPSHOT",
    scalaVersion := "2.11.4",
    libraryDependencies ++= Seq(
      "com.typesafe.play" %% "play-json" % "2.3.4",
      "com.typesafe.play" %% "play-ws" % "2.3.4"),
    resolvers += "Typesafe Repo" at "http://repo.typesafe.com/typesafe/releases/"
  )