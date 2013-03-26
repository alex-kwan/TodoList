import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName         = "todolist"
  val appVersion      = "1.0-SNAPSHOT"

  val appDependencies = Seq(
   "postgresql" % "postgresql" % "8.4-702.jdbc4",
   "securesocial" %% "securesocial" % "2.0.12",
    jdbc,
    anorm
  )


  val main = play.Project(appName, appVersion, appDependencies,mainLang = SCALA).settings(
    resolvers += Resolver.url("sbt-plugin-snapshots", url("http://repo.scala-sbt.org/scalasbt/sbt-plugin-releases/"))(Resolver.ivyStylePatterns)
  )

}
