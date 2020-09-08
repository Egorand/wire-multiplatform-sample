/*
 * Copyright 2019 Square Inc.
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
package com.squareup.dinosaurs

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.platform.setContent
import com.squareup.dinosaurs.ui.DinosaursTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.wire.WireConverterFactory

class MainActivity : AppCompatActivity() {
  private val scope: CoroutineScope = MainScope()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    val dinosaursApi = Retrofit.Builder()
        .baseUrl("https://wire-dinosaurs-demo.herokuapp.com")
        .addConverterFactory(WireConverterFactory.create())
        .build()
        .create(DinosaursApi::class.java)

    scope.launch {
      val dinosaur = withContext(Dispatchers.IO) {
        dinosaursApi.getDinosaur()
      }
      setContent {
        DinosaursTheme {
          DinosaurView(dinosaur)
        }
      }
    }
  }

  override fun onDestroy() {
    super.onDestroy()
    scope.cancel()
  }
}
