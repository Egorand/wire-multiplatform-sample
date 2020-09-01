/*
 * Copyright (C) 2019 Square, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
plugins {
  id("com.android.application")
  kotlin("android")
}

android {
  compileSdkVersion(30)
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
  }
  defaultConfig {
    applicationId = "com.squareup.dinosaurs"
    minSdkVersion(21)
    targetSdkVersion(30)
    versionCode = 1
    versionName = "1.0"
  }
  buildFeatures {
    compose = true
  }
  composeOptions {
    kotlinCompilerExtensionVersion = versions.compose
    kotlinCompilerVersion = versions.kotlin
  }
}

dependencies {
  implementation(project(":protos"))
  implementation(deps.coroutines.core)
  implementation(deps.coroutines.android)
  implementation(deps.retrofit.core)
  implementation(deps.retrofit.wire)
  implementation(deps.compose.material)
  implementation(deps.compose.ui)
  implementation(deps.compose.uiTooling)
  implementation(deps.appcompat)
}