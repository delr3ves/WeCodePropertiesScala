scalaVersion := "2.12.7"

name := "WecodePropertiesScala"
organization := "com.emaginalabs"
version := "1.0"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5" % "test"
libraryDependencies += "org.scalacheck" %% "scalacheck" % "1.14.0" % "test"

logBuffered in Test := false


addCommandAlias("format", ";scalafmt;test:scalafmt")

addCommandAlias("check-format", ";scalafmt::test;test:scalafmt::test")
