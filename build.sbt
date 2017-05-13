lazy val `sbt-trigger-coursier` = (project in file("."))
  .settings(
    name := "sbt-trigger-coursier",
    version := "0.1.0-SNAPSHOT",
    scalaVersion := "2.10.6",
    organization := "org.micchon",
    sbtPlugin := true
  )