package org.micchon

import sbt._
import sbt.Keys._


object SbtTriggerCoursier extends AutoPlugin {

  object autoImport {
    lazy val coursier = taskKey[Unit]("the version of coursier")
    lazy val projectDirectory = settingKey[File]("the place of project direcotry")
    lazy val enableCoursier = taskKey[Seq[File]]("Enable coursier plugin")
    lazy val disableCoursier = taskKey[Unit]("Disable coursier plugin")
  }

  import autoImport._

  override def trigger: PluginTrigger = allRequirements

  override val projectSettings: Seq[Setting[_]] = Seq(
    name in coursier := "coursier.sbt",
    version in coursier := "1.0.0-RC2",
    projectDirectory := baseDirectory.value / "project",
    enableCoursier := enableCoursierTask.value,
    disableCoursier := disableCoursierTask.value
  )

  lazy val enableCoursierTask: Def.Initialize[Task[Seq[File]]] = Def.task {
    val file = projectDirectory.value / (name in coursier).value
    val coursierVersion = (version in coursier).value
    val sbtCoursier = s"""addSbtPlugin("io.get-coursier" % "sbt-coursier" % "$coursierVersion")"""
    IO.write(file, sbtCoursier)
    Seq(file)
  }

  lazy val disableCoursierTask: Def.Initialize[Task[Unit]] = Def.task {
    val file = projectDirectory.value / (name in coursier).value
    IO.delete(file)
  }

}
