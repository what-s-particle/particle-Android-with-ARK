// Code generated by Wire protocol buffer compiler, do not edit.
// Source: com.yunlong.particle.proto.NavigationMode in generate/particle.proto
package com.yunlong.particle.proto

import com.squareup.wire.EnumAdapter
import com.squareup.wire.ProtoAdapter
import com.squareup.wire.Syntax.PROTO_3
import com.squareup.wire.WireEnum
import kotlin.Int
import kotlin.jvm.JvmField
import kotlin.jvm.JvmStatic

public enum class NavigationMode(
  public override val `value`: Int,
) : WireEnum {
  XXXX(0),
  ;

  public companion object {
    @JvmField
    public val ADAPTER: ProtoAdapter<NavigationMode> = object : EnumAdapter<NavigationMode>(
      NavigationMode::class, 
      PROTO_3, 
      NavigationMode.XXXX
    ) {
      public override fun fromValue(`value`: Int): NavigationMode? = NavigationMode.fromValue(value)
    }

    @JvmStatic
    public fun fromValue(`value`: Int): NavigationMode? = when (value) {
      0 -> XXXX
      else -> null
    }
  }
}
