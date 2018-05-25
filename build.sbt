name := "sad_xat"

version := "0.0.1-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.12.3"

libraryDependencies += guice
libraryDependencies += "org.webjars" % "bootstrap" % "3.3.6"
libraryDependencies += "org.webjars" % "requirejs" % "2.2.0"