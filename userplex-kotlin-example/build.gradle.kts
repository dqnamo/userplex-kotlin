plugins {
    id("userplex.kotlin")
    application
}

dependencies {
    implementation(project(":userplex-kotlin"))
}

application {
    // Use `./gradlew :userplex-kotlin-example:run` to run `Main`
    // Use `./gradlew :userplex-kotlin-example:run -Pexample=Something` to run `SomethingExample`
    mainClass = "com.userplex.api.example.${
        if (project.hasProperty("example"))
            "${project.property("example")}ExampleKt"
        else
            "MainKt"
    }"
}
