plugins {
    id("groovy") 
    id("io.micronaut.application") version "4.5.3"
    id("com.gradleup.shadow") version "8.3.6"
    id("io.micronaut.openapi") version "4.5.3"
    id("org.graalvm.buildtools.native") version "0.10.6"
}

version = project.properties["justserveCliVersion"]!!
group = "org.justserve"

repositories {
    mavenCentral()
}

dependencies {
    annotationProcessor("org.projectlombok:lombok")
    annotationProcessor("info.picocli:picocli-codegen")
    annotationProcessor("io.micronaut.serde:micronaut-serde-processor")
    implementation("info.picocli:picocli")
    implementation("io.micronaut:micronaut-http-client")
    implementation("io.micronaut.picocli:micronaut-picocli")
    implementation("io.micronaut.serde:micronaut-serde-jackson")
    compileOnly("org.projectlombok:lombok")
    runtimeOnly("ch.qos.logback:logback-classic")
    runtimeOnly("org.yaml:snakeyaml")
}


application {
    mainClass = "org.justserve.FulcrumCommand"
}
java {
    sourceCompatibility = JavaVersion.toVersion("21")
    targetCompatibility = JavaVersion.toVersion("21")
}



micronaut {
    testRuntime("spock2")
    openapi {
        version = "6.16.0"
        client(file("src/main/resources/schema.yml")) {
            apiPackageName = "org.justserve.client"
            modelPackageName = "org.justserve.model"
            useReactive = false
            useAuth = false
            lombok.set(true)
            clientId = "justserve"
            apiNameSuffix = "Client"
            alwaysUseGenerateHttpResponse = true
        }
    }
    processing {
        incremental(true)
        annotations("org.justserve.*")
    }
}

graalvmNative.binaries {
    named("main") {
        imageName.set("justserve")
    }
}


tasks.named<io.micronaut.gradle.docker.NativeImageDockerfile>("dockerfileNative") {
    jdkVersion = "21"
}


