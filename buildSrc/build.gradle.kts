plugins {
  `kotlin-dsl`
}

repositories {
  jcenter()
}

dependencies {
  // TODO: Remove once https://issuetracker.google.com/issues/166468915 is fixed
  implementation("org.jetbrains.kotlin:kotlin-stdlib:1.4.0")
}
