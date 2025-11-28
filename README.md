## How to implement!!!
Put this in your repositories
```groovy
repositories {
    // JitPack
    maven {
        name = "JitPack"
        url = "https://jitpack.io"
    }
}
```
Put this in your dependencies
```groovy
dependencies {
    // TMMRoles
    modImplementation "com.github.AcoYTMC:TMMRooms-1.21.1:${project.tmmrooms_version}"
}
```
Put this inside your `gradle.properties`
```gradle
tmmrooms_version=VERSION
```
(versions can be found [here](https://github.com/AcoYTMC/TMMRooms-1.21.1/releases))