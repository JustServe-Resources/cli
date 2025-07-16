# Contributing

By participating in this project, you agree to abide our
[code of conduct].

## Set up your machine

This project is written in [java] and [micronaut] using
Oracle's [GraalVM] and uses [gradle] to
handle dependencies.

Prerequisites:

- [Java 21 in graal's flavor Graal (community edition)]

clone the codebase, then cd into the repo and install the dependencies with gradle

```sh
git clone git@github.com:JustServe-Resources/cli.git

./gradlew assemble
```

## Branch off of main

It's a good practice not to put your changes in the main branch. Branch naming conventions aren't enforced, naming my branches with a `tag`/`task` convention are suggested, similar to [Conventional Commits] naming strategy.

See our [style guide](https://github.com/Graqr#general-styling-guide) for supported coding practices. This project enforces [Conventional Commits], which is checked with each commit. 
## Test your change

Adequate acceptance testing is to be included with pull requests for new code. See our [style guide] for our testing standards. A portion of the codebase is generated during the build process. Using gradle's `build` task will both assemble and run tests. 

```sh
./gradlew build
```

## Validate this builds properly
This project compiles to a native executable specific to your OS. This is different from a normal java build process. Compiling this repo into an executable is not a short process. See [graal's docs] for options like quick build mode
```sh
./gradlew nativeCompile
```
> [!NOTE]
> This build may pass on your OS but may fail on the other OS for which this cli compiles. These will be built and tested during PR checks 


## Submit a pull request

Push your branch to your `cli` fork and open a pull request against the original `cli` main branch. Contributions must pass all tests and CI before merging. Clearly showcase all changes and update [tests] accordingly. 

Please only mark the pull request as "Ready for Review" when CI tests are passing and the PR is in fact complete and ready for review.

[code of conduct]:CODE_OF_CONDUCT.md
[Conventional Commits]:https://www.conventionalcommits.org/en/v1.0.0/#summary
[GraalVM]:https://www.graalvm.org/
[graal's docs]:https://www.graalvm.org/latest/reference-manual/native-image/optimizations-and-performance/
[gradle]:https://docs.gradle.org/current/userguide/building_java_projects.html
[Java 21 in graal's flavor Graal (community edition)]:https://github.com/graalvm/graalvm-ce-builds/releases/
[micronaut]:https://micronaut.io/
[native executable]:https://www.graalvm.org/latest/reference-manual/native-image/guides/build-java-modules-into-native-executable/
[style guide]:STYLE_GUIDE.md#testing
[tests]:STYLE_GUIDE.md