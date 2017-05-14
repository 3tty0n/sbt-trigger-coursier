lazy val `sbt-trigger-coursier` = (project in file("."))
  .settings(
    name := "sbt-trigger-coursier",
    version := "0.1.0-SNAPSHOT",
    scalaVersion := "2.10.6",
    organization := "org.micchon",
    sbtPlugin := true
  )
  .settings(publishSettings: _*)

lazy val publishSettings = Seq(
  publishMavenStyle := true,
  publishTo := {
    val nexus = "https://oss.sonatype.org/"
    if (version.value.trim.endsWith("SNAPSHOT"))
      Some("snapshots" at nexus + "content/repositories/snapshots")
    else
      Some("releases" at nexus + "service/local/staging/deploy/maven2")
  },
  publishArtifact in Test := false,
  pomIncludeRepository := { _ => false },
	licenses := Seq("Apache-2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0.html")),
  pomExtra :=
    <url>https://github.com/3tty0n/sbt-trigger-coursier</url>
    <developers>
      <developer>
        <id>3tty0n</id>
        <name>Yusuke Izawa</name>
        <url>https://github.com/3tty0n</url>
      </developer>
    </developers>
    <scm>
      <url>git@github.com:3tty0n/sbt-trigger-coursier.git</url>
      <connection>scm:git@github.com:3tty0n/sbt-trigger-coursier.git</connection>
    </scm>
)
