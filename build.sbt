name := """RN Challenge"""

version := "1.0"

resolvers += "Artima Maven Repository" at "http://repo.artima.com/releases"

libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.8"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.8" % "test"

logBuffered in Test := false
coverageEnabled := true
mainClass in Compile := Some("com.github.zero_degrees.morning_routine.Application")