organization := "com.julianpeeters"

name := "override-settings"

version := "0.1-SNAPSHOT"

sourceGenerators in Compile += (avroScalaGenerateSpecific in Compile).taskValue

(avroSpecificScalaSource in Compile) := new java.io.File(s"${baseDirectory.value}/myoutputdir")

(avroScalaSpecificCustomNamespace in Compile) := Map("example"->"overridden")

(avroScalaSpecificCustomTypes in Compile) := Map("array" -> classOf[Vector[_]])

libraryDependencies += "org.apache.avro" % "avro" % "1.7.7"


