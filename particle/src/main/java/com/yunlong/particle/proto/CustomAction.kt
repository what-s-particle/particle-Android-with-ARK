// Code generated by Wire protocol buffer compiler, do not edit.
// Source: com.yunlong.particle.proto.CustomAction in generate/particle.proto
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
import kotlin.jvm.JvmField
import okio.ByteString

/**
 * Action to define by Particle user
 */
public class CustomAction(
  @field:WireField(
    tag = 1,
    adapter = "com.squareup.wire.ProtoAdapter#STRING",
    label = WireField.Label.OMIT_IDENTITY,
  )
  public val id: String = "",
  @field:WireField(
    tag = 2,
    adapter = "com.squareup.wire.ProtoAdapter#STRING",
  )
  public val payload: String? = null,
  unknownFields: ByteString = ByteString.EMPTY,
) : AndroidMessage<CustomAction, Nothing>(ADAPTER, unknownFields) {
  @Deprecated(
    message = "Shouldn't be used in Kotlin",
    level = DeprecationLevel.HIDDEN,
  )
  public override fun newBuilder(): Nothing = throw
      AssertionError("Builders are deprecated and only available in a javaInterop build; see https://square.github.io/wire/wire_compiler/#kotlin")

  public override fun equals(other: Any?): Boolean {
    if (other === this) return true
    if (other !is CustomAction) return false
    if (unknownFields != other.unknownFields) return false
    if (id != other.id) return false
    if (payload != other.payload) return false
    return true
  }

  public override fun hashCode(): Int {
    var result = super.hashCode
    if (result == 0) {
      result = unknownFields.hashCode()
      result = result * 37 + id.hashCode()
      result = result * 37 + (payload?.hashCode() ?: 0)
      super.hashCode = result
    }
    return result
  }

  public override fun toString(): String {
    val result = mutableListOf<String>()
    result += """id=${sanitize(id)}"""
    if (payload != null) result += """payload=${sanitize(payload)}"""
    return result.joinToString(prefix = "CustomAction{", separator = ", ", postfix = "}")
  }

  public fun copy(
    id: String = this.id,
    payload: String? = this.payload,
    unknownFields: ByteString = this.unknownFields,
  ): CustomAction = CustomAction(id, payload, unknownFields)

  public companion object {
    @JvmField
    public val ADAPTER: ProtoAdapter<CustomAction> = object : ProtoAdapter<CustomAction>(
      FieldEncoding.LENGTH_DELIMITED, 
      CustomAction::class, 
      "type.googleapis.com/com.yunlong.particle.proto.CustomAction", 
      PROTO_3, 
      null, 
      "generate/particle.proto"
    ) {
      public override fun encodedSize(`value`: CustomAction): Int {
        var size = value.unknownFields.size
        if (value.id != "") size += ProtoAdapter.STRING.encodedSizeWithTag(1, value.id)
        size += ProtoAdapter.STRING.encodedSizeWithTag(2, value.payload)
        return size
      }

      public override fun encode(writer: ProtoWriter, `value`: CustomAction): Unit {
        if (value.id != "") ProtoAdapter.STRING.encodeWithTag(writer, 1, value.id)
        ProtoAdapter.STRING.encodeWithTag(writer, 2, value.payload)
        writer.writeBytes(value.unknownFields)
      }

      public override fun encode(writer: ReverseProtoWriter, `value`: CustomAction): Unit {
        writer.writeBytes(value.unknownFields)
        ProtoAdapter.STRING.encodeWithTag(writer, 2, value.payload)
        if (value.id != "") ProtoAdapter.STRING.encodeWithTag(writer, 1, value.id)
      }

      public override fun decode(reader: ProtoReader): CustomAction {
        var id: String = ""
        var payload: String? = null
        val unknownFields = reader.forEachTag { tag ->
          when (tag) {
            1 -> id = ProtoAdapter.STRING.decode(reader)
            2 -> payload = ProtoAdapter.STRING.decode(reader)
            else -> reader.readUnknownField(tag)
          }
        }
        return CustomAction(
          id = id,
          payload = payload,
          unknownFields = unknownFields
        )
      }

      public override fun redact(`value`: CustomAction): CustomAction = value.copy(
        unknownFields = ByteString.EMPTY
      )
    }

    @JvmField
    public val CREATOR: Parcelable.Creator<CustomAction> = AndroidMessage.newCreator(ADAPTER)

    private const val serialVersionUID: Long = 0L
  }
}
