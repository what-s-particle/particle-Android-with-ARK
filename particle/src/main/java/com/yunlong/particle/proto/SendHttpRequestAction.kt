// Code generated by Wire protocol buffer compiler, do not edit.
// Source: com.yunlong.particle.proto.SendHttpRequestAction in generate/particle.proto
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
import kotlin.collections.Map
import kotlin.jvm.JvmField
import kotlin.lazy
import okio.ByteString

/**
 * Action to send an HTTP request
 */
public class SendHttpRequestAction(
  @field:WireField(
    tag = 1,
    adapter = "com.squareup.wire.ProtoAdapter#STRING",
    label = WireField.Label.OMIT_IDENTITY,
  )
  public val endpoint: String = "",
  @field:WireField(
    tag = 2,
    adapter = "com.yunlong.particle.proto.RequestType#ADAPTER",
    label = WireField.Label.OMIT_IDENTITY,
  )
  public val type: RequestType = RequestType.GET,
  body: Map<String, String> = emptyMap(),
  successActions: List<Action> = emptyList(),
  failureActions: List<Action> = emptyList(),
  unknownFields: ByteString = ByteString.EMPTY,
) : AndroidMessage<SendHttpRequestAction, Nothing>(ADAPTER, unknownFields) {
  @field:WireField(
    tag = 3,
    keyAdapter = "com.squareup.wire.ProtoAdapter#STRING",
    adapter = "com.squareup.wire.ProtoAdapter#STRING",
  )
  public val body: Map<String, String> = immutableCopyOf("body", body)

  @field:WireField(
    tag = 4,
    adapter = "com.yunlong.particle.proto.Action#ADAPTER",
    label = WireField.Label.REPEATED,
  )
  public val successActions: List<Action> = immutableCopyOf("successActions", successActions)

  @field:WireField(
    tag = 5,
    adapter = "com.yunlong.particle.proto.Action#ADAPTER",
    label = WireField.Label.REPEATED,
  )
  public val failureActions: List<Action> = immutableCopyOf("failureActions", failureActions)

  @Deprecated(
    message = "Shouldn't be used in Kotlin",
    level = DeprecationLevel.HIDDEN,
  )
  public override fun newBuilder(): Nothing = throw
      AssertionError("Builders are deprecated and only available in a javaInterop build; see https://square.github.io/wire/wire_compiler/#kotlin")

  public override fun equals(other: Any?): Boolean {
    if (other === this) return true
    if (other !is SendHttpRequestAction) return false
    if (unknownFields != other.unknownFields) return false
    if (endpoint != other.endpoint) return false
    if (type != other.type) return false
    if (body != other.body) return false
    if (successActions != other.successActions) return false
    if (failureActions != other.failureActions) return false
    return true
  }

  public override fun hashCode(): Int {
    var result = super.hashCode
    if (result == 0) {
      result = unknownFields.hashCode()
      result = result * 37 + endpoint.hashCode()
      result = result * 37 + type.hashCode()
      result = result * 37 + body.hashCode()
      result = result * 37 + successActions.hashCode()
      result = result * 37 + failureActions.hashCode()
      super.hashCode = result
    }
    return result
  }

  public override fun toString(): String {
    val result = mutableListOf<String>()
    result += """endpoint=${sanitize(endpoint)}"""
    result += """type=$type"""
    if (body.isNotEmpty()) result += """body=$body"""
    if (successActions.isNotEmpty()) result += """successActions=$successActions"""
    if (failureActions.isNotEmpty()) result += """failureActions=$failureActions"""
    return result.joinToString(prefix = "SendHttpRequestAction{", separator = ", ", postfix = "}")
  }

  public fun copy(
    endpoint: String = this.endpoint,
    type: RequestType = this.type,
    body: Map<String, String> = this.body,
    successActions: List<Action> = this.successActions,
    failureActions: List<Action> = this.failureActions,
    unknownFields: ByteString = this.unknownFields,
  ): SendHttpRequestAction = SendHttpRequestAction(endpoint, type, body, successActions,
      failureActions, unknownFields)

  public companion object {
    @JvmField
    public val ADAPTER: ProtoAdapter<SendHttpRequestAction> = object :
        ProtoAdapter<SendHttpRequestAction>(
      FieldEncoding.LENGTH_DELIMITED, 
      SendHttpRequestAction::class, 
      "type.googleapis.com/com.yunlong.particle.proto.SendHttpRequestAction", 
      PROTO_3, 
      null, 
      "generate/particle.proto"
    ) {
      private val bodyAdapter: ProtoAdapter<Map<String, String>> by lazy {
          ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, ProtoAdapter.STRING) }

      public override fun encodedSize(`value`: SendHttpRequestAction): Int {
        var size = value.unknownFields.size
        if (value.endpoint != "") size += ProtoAdapter.STRING.encodedSizeWithTag(1, value.endpoint)
        if (value.type != RequestType.GET) size += RequestType.ADAPTER.encodedSizeWithTag(2,
            value.type)
        size += bodyAdapter.encodedSizeWithTag(3, value.body)
        size += Action.ADAPTER.asRepeated().encodedSizeWithTag(4, value.successActions)
        size += Action.ADAPTER.asRepeated().encodedSizeWithTag(5, value.failureActions)
        return size
      }

      public override fun encode(writer: ProtoWriter, `value`: SendHttpRequestAction): Unit {
        if (value.endpoint != "") ProtoAdapter.STRING.encodeWithTag(writer, 1, value.endpoint)
        if (value.type != RequestType.GET) RequestType.ADAPTER.encodeWithTag(writer, 2, value.type)
        bodyAdapter.encodeWithTag(writer, 3, value.body)
        Action.ADAPTER.asRepeated().encodeWithTag(writer, 4, value.successActions)
        Action.ADAPTER.asRepeated().encodeWithTag(writer, 5, value.failureActions)
        writer.writeBytes(value.unknownFields)
      }

      public override fun encode(writer: ReverseProtoWriter, `value`: SendHttpRequestAction): Unit {
        writer.writeBytes(value.unknownFields)
        Action.ADAPTER.asRepeated().encodeWithTag(writer, 5, value.failureActions)
        Action.ADAPTER.asRepeated().encodeWithTag(writer, 4, value.successActions)
        bodyAdapter.encodeWithTag(writer, 3, value.body)
        if (value.type != RequestType.GET) RequestType.ADAPTER.encodeWithTag(writer, 2, value.type)
        if (value.endpoint != "") ProtoAdapter.STRING.encodeWithTag(writer, 1, value.endpoint)
      }

      public override fun decode(reader: ProtoReader): SendHttpRequestAction {
        var endpoint: String = ""
        var type: RequestType = RequestType.GET
        val body = mutableMapOf<String, String>()
        val successActions = mutableListOf<Action>()
        val failureActions = mutableListOf<Action>()
        val unknownFields = reader.forEachTag { tag ->
          when (tag) {
            1 -> endpoint = ProtoAdapter.STRING.decode(reader)
            2 -> try {
              type = RequestType.ADAPTER.decode(reader)
            } catch (e: ProtoAdapter.EnumConstantNotFoundException) {
              reader.addUnknownField(tag, FieldEncoding.VARINT, e.value.toLong())
            }
            3 -> body.putAll(bodyAdapter.decode(reader))
            4 -> successActions.add(Action.ADAPTER.decode(reader))
            5 -> failureActions.add(Action.ADAPTER.decode(reader))
            else -> reader.readUnknownField(tag)
          }
        }
        return SendHttpRequestAction(
          endpoint = endpoint,
          type = type,
          body = body,
          successActions = successActions,
          failureActions = failureActions,
          unknownFields = unknownFields
        )
      }

      public override fun redact(`value`: SendHttpRequestAction): SendHttpRequestAction =
          value.copy(
        successActions = value.successActions.redactElements(Action.ADAPTER),
        failureActions = value.failureActions.redactElements(Action.ADAPTER),
        unknownFields = ByteString.EMPTY
      )
    }

    @JvmField
    public val CREATOR: Parcelable.Creator<SendHttpRequestAction> =
        AndroidMessage.newCreator(ADAPTER)

    private const val serialVersionUID: Long = 0L
  }
}
