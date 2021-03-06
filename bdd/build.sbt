name := "bdd"

version := "1.0"

lazy val `bdd` = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq( jdbc , anorm , cache , ws )

libraryDependencies ++= Seq(
  "org.scalatest" % "scalatest_2.11" % "2.2.0" % "test",
  "org.scala-lang" % "scala-library" % "2.11.1",
  "info.cukes" % "cucumber-scala_2.11" % "1.1.8",
  "info.cukes" % "cucumber-junit" % "1.1.8",
  "info.cukes" % "cucumber-picocontainer" % "1.1.8",
  "junit" % "junit" % "4.11" % "test",
  "com.novocode" % "junit-interface" % "0.10" % "test",
  "org.seleniumhq.selenium" % "selenium-java" % "2.45.0",
  "templemore" %% "sbt-cucumber-integration" % "0.8.0" from("http://templemore.co.uk/repo/templemore/sbt-cucumber-integration_2.10/0.8.0/sbt-cucumber-integration_2.10-0.8.0.jar")
)


unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )

cucumberSettings

cucumberFeaturesLocation := "./test/resources/features"

cucumberStepsBasePackage := "stepdefs"