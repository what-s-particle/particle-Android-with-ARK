// Code generated by Wire protocol buffer compiler, do not edit.
// Source: com.yunlong.particle.proto.Particle in generate/particle.proto
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
import com.squareup.wire.`internal`.countNonNull
import com.squareup.wire.`internal`.immutableCopyOf
import com.squareup.wire.`internal`.redactElements
import com.squareup.wire.`internal`.sanitize
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

public class Particle(
  @field:WireField(
    tag = 1,
    adapter = "com.squareup.wire.ProtoAdapter#STRING",
    label = WireField.Label.OMIT_IDENTITY,
  )
  public val id: String = "",
  @field:WireField(
    tag = 2,
    adapter = "com.yunlong.particle.proto.ElementComponent#ADAPTER",
    oneofName = "component",
  )
  public val element: ElementComponent? = null,
  @field:WireField(
    tag = 3,
    adapter = "com.yunlong.particle.proto.LayoutComponent#ADAPTER",
    oneofName = "component",
  )
  public val layout: LayoutComponent? = null,
  @field:WireField(
    tag = 4,
    adapter = "com.yunlong.particle.proto.Modifier#ADAPTER",
    label = WireField.Label.OMIT_IDENTITY,
  )
  public val modifier: Modifier? = null,
  interactions: List<Interaction> = emptyList(),
  unknownFields: ByteString = ByteString.EMPTY,
) : AndroidMessage<Particle, Nothing>(ADAPTER, unknownFields) {
  @field:WireField(
    tag = 5,
    adapter = "com.yunlong.particle.proto.Interaction#ADAPTER",
    label = WireField.Label.REPEATED,
  )
  public val interactions: List<Interaction> = immutableCopyOf("interactions", interactions)

  init {
    require(countNonNull(element, layout) <= 1) {
      "At most one of element, layout may be non-null"
    }
  }

  @Deprecated(
    message = "Shouldn't be used in Kotlin",
    level = DeprecationLevel.HIDDEN,
  )
  public override fun newBuilder(): Nothing = throw
      AssertionError("Builders are deprecated and only available in a javaInterop build; see https://square.github.io/wire/wire_compiler/#kotlin")

  public override fun equals(other: Any?): Boolean {
    if (other === this) return true
    if (other !is Particle) return false
    if (unknownFields != other.unknownFields) return false
    if (id != other.id) return false
    if (element != other.element) return false
    if (layout != other.layout) return false
    if (modifier != other.modifier) return false
    if (interactions != other.interactions) return false
    return true
  }

  public override fun hashCode(): Int {
    var result = super.hashCode
    if (result == 0) {
      result = unknownFields.hashCode()
      result = result * 37 + id.hashCode()
      result = result * 37 + (element?.hashCode() ?: 0)
      result = result * 37 + (layout?.hashCode() ?: 0)
      result = result * 37 + (modifier?.hashCode() ?: 0)
      result = result * 37 + interactions.hashCode()
      super.hashCode = result
    }
    return result
  }

  public override fun toString(): String {
    val result = mutableListOf<String>()
    result += """id=${sanitize(id)}"""
    if (element != null) result += """element=$element"""
    if (layout != null) result += """layout=$layout"""
    if (modifier != null) result += """modifier=$modifier"""
    if (interactions.isNotEmpty()) result += """interactions=$interactions"""
    return result.joinToString(prefix = "Particle{", separator = ", ", postfix = "}")
  }

  public fun copy(
    id: String = this.id,
    element: ElementComponent? = this.element,
    layout: LayoutComponent? = this.layout,
    modifier: Modifier? = this.modifier,
    interactions: List<Interaction> = this.interactions,
    unknownFields: ByteString = this.unknownFields,
  ): Particle = Particle(id, element, layout, modifier, interactions, unknownFields)

  public companion object {
    @JvmField
    public val ADAPTER: ProtoAdapter<Particle> = object : ProtoAdapter<Particle>(
      FieldEncoding.LENGTH_DELIMITED, 
      Particle::class, 
      "type.googleapis.com/com.yunlong.particle.proto.Particle", 
      PROTO_3, 
      null, 
      "generate/particle.proto"
    ) {
      public override fun encodedSize(`value`: Particle): Int {
        var size = value.unknownFields.size
        if (value.id != "") size += ProtoAdapter.STRING.encodedSizeWithTag(1, value.id)
        size += ElementComponent.ADAPTER.encodedSizeWithTag(2, value.element)
        size += LayoutComponent.ADAPTER.encodedSizeWithTag(3, value.layout)
        if (value.modifier != null) size += Modifier.ADAPTER.encodedSizeWithTag(4, value.modifier)
        size += Interaction.ADAPTER.asRepeated().encodedSizeWithTag(5, value.interactions)
        return size
      }

      public override fun encode(writer: ProtoWriter, `value`: Particle): Unit {
        if (value.id != "") ProtoAdapter.STRING.encodeWithTag(writer, 1, value.id)
        if (value.modifier != null) Modifier.ADAPTER.encodeWithTag(writer, 4, value.modifier)
        Interaction.ADAPTER.asRepeated().encodeWithTag(writer, 5, value.interactions)
        ElementComponent.ADAPTER.encodeWithTag(writer, 2, value.element)
        LayoutComponent.ADAPTER.encodeWithTag(writer, 3, value.layout)
        writer.writeBytes(value.unknownFields)
      }

      public override fun encode(writer: ReverseProtoWriter, `value`: Particle): Unit {
        writer.writeBytes(value.unknownFields)
        LayoutComponent.ADAPTER.encodeWithTag(writer, 3, value.layout)
        ElementComponent.ADAPTER.encodeWithTag(writer, 2, value.element)
        Interaction.ADAPTER.asRepeated().encodeWithTag(writer, 5, value.interactions)
        if (value.modifier != null) Modifier.ADAPTER.encodeWithTag(writer, 4, value.modifier)
        if (value.id != "") ProtoAdapter.STRING.encodeWithTag(writer, 1, value.id)
      }

      public override fun decode(reader: ProtoReader): Particle {
        var id: String = ""
        var element: ElementComponent? = null
        var layout: LayoutComponent? = null
        var modifier: Modifier? = null
        val interactions = mutableListOf<Interaction>()
        val unknownFields = reader.forEachTag { tag ->
          when (tag) {
            1 -> id = ProtoAdapter.STRING.decode(reader)
            2 -> element = ElementComponent.ADAPTER.decode(reader)
            3 -> layout = LayoutComponent.ADAPTER.decode(reader)
            4 -> modifier = Modifier.ADAPTER.decode(reader)
            5 -> interactions.add(Interaction.ADAPTER.decode(reader))
            else -> reader.readUnknownField(tag)
          }
        }
        return Particle(
          id = id,
          element = element,
          layout = layout,
          modifier = modifier,
          interactions = interactions,
          unknownFields = unknownFields
        )
      }

      public override fun redact(`value`: Particle): Particle = value.copy(
        element = value.element?.let(ElementComponent.ADAPTER::redact),
        layout = value.layout?.let(LayoutComponent.ADAPTER::redact),
        modifier = value.modifier?.let(Modifier.ADAPTER::redact),
        interactions = value.interactions.redactElements(Interaction.ADAPTER),
        unknownFields = ByteString.EMPTY
      )
    }

    @JvmField
    public val CREATOR: Parcelable.Creator<Particle> = AndroidMessage.newCreator(ADAPTER)

    private const val serialVersionUID: Long = 0L
  }
}
