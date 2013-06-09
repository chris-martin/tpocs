import sbt._
import Keys._

object Build extends Build {

  lazy val project = Project("tpocs", base=file(".")).settings(
    scalaVersion := "2.10.2",
    libraryDependencies ++= Seq(
      "com.github.scopt" %% "scopt" % "3.0.0",
      "com.typesafe" % "config" % "1.0.1",
      "org.scalatest" % "scalatest_2.10" % "1.9.1" % "test"
    )
  )

}

