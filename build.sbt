name := "event-manager"

organization := "org.jesusmtnez"

version := "0.1.0-SNAPSHOT"

scalaVersion := "2.11.8"

val redisScalaVersion = "1.8.0"
val akkaHttpVersion = "10.0.4"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-http" % akkaHttpVersion,
  "com.github.etaty" %% "rediscala" % redisScalaVersion
)
