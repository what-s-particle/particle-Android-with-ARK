// Code generated by Wire protocol buffer compiler, do not edit.
// Source: com.yunlong.particle.proto.Modifier in generate/particle.proto
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
import com.squareup.wire.`internal`.immutableCopyOf
import com.squareup.wire.`internal`.redactElements
import kotlin.Any
import kotlin.AssertionError
import kotlin.Boolean
import kotlin.Deprecated
import kotlin.DeprecationLevel
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.Nothing
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
import kotlin.jvm.JvmField
import okio.ByteString

/**
 * The styling of elements is a very important aspect. They grab the user's attention, make the
 * application
 * easier to use, and increase user satisfaction with the application. In mobile apps, common styles
 * include colors,
 * fonts, backgrounds, spacing, borders, and shadows, among others. These styles can be defined and
 * applied by using
 * CSS, XML or a dedicated style language.
 * In mobile applications, a style is usually defined as a set of properties that control the
 * appearance and behavior
 * of an element. For example, a button's style might include background color, text color, font
 * size and style,
 * padding, border color and width, and more. These attributes can be shared among different
 * elements in the
 * application and can be modified when needed to suit different application needs.
 * Another benefit of using styles is that it makes the application easier to maintain and modify.
 * By defining
 * styles as separate files, you can modify the look and feel of your application without affecting
 * the
 * application logic. This approach also improves development efficiency, since one style change can
 * update
 * multiple elements throughout the application.
 */
