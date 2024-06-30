val scala3 = "3.4.2"
val scala2 = "2.13.14"

lazy val root = Project("root", file("."))
  .aggregate(lib, crossTests)
  .settings(
    version := "0.1.0",
    name := "Scala3LibExample",
    scalaVersion := scala3,
  )

lazy val lib = Project("lib", file("modules/lib"))
  .settings(commonSettings)
  .settings(
    scalaVersion := scala3,
    crossScalaVersions := Seq(scala3),
  )

lazy val crossTests = Project("crosstests", file("modules/crosstests"))
  .dependsOn(lib)
  .settings(commonSettings)
  .settings(
    crossScalaVersions := Seq(scala2, scala3),
    scalacOptions ++= (if (scalaVersion.value == scala2) Seq("-Ytasty-reader") else Seq.empty),
  )

lazy val commonSettings = Seq(
    libraryDependencies += "org.scalameta" %% "munit" % "0.7.29" % Test
)

