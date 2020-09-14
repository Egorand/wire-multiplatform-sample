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

import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.squareup.dinosaurs.ui.DinosaursTheme
import com.squareup.dinosaurs.ui.typography
import com.squareup.geology.Period.JURASSIC

@Composable fun DinosaurView(dinosaur: Dinosaur) {
  Column(modifier = Modifier.padding(32.dp)) {
    Text(stringResource(R.string.name_template, dinosaur.name), style = typography.body1)
    Divider(color = Transparent, thickness = 16.dp)
    Text(stringResource(R.string.period_template, dinosaur.period.name), style = typography.body1)
    Divider(color = Transparent, thickness = 16.dp)
    Text(
        stringResource(R.string.length_template, dinosaur.length_meters),
        style = typography.body1,
    )
    Divider(color = Transparent, thickness = 16.dp)
    Text(
        stringResource(R.string.mass_template, dinosaur.mass_kilograms),
        style = typography.body1,
    )
  }
}

@Preview(showBackground = true)
@Composable fun DefaultPreview() {
  val dinosaur = Dinosaur(
      name = "Stegosaurus",
      period = JURASSIC,
      length_meters = 9.0,
      mass_kilograms = 5000.0,
      picture_urls = listOf("http://goo.gl/LD5KY5", "http://goo.gl/VYRM67"),
  )
  DinosaursTheme {
    DinosaurView(dinosaur)
  }
}
