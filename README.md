## JustServe Cli Tool

The JustServe Cli tool is an admin tool for JustServe Specialists and administrators.

This tool is very much under development and whose api is subject to change with each release. Standard versioning is used for this project to delineate breaking releases.

### Install

> [!WARNING]
> JustServe Cli tool uses gradle and the graalvm to create a native executable. This results in a very performant binary, but requires a lot of your computer's resources when generating the executable (this is called compiling). This resource allocation is determined by your system's available resources, thus the compile time will depend on your unique hardware setup.

<details><summary>instructions to set up graalvm build dependencies</summary>

You will need Visual Studio 2022 build tools installed on your machine to generate an executable with the graalvm, as well as GraalVM-CE v17

```PowerShell
@("BuildTools", "Community" ) | 
    % { winget install "Microsoft.VisualStudio.2022.$($_)" }
    
choco install graalvm-java17
 ```
After installing the community IDE, install the "Desktop development with C++" package found under "Workloads"

Be sure that `$env:java_home` is assigned to the graalvm. 
```PowerShell
echo $env:java_home
```
</details>

To generate the executable for your system, run `./gradlew cli:nativeCompile`. The executable will be generated in the build directory (`\build\native\nativeCompile\`).

### Authenticate

Authenticate with this tool by defining the JUSTSERVE_KEY environment variable. This variable needs to be the bearer token used in api calls when browsing JustServe. 