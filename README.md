## JustServe Cli Tool

The JustServe Cli tool is an admin tool for JustServe Specialists and administrators.

This tool is very much under development and whose api is subject to change with each release. Standard versioning is used for this project to delineate breaking releases.

### Install

<details><summary>instructions to set up graalvm build dependencies</summary>

You will need Visual Studio 2022 build tools installed on your machine to generate an executable with the graalvm, as well as GraalVM-CE v21
<ol>
<li>
Call this command to install both the visual studio community ide and its build tools. This also calls Chocolatey to install the graalvm, which you can choose to do through your IDE later as well.

```PowerShell
@("BuildTools", "Community" ) | 
    % { winget install "Microsoft.VisualStudio.2022.$($_)" }
    
choco install graalvm-java21 21.0.2
 ```
</li>
<li> After installing the Visual Studio Community IDE, install the "Desktop development with C++" package found under "Workloads".


> [!INFO]
> This can be found if you launch the IDE (select "continue without code"), then from the top menu select `Tools` -> `Get Tools and Features`. The installer will pop up with the workloads tab shown first.

</li>

<li> Be sure that `$env:java_home` is assigned to the graalvm.

```PowerShell
echo $env:java_home
```
</li>
</ol>
</details>

To generate the executable for your system, run `./gradlew nativeCompile`. The executable will be generated in the build directory (`\build\native\nativeCompile\`).

### Authenticate

Authenticate with this tool by defining the `JUSTSERVE_TOKEN` environment variable. Then request a token from the help center to populate the variable. 