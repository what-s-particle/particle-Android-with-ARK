// Code generated by Wire protocol buffer compiler, do not edit.
// Source: com.yunlong.particle.proto.PickerComponent in generate/particle.proto
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
import kotlin.Int
import kotlin.Long
import kotlin.Nothing
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
import kotlin.jvm.JvmField
import okio.ByteString

/**
 * Picker layout used to create a dropdown list
 */
public class PickerComponent(
  /**
   * What to show when not expanded
   */
  @field:WireField(
    tag = 1,
    adapter = "com.yunlong.particle.proto.Particle#ADAPTER",
    label = WireField.Label.OMIT_IDENTITY,
  )
  public val iconContent: Particle? = null,
  options: List<Particle> = emptyList(),
  /**
   * Event that triggers its expansion
   */
  @field:WireField(
    tag = 3,
    adapter = "com.yunlong.particle.proto.Event#ADAPTER",
    label = WireField.Label.OMIT_IDENTITY,
  )
  public val trigger: Event = Event.TOUCH_EVENT,
  unknownFields: ByteString = ByteString.EMPTY,
) : AndroidMessage<PickerComponent, Nothing>(ADAPTER, unknownFields) {
  /**
   * The list of options available in the dropdown
   */
  @field:WireField(
    tag = 2,
    adapter = "com.yunlong.particle.proto.Particle#ADAPTER",
    label = WireField.Label.REPEATED,
  )
  public val options: List<Particle> = immutableCopyOf("options", options)

  @Deprecated(
    message = "Shouldn't be used in Kotlin",
    level = DeprecationLevel.HIDDEN,
  )
  public override fun newBuilder(): Nothing = throw
      AssertionError("Builders are deprecated and only available in a javaInterop build; see https://square.github.io/wire/wire_compiler/#kotlin")

  public override fun equals(other: Any?): Boolean {
    if (other === this) return true
    if (other !is PickerComponent) return false
    if (unknownFields != other.unknownFields) return false
    if (iconContent != other.iconContent) return false
    if (options != other.options) return false
    if (trigger != other.trigger) return false
    return true
  }

  public override fun hashCode(): Int {
    var result = super.hashCode
    if (result == 0) {
      result = unknownFields.hashCode()
      result = result * 37 + (iconContent?.hashCode() ?: 0)
      result = result * 37 + options.hashCode()
      result = result * 37 + trigger.hashCode()
      super.hashCode = result
    }
    return result
  }

  public override fun toString(): String {
    val result = mutableListOf<String>()
    if (iconContent != null) result += """iconContent=$iconContent"""
    if (options.isNotEmpty()) result += """options=$options"""
    result += """trigger=$trigger"""
    return result.joinToString(prefix = "PickerComponent{", separator = ", ", postfix = "}")
  }

  public fun copy(
    iconContent: Particle? = this.iconContent,
    options: List<Particle> = this.options,
    trigger: Event = this.trigger,
    unknownFields: ByteString = this.unknownFields,
  ): PickerComponent = PickerComponent(iconContent, options, trigger, unknownFields)

  public companion object {
    @JvmField
    public val ADAPTER: ProtoAdapter<PickerComponent> = object : ProtoAdapter<PickerComponent>(
      FieldEncoding.LENGTH_DELIMITED, 
      PickerComponent::class, 
      "type.googleapis.com/com.yunlong.particle.proto.PickerComponent", 
      PROTO_3, 
      null, 
      "generate/particle.proto"
    ) {
      public override fun encodedSize(`value`: PickerComponent): Int {
        var size = value.unknownFields.size
        if (value.iconContent != null) size += Particle.ADAPTER.encodedSizeWithTag(1,
            value.iconContent)
        size += Particle.ADAPTER.asRepeated().encodedSizeWithTag(2, value.options)
        if (value.trigger != Event.TOUCH_EVENT) size += Event.ADAPTER.encodedSizeWithTag(3,
            value.trigger)
        return size
      }

      public override fun encode(writer: ProtoWriter, `value`: PickerComponent): Unit {
        if (value.iconContent != null) Particle.ADAPTER.encodeWithTag(writer, 1, value.iconContent)
        Particle.ADAPTER.asRepeated().encodeWithTag(writer, 2, value.options)
        if (value.trigger != Event.TOUCH_EVENT) Event.ADAPTER.encodeWithTag(writer, 3,
            value.trigger)
        writer.writeBytes(value.unknownFields)
      }

      public override fun encode(writer: ReverseProtoWriter, `value`: PickerComponent): Unit {
        writer.writeBytes(value.unknownFields)
        if (value.trigger != Event.TOUCH_EVENT) Event.ADAPTER.encodeWithTag(writer, 3,
            value.trigger)
        Particle.ADAPTER.asRepeated().encodeWithTag(writer, 2, value.options)
        if (value.iconContent != null) Particle.ADAPTER.encodeWithTag(writer, 1, value.iconContent)
      }

      public override fun decode(reader: ProtoReader): PickerComponent {
        var iconContent: Particle? = null
        val options = mutableListOf<Particle>()
        var trigger: Event = Event.TOUCH_EVENT
        val unknownFields = reader.forEachTag { tag ->
          when (tag) {
            1 -> iconContent = Particle.ADAPTER.decode(reader)
            2 -> options.add(Particle.ADAPTER.decode(reader))
            3 -> try {
              trigger = Event.ADAPTER.decode(reader)
            } catch (e: ProtoAdapter.EnumConstantNotFoundException) {
              reader.addUnknownField(tag, FieldEncoding.VARINT, e.value.toLong())
            }
            else -> reader.readUnknownField(tag)
          }
        }
        return PickerComponent(
          iconContent = iconContent,
          options = options,
          trigger = trigger,
          unknownFields = unknownFields
        )
      }

      public override fun redact(`value`: PickerComponent): PickerComponent = value.copy(
        iconContent = value.iconContent?.let(Particle.ADAPTER::redact),
        options = value.options.redactElements(Particle.ADAPTER),
        unknownFields = ByteString.EMPTY
      )
    }

    @JvmField
    public val CREATOR: Parcelable.Creator<PickerComponent> = AndroidMessage.newCreator(ADAPTER)

    private const val serialVersionUID: Long = 0L
  }
}
