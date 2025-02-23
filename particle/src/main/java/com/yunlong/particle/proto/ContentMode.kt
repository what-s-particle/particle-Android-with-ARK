// Code generated by Wire protocol buffer compiler, do not edit.
// Source: com.yunlong.particle.proto.ContentMode in generate/particle.proto
package com.yunlong.particle.proto

import com.squareup.wire.EnumAdapter
import com.squareup.wire.ProtoAdapter
import com.squareup.wire.Syntax.PROTO_3
import com.squareup.wire.WireEnum
import kotlin.Int
import kotlin.jvm.JvmField
import kotlin.jvm.JvmStatic

public enum class ContentMode(
  public override val `value`: Int,
) : WireEnum {
  SCALE_TO_FIT(0),
  SCALE_ASPECT_FIT(1),
  SCALE_ASPECT_FILL(2),
  ;

  public companion object {
    @JvmField
    public val ADAPTER: ProtoAdapter<ContentMode> = object : EnumAdapter<ContentMode>(
      ContentMode::class, 
      PROTO_3, 
      ContentMode.SCALE_TO_FIT
    ) {
      public override fun fromValue(`value`: Int): ContentMode? = ContentMode.fromValue(value)
    }

    @JvmStatic
    public fun fromValue(`value`: Int): ContentMode? = when (value) {
      0 -> SCALE_TO_FIT
      1 -> SCALE_ASPECT_FIT
      2 -> SCALE_ASPECT_FILL
      else -> null
    }
  }
}
