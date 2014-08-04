import play.PlayScala

name := "iteratee-playground"

version := "1.0.0-SNAPSHOT"

scalaVersion := "2.11.2"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.1" % "test"


