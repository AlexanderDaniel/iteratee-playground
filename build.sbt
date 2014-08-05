import play.PlayScala

name := "iteratee-playground"

version := "1.0.0-SNAPSHOT"

scalaVersion := "2.11.2"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

// http://www.playframework.com/documentation/2.3.x/ScalaTestingWithScalaTest
libraryDependencies += "org.scalatestplus" %% "play" % "1.1.0" % "test"


