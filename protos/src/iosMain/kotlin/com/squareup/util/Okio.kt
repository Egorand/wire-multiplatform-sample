package com.squareup.util

import okio.ByteString
import okio.ByteString.Companion.decodeHex
import okio.ByteString.Companion.decodeBase64

fun decodeBase64(base64: String): ByteString = base64.decodeBase64()!!
