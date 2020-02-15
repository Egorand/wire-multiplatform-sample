package com.squareup.util

import com.squareup.wire.ProtoAdapter
import platform.Foundation.NSData
import platform.posix.memcpy
import kotlinx.cinterop.addressOf
import kotlinx.cinterop.usePinned

// TODO(egorand): Move to Wire/Okio
fun <E> ProtoAdapter<E>.decode(data: NSData): E {
  val bytes = ByteArray(data.length.toInt()).apply {
    usePinned { pinned ->
      memcpy(pinned.addressOf(0), data.bytes, data.length)
    }
  }
  return decode(bytes)
}
