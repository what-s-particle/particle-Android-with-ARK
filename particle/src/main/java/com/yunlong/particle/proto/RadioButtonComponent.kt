// Code generated by Wire protocol buffer compiler, do not edit.
// Source: com.yunlong.particle.proto.RadioButtonComponent in generate/particle.proto
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

/**
 * RadioButton Element used to create a radio button
 */
public class RadioButtonComponent(
  /**
   * Whether the RadioButton is selected
   */
  @field:WireField(
    tag = 1,
    adapter = "com.squareup.wire.ProtoAdapter#BOOL",
  )
  public val selected: Boolean? = null,
  /**
   * Whether the RadioButton is enabled
   */
  @field:WireField(
    tag = 2,
    adapter = "com.squareup.wire.ProtoAdapter#BOOL",
  )
  public val enabled: Boolean? = null,
  /**
   * Color of the RadioButton when selected
   */
  @field:WireField(
    tag = 3,
    adapter = "com.yunlong.particle.proto.ColorModifier#ADAPTER",
  )
  public val selectedColor: ColorModifier? = null,
  /**
   * Color of the RadioButton when not selected
   */
  @field:WireField(
    tag = 4,
    adapter = "com.yunlong.particle.proto.ColorModifier#ADAPTER",
  )
  public val unselectedColor: ColorModifier? = null,
  /**
   * Color of the  RadioButton when disabled
   */
  @field:WireField(
    tag = 5,
    adapter = "com.yunlong.particle.proto.ColorModifier#ADAPTER",
  )
  public val disabledColor: ColorModifier? = null,
  unknownFields: ByteString = ByteString.EMPTY,
) : AndroidMessage<RadioButtonComponent, Nothing>(ADAPTER, unknownFields) {
  @Deprecated(
    message = "Shouldn't be used in Kotlin",
    level = DeprecationLevel.HIDDEN,
  )
  public override fun newBuilder(): Nothing = throw
      AssertionError("Builders are deprecated and only available in a javaInterop build; see https://square.github.io/wire/wire_compiler/#kotlin")

  public override fun equals(other: Any?): Boolean {
    if (other === this) return true
    if (other !is RadioButtonComponent) return false
    if (unknownFields != other.unknownFields) return false
    if (selected != other.selected) return false
    if (enabled != other.enabled) return false
    if (selectedColor != other.selectedColor) return false
    if (unselectedColor != other.unselectedColor) return false
    if (disabledColor != other.disabledColor) return false
    return true
  }

  public override fun hashCode(): Int {
    var result = super.hashCode
    if (result == 0) {
      result = unknownFields.hashCode()
      result = result * 37 + (selected?.hashCode() ?: 0)
      result = result * 37 + (enabled?.hashCode() ?: 0)
      result = result * 37 + (selectedColor?.hashCode() ?: 0)
      result = result * 37 + (unselectedColor?.hashCode() ?: 0)
      result = result * 37 + (disabledColor?.hashCode() ?: 0)
      super.hashCode = result
    }
    return result
  }

  public override fun toString(): String {
    val result = mutableListOf<String>()
    if (selected != null) result += """selected=$selected"""
    if (enabled != null) result += """enabled=$enabled"""
    if (selectedColor != null) result += """selectedColor=$selectedColor"""
    if (unselectedColor != null) result += """unselectedColor=$unselectedColor"""
    if (disabledColor != null) result += """disabledColor=$disabledColor"""
    return result.joinToString(prefix = "RadioButtonComponent{", separator = ", ", postfix = "}")
  }

  public fun copy(
    selected: Boolean? = this.selected,
    enabled: Boolean? = this.enabled,
    selectedColor: ColorModifier? = this.selectedColor,
    unselectedColor: ColorModifier? = this.unselectedColor,
    disabledColor: ColorModifier? = this.disabledColor,
    unknownFields: ByteString = this.unknownFields,
  ): RadioButtonComponent = RadioButtonComponent(selected, enabled, selectedColor, unselectedColor,
      disabledColor, unknownFields)

  public companion object {
    @JvmField
    public val ADAPTER: ProtoAdapter<RadioButtonComponent> = object :
        ProtoAdapter<RadioButtonComponent>(
      FieldEncoding.LENGTH_DELIMITED, 
      RadioButtonComponent::class, 
      "type.googleapis.com/com.yunlong.particle.proto.RadioButtonComponent", 
      PROTO_3, 
      null, 
      "generate/particle.proto"
    ) {
      public override fun encodedSize(`value`: RadioButtonComponent): Int {
        var size = value.unknownFields.size
        size += ProtoAdapter.BOOL.encodedSizeWithTag(1, value.selected)
        size += ProtoAdapter.BOOL.encodedSizeWithTag(2, value.enabled)
        size += ColorModifier.ADAPTER.encodedSizeWithTag(3, value.selectedColor)
        size += ColorModifier.ADAPTER.encodedSizeWithTag(4, value.unselectedColor)
        size += ColorModifier.ADAPTER.encodedSizeWithTag(5, value.disabledColor)
        return size
      }

      public override fun encode(writer: ProtoWriter, `value`: RadioButtonComponent): Unit {
        ProtoAdapter.BOOL.encodeWithTag(writer, 1, value.selected)
        ProtoAdapter.BOOL.encodeWithTag(writer, 2, value.enabled)
        ColorModifier.ADAPTER.encodeWithTag(writer, 3, value.selectedColor)
        ColorModifier.ADAPTER.encodeWithTag(writer, 4, value.unselectedColor)
        ColorModifier.ADAPTER.encodeWithTag(writer, 5, value.disabledColor)
        writer.writeBytes(value.unknownFields)
      }

      public override fun encode(writer: ReverseProtoWriter, `value`: RadioButtonComponent): Unit {
        writer.writeBytes(value.unknownFields)
        ColorModifier.ADAPTER.encodeWithTag(writer, 5, value.disabledColor)
        ColorModifier.ADAPTER.encodeWithTag(writer, 4, value.unselectedColor)
        ColorModifier.ADAPTER.encodeWithTag(writer, 3, value.selectedColor)
        ProtoAdapter.BOOL.encodeWithTag(writer, 2, value.enabled)
        ProtoAdapter.BOOL.encodeWithTag(writer, 1, value.selected)
      }

      public override fun decode(reader: ProtoReader): RadioButtonComponent {
        var selected: Boolean? = null
        var enabled: Boolean? = null
        var selectedColor: ColorModifier? = null
        var unselectedColor: ColorModifier? = null
        var disabledColor: ColorModifier? = null
        val unknownFields = reader.forEachTag { tag ->
          when (tag) {
            1 -> selected = ProtoAdapter.BOOL.decode(reader)
            2 -> enabled = ProtoAdapter.BOOL.decode(reader)
            3 -> selectedColor = ColorModifier.ADAPTER.decode(reader)
            4 -> unselectedColor = ColorModifier.ADAPTER.decode(reader)
            5 -> disabledColor = ColorModifier.ADAPTER.decode(reader)
            else -> reader.readUnknownField(tag)
          }
        }
        return RadioButtonComponent(
          selected = selected,
          enabled = enabled,
          selectedColor = selectedColor,
          unselectedColor = unselectedColor,
          disabledColor = disabledColor,
          unknownFields = unknownFields
        )
      }

      public override fun redact(`value`: RadioButtonComponent): RadioButtonComponent = value.copy(
        selectedColor = value.selectedColor?.let(ColorModifier.ADAPTER::redact),
        unselectedColor = value.unselectedColor?.let(ColorModifier.ADAPTER::redact),
        disabledColor = value.disabledColor?.let(ColorModifier.ADAPTER::redact),
        unknownFields = ByteString.EMPTY
      )
    }

    @JvmField
    public val CREATOR: Parcelable.Creator<RadioButtonComponent> =
        AndroidMessage.newCreator(ADAPTER)

    private const val serialVersionUID: Long = 0L
  }
}
