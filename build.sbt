ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.1.3"

lazy val root = (project in file("."))
  .settings(
    name := "Proyecto de consulta",
    libraryDependencies ++= Seq(
      "com.typesafe.akka" %% "akka-actor" % "2.6.18",
      "com.typesafe.akka" %% "akka-stream" % "2.6.18",
      "io.monix" %% "monix" % "3.4.0"
  )
  )