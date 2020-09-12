/*
* Copyright (C) 2020 Square, Inc.
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
@file:Suppress("ClassName")

object versions {
  // Common
  const val kotlin = "1.4.10"
  const val wire = "3.3.0-SNAPSHOT"
  const val okio = "2.8.0"
  // Server
  const val ktor = "1.4.0"
  const val shadow = "6.0.0"
  // Android
  const val agp = "4.2.0-alpha10"
  const val appcompat = "1.1.0"
  const val coroutines = "1.3.9"
  const val retrofit = "2.9.0"
  const val compose = "1.0.0-alpha01"
}

object deps {
  object plugins {
    const val agp = "com.android.tools.build:gradle:${versions.agp}"
    const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${versions.kotlin}"
    const val wire = "com.squareup.wire:wire-gradle-plugin:${versions.wire}"
  }
  object coroutines {
    const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${versions.coroutines}"
    const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${versions.coroutines}"
  }
  object wire {
    const val runtime = "com.squareup.wire:wire-runtime-multiplatform:${versions.wire}"
    const val compiler = "com.squareup.wire:wire-compiler:${versions.wire}"
  }
  object retrofit {
    const val core = "com.squareup.retrofit2:retrofit:${versions.retrofit}"
    const val wire = "com.squareup.retrofit2:converter-wire:${versions.retrofit}"
  }
  object compose {
    const val ui = "androidx.compose.ui:ui:${versions.compose}"
    const val uiTooling = "androidx.ui:ui-tooling:${versions.compose}"
    const val material = "androidx.compose.material:material:${versions.compose}"
  }
  const val okio = "com.squareup.okio:okio-multiplatform:${versions.okio}"
  const val ktor = "io.ktor:ktor-server-netty:${versions.ktor}"
  const val appcompat = "androidx.appcompat:appcompat:${versions.appcompat}"
}
