// Code generated by Wire protocol buffer compiler, do not edit.
// Source: com.yunlong.particle.proto.ColorToken in generate/particle.proto
package com.yunlong.particle.proto

import com.squareup.wire.EnumAdapter
import com.squareup.wire.ProtoAdapter
import com.squareup.wire.Syntax.PROTO_3
import com.squareup.wire.WireEnum
import kotlin.Int
import kotlin.jvm.JvmField
import kotlin.jvm.JvmStatic

public enum class ColorToken(
  public override val `value`: Int,
) : WireEnum {
  TOKEN_1(0),
  TOKEN_2(1),
  ;

  public companion object {
    @JvmField
    public val ADAPTER: ProtoAdapter<ColorToken> = object : EnumAdapter<ColorToken>(
      ColorToken::class, 
      PROTO_3, 
      ColorToken.TOKEN_1
    ) {
      public override fun fromValue(`value`: Int): ColorToken? = ColorToken.fromValue(value)
    }

    @JvmStatic
    public fun fromValue(`value`: Int): ColorToken? = when (value) {
      0 -> TOKEN_1
      1 -> TOKEN_2
      else -> null
    }
  }
}
