val scala3Version = "3.7.3"

lazy val root = project
  .in(file("."))
  .settings(
    name := "advent-of-code-scala-2025",
    version := "0.1.0",
    scalaVersion := scala3Version,
    libraryDependencies ++= Seq(
      "com.lihaoyi" %% "os-lib" % "0.9.1",
      "com.lihaoyi" %% "pprint" % "0.8.1",
      "org.scalameta" %% "munit" % "0.7.29" % Test
    ),
    scalacOptions ++= Seq("-deprecation", "-Wunused:all")
  )
