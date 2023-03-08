// Code generated by Wire protocol buffer compiler, do not edit.
// Source: com.yunlong.particle.proto.BorderModifier in generate/particle.proto
package com.yunlong.particle.proto

import android.os.Parcelable
import com.squareup.wire.AndroidMessage
import com.squareup.wire.FieldEncoding
import com.squareup.wire.ProtoAdapter
import com.squareup.wire.ProtoReader
import com.squareup.wire.ProtoWriter
import com.squareup.wire.ReverseProtoWriter
import com.squareup.wire.Syntax.PROTO_3
import com.squareup.wire.WireField
import kotlin.Any
import kotlin.AssertionError
import kotlin.Boolean
import kotlin.Deprecated
import kotlin.DeprecationLevel
import kotlin.Int
import kotlin.Long
import kotlin.Nothing
import kotlin.String
import kotlin.Unit
import kotlin.jvm.JvmField
import okio.ByteString

public class BorderModifier(
  @field:WireField(
    tag = 1,
    adapter = "com.squareup.wire.ProtoAdapter#INT32",
    label = WireField.Label.OMIT_IDENTITY,
  )
  public val width: Int = 0,
  @field:WireField(
    tag = 2,
    adapter = "com.yunlong.particle.proto.ColorModifier#ADAPTER",
    label = WireField.Label.OMIT_IDENTITY,
  )
  public val color: ColorModifier? = null,
  unknownFields: ByteString = ByteString.EMPTY,
) : AndroidMessage<BorderModifier, Nothing>(ADAPTER, unknownFields) {
  @Deprecated(
    message = "Shouldn't be used in Kotlin",
    level = DeprecationLevel.HIDDEN,
  )
  public override fun newBuilder(): Nothing = throw
      AssertionError("Builders are deprecated and only available in a javaInterop build; see https://square.github.io/wire/wire_compiler/#kotlin")

  public override fun equals(other: Any?): Boolean {
    if (other === this) return true
    if (other !is BorderModifier) return false
    if (unknownFields != other.unknownFields) return false
    if (width != other.width) return false
    if (color != other.color) return false
    return true
  }

  public override fun hashCode(): Int {
    var result = super.hashCode
    if (result == 0) {
      result = unknownFields.hashCode()
      result = result * 37 + width.hashCode()
      result = result * 37 + (color?.hashCode() ?: 0)
      super.hashCode = result
    }
    return result
  }

  public override fun toString(): String {
    val result = mutableListOf<String>()
    result += """width=$width"""
    if (color != null) result += """color=$color"""
    return result.joinToString(prefix = "BorderModifier{", separator = ", ", postfix = "}")
  }

  public fun copy(
    width: Int = this.width,
    color: ColorModifier? = this.color,
    unknownFields: ByteString = this.unknownFields,
  ): BorderModifier = BorderModifier(width, color, unknownFields)

  public companion object {
    @JvmField
    public val ADAPTER: ProtoAdapter<BorderModifier> = object : ProtoAdapter<BorderModifier>(
      FieldEncoding.LENGTH_DELIMITED, 
      BorderModifier::class, 
      "type.googleapis.com/com.yunlong.particle.proto.BorderModifier", 
      PROTO_3, 
      null, 
      "generate/particle.proto"
    ) {
      public override fun encodedSize(`value`: BorderModifier): Int {
        var size = value.unknownFields.size
        if (value.width != 0) size += ProtoAdapter.INT32.encodedSizeWithTag(1, value.width)
        if (value.color != null) size += ColorModifier.ADAPTER.encodedSizeWithTag(2, value.color)
        return size
      }

      public override fun encode(writer: ProtoWriter, `value`: BorderModifier): Unit {
        if (value.width != 0) ProtoAdapter.INT32.encodeWithTag(writer, 1, value.width)
        if (value.color != null) ColorModifier.ADAPTER.encodeWithTag(writer, 2, value.color)
        writer.writeBytes(value.unknownFields)
      }

      public override fun encode(writer: ReverseProtoWriter, `value`: BorderModifier): Unit {
        writer.writeBytes(value.unknownFields)
        if (value.color != null) ColorModifier.ADAPTER.encodeWithTag(writer, 2, value.color)
        if (value.width != 0) ProtoAdapter.INT32.encodeWithTag(writer, 1, value.width)
      }

      public override fun decode(reader: ProtoReader): BorderModifier {
        var width: Int = 0
        var color: ColorModifier? = null
        val unknownFields = reader.forEachTag { tag ->
          when (tag) {
            1 -> width = ProtoAdapter.INT32.decode(reader)
            2 -> color = ColorModifier.ADAPTER.decode(reader)
            else -> reader.readUnknownField(tag)
          }
        }
        return BorderModifier(
          width = width,
          color = color,
          unknownFields = unknownFields
        )
      }

      public override fun redact(`value`: BorderModifier): BorderModifier = value.copy(
        color = value.color?.let(ColorModifier.ADAPTER::redact),
        unknownFields = ByteString.EMPTY
      )
    }

    @JvmField
    public val CREATOR: Parcelable.Creator<BorderModifier> = AndroidMessage.newCreator(ADAPTER)

    private const val serialVersionUID: Long = 0L
  }
}
