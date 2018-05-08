name := "gatling-meetup-Demo"

version := "0.1"

scalaVersion := "2.12.4"


val gatlingVersion = "2.3.1"
val typeSafeVersion = "1.3.3"


val gatlingCore = "io.gatling" % "gatling-core" % gatlingVersion
val gatlingHighCharts = "io.gatling.highcharts" % "gatling-charts-highcharts" % gatlingVersion
val gatlingTestFramework = "io.gatling" % "gatling-test-framework" % gatlingVersion
val scalaTest = "org.scalatest" %% "scalatest" % "3.0.5" % Test
val typeSafeConfig = "com.typesafe" % "config" % typeSafeVersion


lazy val postDeploymentTest = (project in file("postDeploymentTest"))
.enablePlugins(GatlingPlugin)
  .settings(
    libraryDependencies ++= Seq(
      scalaTest,
      gatlingCore,
      gatlingHighCharts,
      gatlingTestFramework,
      typeSafeConfig
    )
  )
  //.settings(inConfig(Gatling)(Defaults.testSettings): _*)











