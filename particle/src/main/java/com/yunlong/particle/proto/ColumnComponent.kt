// Code generated by Wire protocol buffer compiler, do not edit.
// Source: com.yunlong.particle.proto.ColumnComponent in generate/particle.proto
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
 * Vertical stack layout component.
 */
public class ColumnComponent(
  elements: List<Particle> = emptyList(),
  @field:WireField(
    tag = 2,
    adapter = "com.yunlong.particle.proto.Arrangement#ADAPTER",
  )
  public val arrangement: Arrangement? = null,
  @field:WireField(
    tag = 3,
    adapter = "com.yunlong.particle.proto.Alignment#ADAPTER",
  )
  public val alignment: Alignment? = null,
  @field:WireField(
    tag = 4,
    adapter = "com.yunlong.particle.proto.SizeModifier#ADAPTER",
  )
  public val spacing: SizeModifier? = null,
  unknownFields: ByteString = ByteString.EMPTY,
) : AndroidMessage<ColumnComponent, Nothing>(ADAPTER, unknownFields) {
  /**
   * Child elements in the component.
   */
  @field:WireField(
    tag = 1,
    adapter = "com.yunlong.particle.proto.Particle#ADAPTER",
    label = WireField.Label.REPEATED,
  )
  public val elements: List<Particle> = immutableCopyOf("elements", elements)

  @Deprecated(
    message = "Shouldn't be used in Kotlin",
    level = DeprecationLevel.HIDDEN,
  )
  public override fun newBuilder(): Nothing = throw
      AssertionError("Builders are deprecated and only available in a javaInterop build; see https://square.github.io/wire/wire_compiler/#kotlin")

  public override fun equals(other: Any?): Boolean {
    if (other === this) return true
    if (other !is ColumnComponent) return false
    if (unknownFields != other.unknownFields) return false
    if (elements != other.elements) return false
    if (arrangement != other.arrangement) return false
    if (alignment != other.alignment) return false
    if (spacing != other.spacing) return false
    return true
  }

  public override fun hashCode(): Int {
    var result = super.hashCode
    if (result == 0) {
      result = unknownFields.hashCode()
      result = result * 37 + elements.hashCode()
      result = result * 37 + (arrangement?.hashCode() ?: 0)
      result = result * 37 + (alignment?.hashCode() ?: 0)
      result = result * 37 + (spacing?.hashCode() ?: 0)
      super.hashCode = result
    }
    return result
  }

  public override fun toString(): String {
    val result = mutableListOf<String>()
    if (elements.isNotEmpty()) result += """elements=$elements"""
    if (arrangement != null) result += """arrangement=$arrangement"""
    if (alignment != null) result += """alignment=$alignment"""
    if (spacing != null) result += """spacing=$spacing"""
    return result.joinToString(prefix = "ColumnComponent{", separator = ", ", postfix = "}")
  }

  public fun copy(
    elements: List<Particle> = this.elements,
    arrangement: Arrangement? = this.arrangement,
    alignment: Alignment? = this.alignment,
    spacing: SizeModifier? = this.spacing,
    unknownFields: ByteString = this.unknownFields,
  ): ColumnComponent = ColumnComponent(elements, arrangement, alignment, spacing, unknownFields)

  public companion object {
    @JvmField
    public val ADAPTER: ProtoAdapter<ColumnComponent> = object : ProtoAdapter<ColumnComponent>(
      FieldEncoding.LENGTH_DELIMITED, 
      ColumnComponent::class, 
      "type.googleapis.com/com.yunlong.particle.proto.ColumnComponent", 
      PROTO_3, 
      null, 
      "generate/particle.proto"
    ) {
      public override fun encodedSize(`value`: ColumnComponent): Int {
        var size = value.unknownFields.size
        size += Particle.ADAPTER.asRepeated().encodedSizeWithTag(1, value.elements)
        size += Arrangement.ADAPTER.encodedSizeWithTag(2, value.arrangement)
        size += Alignment.ADAPTER.encodedSizeWithTag(3, value.alignment)
        size += SizeModifier.ADAPTER.encodedSizeWithTag(4, value.spacing)
        return size
      }

      public override fun encode(writer: ProtoWriter, `value`: ColumnComponent): Unit {
        Particle.ADAPTER.asRepeated().encodeWithTag(writer, 1, value.elements)
        Arrangement.ADAPTER.encodeWithTag(writer, 2, value.arrangement)
        Alignment.ADAPTER.encodeWithTag(writer, 3, value.alignment)
        SizeModifier.ADAPTER.encodeWithTag(writer, 4, value.spacing)
        writer.writeBytes(value.unknownFields)
      }

      public override fun encode(writer: ReverseProtoWriter, `value`: ColumnComponent): Unit {
        writer.writeBytes(value.unknownFields)
        SizeModifier.ADAPTER.encodeWithTag(writer, 4, value.spacing)
        Alignment.ADAPTER.encodeWithTag(writer, 3, value.alignment)
        Arrangement.ADAPTER.encodeWithTag(writer, 2, value.arrangement)
        Particle.ADAPTER.asRepeated().encodeWithTag(writer, 1, value.elements)
      }

      public override fun decode(reader: ProtoReader): ColumnComponent {
        val elements = mutableListOf<Particle>()
        var arrangement: Arrangement? = null
        var alignment: Alignment? = null
        var spacing: SizeModifier? = null
        val unknownFields = reader.forEachTag { tag ->
          when (tag) {
            1 -> elements.add(Particle.ADAPTER.decode(reader))
            2 -> try {
              arrangement = Arrangement.ADAPTER.decode(reader)
            } catch (e: ProtoAdapter.EnumConstantNotFoundException) {
              reader.addUnknownField(tag, FieldEncoding.VARINT, e.value.toLong())
            }
            3 -> try {
              alignment = Alignment.ADAPTER.decode(reader)
            } catch (e: ProtoAdapter.EnumConstantNotFoundException) {
              reader.addUnknownField(tag, FieldEncoding.VARINT, e.value.toLong())
            }
            4 -> spacing = SizeModifier.ADAPTER.decode(reader)
            else -> reader.readUnknownField(tag)
          }
        }
        return ColumnComponent(
          elements = elements,
          arrangement = arrangement,
          alignment = alignment,
          spacing = spacing,
          unknownFields = unknownFields
        )
      }

      public override fun redact(`value`: ColumnComponent): ColumnComponent = value.copy(
        elements = value.elements.redactElements(Particle.ADAPTER),
        spacing = value.spacing?.let(SizeModifier.ADAPTER::redact),
        unknownFields = ByteString.EMPTY
      )
    }

    @JvmField
    public val CREATOR: Parcelable.Creator<ColumnComponent> = AndroidMessage.newCreator(ADAPTER)

    private const val serialVersionUID: Long = 0L
  }
}
