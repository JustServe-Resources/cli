## JustServe Cli Tool

The JustServe Cli tool is an admin tool for JustServe Specialists and administrators.  

This tool is very much under development and whose api is subject to change with each release. Standard versioning is used for this project to delineate breaking releases. 

### Install

> [!INFO]
> JustServe Cli tool uses gradle and the graalvm to create a native executable. This results in a very performant binary, but requires a lot of your computer's resources when generating the executable (this is called compiling). This is a dynamic resource allocation, thus the compile time will depend on your system's resources. 

To generate the executable for your system, run `./gradlew nativeCompile`. The executable will be generated in the build directory (`\build\native\nativeCompile\`).