public class Modifier(
  custom: List<CustomModifier> = emptyList(),
  @field:WireField(
    tag = 2,
    adapter = "com.yunlong.particle.proto.ColorModifier#ADAPTER",
  )
  public val background: ColorModifier? = null,
  @field:WireField(
    tag = 3,
    adapter = "com.yunlong.particle.proto.OffsetModifier#ADAPTER",
  )
  public val blur: OffsetModifier? = null,
  @field:WireField(
    tag = 4,
    adapter = "com.yunlong.particle.proto.BorderModifier#ADAPTER",
  )
  public val border: BorderModifier? = null,
  @field:WireField(
    tag = 5,
    adapter = "com.squareup.wire.ProtoAdapter#BOOL",
  )
  public val clickable: Boolean? = null,
  @field:WireField(
    tag = 6,
    adapter = "com.squareup.wire.ProtoAdapter#BOOL",
  )
  public val focusable: Boolean? = null,
  @field:WireField(
    tag = 7,
    adapter = "com.yunlong.particle.proto.OffsetModifier#ADAPTER",
  )
  public val offset: OffsetModifier? = null,
  @field:WireField(
    tag = 8,
    adapter = "com.squareup.wire.ProtoAdapter#FLOAT",
  )
  public val opacity: Float? = null,
  @field:WireField(
    tag = 9,
    adapter = "com.yunlong.particle.proto.InsetsModifier#ADAPTER",
  )
  public val padding: InsetsModifier? = null,
  @field:WireField(
    tag = 10,
    adapter = "com.yunlong.particle.proto.SizeModifier#ADAPTER",
  )
  public val requireSize: SizeModifier? = null,
  @field:WireField(
    tag = 11,
    adapter = "com.yunlong.particle.proto.ShadowModifier#ADAPTER",
  )
  public val shadow: ShadowModifier? = null,
  @field:WireField(
    tag = 12,
    adapter = "com.yunlong.particle.proto.SizeModifier#ADAPTER",
  )
  public val size: SizeModifier? = null,
  @field:WireField(
    tag = 13,
    adapter = "com.squareup.wire.ProtoAdapter#BOOL",
  )
  public val visible: Boolean? = null,
  @field:WireField(
    tag = 14,
    adapter = "com.squareup.wire.ProtoAdapter#FLOAT",
  )
  public val weight: Float? = null,
  unknownFields: ByteString = ByteString.EMPTY,
) : AndroidMessage<Modifier, Nothing>(ADAPTER, unknownFields) {
  @field:WireField(
    tag = 1,
    adapter = "com.yunlong.particle.proto.CustomModifier#ADAPTER",
    label = WireField.Label.REPEATED,
  )
  public val custom: List<CustomModifier> = immutableCopyOf("custom", custom)

  @Deprecated(
    message = "Shouldn't be used in Kotlin",
    level = DeprecationLevel.HIDDEN,
  )
  public override fun newBuilder(): Nothing = throw
      AssertionError("Builders are deprecated and only available in a javaInterop build; see https://square.github.io/wire/wire_compiler/#kotlin")

  public override fun equals(other: Any?): Boolean {
    if (other === this) return true
    if (other !is Modifier) return false
    if (unknownFields != other.unknownFields) return false
    if (custom != other.custom) return false
    if (background != other.background) return false
    if (blur != other.blur) return false
    if (border != other.border) return false
    if (clickable != other.clickable) return false
    if (focusable != other.focusable) return false
    if (offset != other.offset) return false
    if (opacity != other.opacity) return false
    if (padding != other.padding) return false
    if (requireSize != other.requireSize) return false
    if (shadow != other.shadow) return false
    if (size != other.size) return false
    if (visible != other.visible) return false
    if (weight != other.weight) return false
    return true
  }

  public override fun hashCode(): Int {
    var result = super.hashCode
    if (result == 0) {
      result = unknownFields.hashCode()
      result = result * 37 + custom.hashCode()
      result = result * 37 + (background?.hashCode() ?: 0)
      result = result * 37 + (blur?.hashCode() ?: 0)
      result = result * 37 + (border?.hashCode() ?: 0)
      result = result * 37 + (clickable?.hashCode() ?: 0)
      result = result * 37 + (focusable?.hashCode() ?: 0)
      result = result * 37 + (offset?.hashCode() ?: 0)
      result = result * 37 + (opacity?.hashCode() ?: 0)
      result = result * 37 + (padding?.hashCode() ?: 0)
      result = result * 37 + (requireSize?.hashCode() ?: 0)
      result = result * 37 + (shadow?.hashCode() ?: 0)
      result = result * 37 + (size?.hashCode() ?: 0)
      result = result * 37 + (visible?.hashCode() ?: 0)
      result = result * 37 + (weight?.hashCode() ?: 0)
      super.hashCode = result
    }
    return result
  }

  public override fun toString(): String {
    val result = mutableListOf<String>()
    if (custom.isNotEmpty()) result += """custom=$custom"""
    if (background != null) result += """background=$background"""
    if (blur != null) result += """blur=$blur"""
    if (border != null) result += """border=$border"""
    if (clickable != null) result += """clickable=$clickable"""
    if (focusable != null) result += """focusable=$focusable"""
    if (offset != null) result += """offset=$offset"""
    if (opacity != null) result += """opacity=$opacity"""
    if (padding != null) result += """padding=$padding"""
    if (requireSize != null) result += """requireSize=$requireSize"""
    if (shadow != null) result += """shadow=$shadow"""
    if (size != null) result += """size=$size"""
    if (visible != null) result += """visible=$visible"""
    if (weight != null) result += """weight=$weight"""
    return result.joinToString(prefix = "Modifier{", separator = ", ", postfix = "}")
  }

  public fun copy(
    custom: List<CustomModifier> = this.custom,
    background: ColorModifier? = this.background,
    blur: OffsetModifier? = this.blur,
    border: BorderModifier? = this.border,
    clickable: Boolean? = this.clickable,
    focusable: Boolean? = this.focusable,
    offset: OffsetModifier? = this.offset,
    opacity: Float? = this.opacity,
    padding: InsetsModifier? = this.padding,
    requireSize: SizeModifier? = this.requireSize,
    shadow: ShadowModifier? = this.shadow,
    size: SizeModifier? = this.size,
    visible: Boolean? = this.visible,
    weight: Float? = this.weight,
    unknownFields: ByteString = this.unknownFields,
  ): Modifier = Modifier(custom, background, blur, border, clickable, focusable, offset, opacity,
      padding, requireSize, shadow, size, visible, weight, unknownFields)

  public companion object {
    @JvmField
    public val ADAPTER: ProtoAdapter<Modifier> = object : ProtoAdapter<Modifier>(
      FieldEncoding.LENGTH_DELIMITED, 
      Modifier::class, 
      "type.googleapis.com/com.yunlong.particle.proto.Modifier", 
      PROTO_3, 
      null, 
      "generate/particle.proto"
    ) {
      public override fun encodedSize(`value`: Modifier): Int {
        var size_ = value.unknownFields.size
        size_ += CustomModifier.ADAPTER.asRepeated().encodedSizeWithTag(1, value.custom)
        size_ += ColorModifier.ADAPTER.encodedSizeWithTag(2, value.background)
        size_ += OffsetModifier.ADAPTER.encodedSizeWithTag(3, value.blur)
        size_ += BorderModifier.ADAPTER.encodedSizeWithTag(4, value.border)
        size_ += ProtoAdapter.BOOL.encodedSizeWithTag(5, value.clickable)
        size_ += ProtoAdapter.BOOL.encodedSizeWithTag(6, value.focusable)
        size_ += OffsetModifier.ADAPTER.encodedSizeWithTag(7, value.offset)
        size_ += ProtoAdapter.FLOAT.encodedSizeWithTag(8, value.opacity)
        size_ += InsetsModifier.ADAPTER.encodedSizeWithTag(9, value.padding)
        size_ += SizeModifier.ADAPTER.encodedSizeWithTag(10, value.requireSize)
        size_ += ShadowModifier.ADAPTER.encodedSizeWithTag(11, value.shadow)
        size_ += SizeModifier.ADAPTER.encodedSizeWithTag(12, value.size)
        size_ += ProtoAdapter.BOOL.encodedSizeWithTag(13, value.visible)
        size_ += ProtoAdapter.FLOAT.encodedSizeWithTag(14, value.weight)
        return size_
      }

      public override fun encode(writer: ProtoWriter, `value`: Modifier): Unit {
        CustomModifier.ADAPTER.asRepeated().encodeWithTag(writer, 1, value.custom)
        ColorModifier.ADAPTER.encodeWithTag(writer, 2, value.background)
        OffsetModifier.ADAPTER.encodeWithTag(writer, 3, value.blur)
        BorderModifier.ADAPTER.encodeWithTag(writer, 4, value.border)
        ProtoAdapter.BOOL.encodeWithTag(writer, 5, value.clickable)
        ProtoAdapter.BOOL.encodeWithTag(writer, 6, value.focusable)
        OffsetModifier.ADAPTER.encodeWithTag(writer, 7, value.offset)
        ProtoAdapter.FLOAT.encodeWithTag(writer, 8, value.opacity)
        InsetsModifier.ADAPTER.encodeWithTag(writer, 9, value.padding)
        SizeModifier.ADAPTER.encodeWithTag(writer, 10, value.requireSize)
        ShadowModifier.ADAPTER.encodeWithTag(writer, 11, value.shadow)
        SizeModifier.ADAPTER.encodeWithTag(writer, 12, value.size)
        ProtoAdapter.BOOL.encodeWithTag(writer, 13, value.visible)
        ProtoAdapter.FLOAT.encodeWithTag(writer, 14, value.weight)
        writer.writeBytes(value.unknownFields)
      }

      public override fun encode(writer: ReverseProtoWriter, `value`: Modifier): Unit {
        writer.writeBytes(value.unknownFields)
        ProtoAdapter.FLOAT.encodeWithTag(writer, 14, value.weight)
        ProtoAdapter.BOOL.encodeWithTag(writer, 13, value.visible)
        SizeModifier.ADAPTER.encodeWithTag(writer, 12, value.size)
        ShadowModifier.ADAPTER.encodeWithTag(writer, 11, value.shadow)
        SizeModifier.ADAPTER.encodeWithTag(writer, 10, value.requireSize)
        InsetsModifier.ADAPTER.encodeWithTag(writer, 9, value.padding)
        ProtoAdapter.FLOAT.encodeWithTag(writer, 8, value.opacity)
        OffsetModifier.ADAPTER.encodeWithTag(writer, 7, value.offset)
        ProtoAdapter.BOOL.encodeWithTag(writer, 6, value.focusable)
        ProtoAdapter.BOOL.encodeWithTag(writer, 5, value.clickable)
        BorderModifier.ADAPTER.encodeWithTag(writer, 4, value.border)
        OffsetModifier.ADAPTER.encodeWithTag(writer, 3, value.blur)
        ColorModifier.ADAPTER.encodeWithTag(writer, 2, value.background)
        CustomModifier.ADAPTER.asRepeated().encodeWithTag(writer, 1, value.custom)
      }

      public override fun decode(reader: ProtoReader): Modifier {
        val custom = mutableListOf<CustomModifier>()
        var background: ColorModifier? = null
        var blur: OffsetModifier? = null
        var border: BorderModifier? = null
        var clickable: Boolean? = null
        var focusable: Boolean? = null
        var offset: OffsetModifier? = null
        var opacity: Float? = null
        var padding: InsetsModifier? = null
        var requireSize: SizeModifier? = null
        var shadow: ShadowModifier? = null
        var size: SizeModifier? = null
        var visible: Boolean? = null
        var weight: Float? = null
        val unknownFields = reader.forEachTag { tag ->
          when (tag) {
            1 -> custom.add(CustomModifier.ADAPTER.decode(reader))
            2 -> background = ColorModifier.ADAPTER.decode(reader)
            3 -> blur = OffsetModifier.ADAPTER.decode(reader)
            4 -> border = BorderModifier.ADAPTER.decode(reader)
            5 -> clickable = ProtoAdapter.BOOL.decode(reader)
            6 -> focusable = ProtoAdapter.BOOL.decode(reader)
            7 -> offset = OffsetModifier.ADAPTER.decode(reader)
            8 -> opacity = ProtoAdapter.FLOAT.decode(reader)
            9 -> padding = InsetsModifier.ADAPTER.decode(reader)
            10 -> requireSize = SizeModifier.ADAPTER.decode(reader)
            11 -> try {
              shadow = ShadowModifier.ADAPTER.decode(reader)
            } catch (e: ProtoAdapter.EnumConstantNotFoundException) {
              reader.addUnknownField(tag, FieldEncoding.VARINT, e.value.toLong())
            }
            12 -> size = SizeModifier.ADAPTER.decode(reader)
            13 -> visible = ProtoAdapter.BOOL.decode(reader)
            14 -> weight = ProtoAdapter.FLOAT.decode(reader)
            else -> reader.readUnknownField(tag)
          }
        }
        return Modifier(
          custom = custom,
          background = background,
          blur = blur,
          border = border,
          clickable = clickable,
          focusable = focusable,
          offset = offset,
          opacity = opacity,
          padding = padding,
          requireSize = requireSize,
          shadow = shadow,
          size = size,
          visible = visible,
          weight = weight,
          unknownFields = unknownFields
        )
      }

      public override fun redact(`value`: Modifier): Modifier = value.copy(
        custom = value.custom.redactElements(CustomModifier.ADAPTER),
        background = value.background?.let(ColorModifier.ADAPTER::redact),
        blur = value.blur?.let(OffsetModifier.ADAPTER::redact),
        border = value.border?.let(BorderModifier.ADAPTER::redact),
        offset = value.offset?.let(OffsetModifier.ADAPTER::redact),
        padding = value.padding?.let(InsetsModifier.ADAPTER::redact),
        requireSize = value.requireSize?.let(SizeModifier.ADAPTER::redact),
        size = value.size?.let(SizeModifier.ADAPTER::redact),
        unknownFields = ByteString.EMPTY
      )
    }

    @JvmField
    public val CREATOR: Parcelable.Creator<Modifier> = AndroidMessage.newCreator(ADAPTER)

    private const val serialVersionUID: Long = 0L
  }
}
