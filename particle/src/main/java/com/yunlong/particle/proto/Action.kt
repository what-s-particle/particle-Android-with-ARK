// Code generated by Wire protocol buffer compiler, do not edit.
// Source: com.yunlong.particle.proto.Action in generate/particle.proto
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
 *  An action is a specific task or behavior that is triggered by a user interaction,
 *  such as clicking a button or selecting an option from a menu. Actions can include a wide range
 * of behaviors,
 *  from displaying a message or changing the appearance of an interface element, to performing
 * complex operations
 *  such as sending data to a server or initiating a transaction.
 */
public class Action(
  /**
   * Action to define by Particle user
   */
  @field:WireField(
    tag = 1,
    adapter = "com.yunlong.particle.proto.CustomAction#ADAPTER",
    oneofName = "action",
  )
  public val custom: CustomAction? = null,
  /**
   * Action to open a new screen
   */
  @field:WireField(
    tag = 2,
    adapter = "com.yunlong.particle.proto.NavigateToAction#ADAPTER",
    oneofName = "action",
  )
  public val navigateTo: NavigateToAction? = null,
  /**
   * Action to open previous screen
   */
  @field:WireField(
    tag = 3,
    adapter = "com.yunlong.particle.proto.NavigateBackAction#ADAPTER",
    oneofName = "action",
  )
  public val navigateBack: NavigateBackAction? = null,
  /**
   * Action to show a dialog
   */
  @field:WireField(
    tag = 4,
    adapter = "com.yunlong.particle.proto.ShowDialogAction#ADAPTER",
    oneofName = "action",
  )
  public val showDialog: ShowDialogAction? = null,
  /**
   * Action to show a menu
   */
  @field:WireField(
    tag = 5,
    adapter = "com.yunlong.particle.proto.ShowMenuAction#ADAPTER",
    oneofName = "action",
  )
  public val showMenu: ShowMenuAction? = null,
  /**
   * Action to update the UI modifier
   */
  @field:WireField(
    tag = 6,
    adapter = "com.yunlong.particle.proto.UpdateModifierAction#ADAPTER",
    oneofName = "action",
  )
  public val updateModifier: UpdateModifierAction? = null,
  /**
   * Action to store data
   */
  @field:WireField(
    tag = 7,
    adapter = "com.yunlong.particle.proto.StoreDataAction#ADAPTER",
    oneofName = "action",
  )
  public val storeData: StoreDataAction? = null,
  /**
   * Action to send an HTTP request
   */
  @field:WireField(
    tag = 8,
    adapter = "com.yunlong.particle.proto.SendHttpRequestAction#ADAPTER",
    oneofName = "action",
  )
  public val sendHttpRequest: SendHttpRequestAction? = null,
  /**
   * Action to open the browser, mailbox, phone, camera, etc.
   */
  @field:WireField(
    tag = 9,
    adapter = "com.yunlong.particle.proto.OpenExternalAppAction#ADAPTER",
    oneofName = "action",
  )
  public val openExternalApp: OpenExternalAppAction? = null,
  @field:WireField(
    tag = 10,
    adapter = "com.yunlong.particle.proto.ConditionAction#ADAPTER",
    oneofName = "action",
  )
  public val condition: ConditionAction? = null,
  @field:WireField(
    tag = 11,
    adapter = "com.yunlong.particle.proto.RetrieveDataAction#ADAPTER",
    oneofName = "action",
  )
  public val retrieveData: RetrieveDataAction? = null,
  unknownFields: ByteString = ByteString.EMPTY,
) : AndroidMessage<Action, Nothing>(ADAPTER, unknownFields) {
  init {
    require(countNonNull(custom, navigateTo, navigateBack, showDialog, showMenu, updateModifier,
        storeData, sendHttpRequest, openExternalApp, condition, retrieveData) <= 1) {
      "At most one of custom, navigateTo, navigateBack, showDialog, showMenu, updateModifier, storeData, sendHttpRequest, openExternalApp, condition, retrieveData may be non-null"
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
    if (other !is Action) return false
    if (unknownFields != other.unknownFields) return false
    if (custom != other.custom) return false
    if (navigateTo != other.navigateTo) return false
    if (navigateBack != other.navigateBack) return false
    if (showDialog != other.showDialog) return false
    if (showMenu != other.showMenu) return false
    if (updateModifier != other.updateModifier) return false
    if (storeData != other.storeData) return false
    if (sendHttpRequest != other.sendHttpRequest) return false
    if (openExternalApp != other.openExternalApp) return false
    if (condition != other.condition) return false
    if (retrieveData != other.retrieveData) return false
    return true
  }

  public override fun hashCode(): Int {
    var result = super.hashCode
    if (result == 0) {
      result = unknownFields.hashCode()
      result = result * 37 + (custom?.hashCode() ?: 0)
      result = result * 37 + (navigateTo?.hashCode() ?: 0)
      result = result * 37 + (navigateBack?.hashCode() ?: 0)
      result = result * 37 + (showDialog?.hashCode() ?: 0)
      result = result * 37 + (showMenu?.hashCode() ?: 0)
      result = result * 37 + (updateModifier?.hashCode() ?: 0)
      result = result * 37 + (storeData?.hashCode() ?: 0)
      result = result * 37 + (sendHttpRequest?.hashCode() ?: 0)
      result = result * 37 + (openExternalApp?.hashCode() ?: 0)
      result = result * 37 + (condition?.hashCode() ?: 0)
      result = result * 37 + (retrieveData?.hashCode() ?: 0)
      super.hashCode = result
    }
    return result
  }

  public override fun toString(): String {
    val result = mutableListOf<String>()
    if (custom != null) result += """custom=$custom"""
    if (navigateTo != null) result += """navigateTo=$navigateTo"""
    if (navigateBack != null) result += """navigateBack=$navigateBack"""
    if (showDialog != null) result += """showDialog=$showDialog"""
    if (showMenu != null) result += """showMenu=$showMenu"""
    if (updateModifier != null) result += """updateModifier=$updateModifier"""
    if (storeData != null) result += """storeData=$storeData"""
    if (sendHttpRequest != null) result += """sendHttpRequest=$sendHttpRequest"""
    if (openExternalApp != null) result += """openExternalApp=$openExternalApp"""
    if (condition != null) result += """condition=$condition"""
    if (retrieveData != null) result += """retrieveData=$retrieveData"""
    return result.joinToString(prefix = "Action{", separator = ", ", postfix = "}")
  }

  public fun copy(
    custom: CustomAction? = this.custom,
    navigateTo: NavigateToAction? = this.navigateTo,
    navigateBack: NavigateBackAction? = this.navigateBack,
    showDialog: ShowDialogAction? = this.showDialog,
    showMenu: ShowMenuAction? = this.showMenu,
    updateModifier: UpdateModifierAction? = this.updateModifier,
    storeData: StoreDataAction? = this.storeData,
    sendHttpRequest: SendHttpRequestAction? = this.sendHttpRequest,
    openExternalApp: OpenExternalAppAction? = this.openExternalApp,
    condition: ConditionAction? = this.condition,
    retrieveData: RetrieveDataAction? = this.retrieveData,
    unknownFields: ByteString = this.unknownFields,
  ): Action = Action(custom, navigateTo, navigateBack, showDialog, showMenu, updateModifier,
      storeData, sendHttpRequest, openExternalApp, condition, retrieveData, unknownFields)

  public companion object {
    @JvmField
    public val ADAPTER: ProtoAdapter<Action> = object : ProtoAdapter<Action>(
      FieldEncoding.LENGTH_DELIMITED, 
      Action::class, 
      "type.googleapis.com/com.yunlong.particle.proto.Action", 
      PROTO_3, 
      null, 
      "generate/particle.proto"
    ) {
      public override fun encodedSize(`value`: Action): Int {
        var size = value.unknownFields.size
        size += CustomAction.ADAPTER.encodedSizeWithTag(1, value.custom)
        size += NavigateToAction.ADAPTER.encodedSizeWithTag(2, value.navigateTo)
        size += NavigateBackAction.ADAPTER.encodedSizeWithTag(3, value.navigateBack)
        size += ShowDialogAction.ADAPTER.encodedSizeWithTag(4, value.showDialog)
        size += ShowMenuAction.ADAPTER.encodedSizeWithTag(5, value.showMenu)
        size += UpdateModifierAction.ADAPTER.encodedSizeWithTag(6, value.updateModifier)
        size += StoreDataAction.ADAPTER.encodedSizeWithTag(7, value.storeData)
        size += SendHttpRequestAction.ADAPTER.encodedSizeWithTag(8, value.sendHttpRequest)
        size += OpenExternalAppAction.ADAPTER.encodedSizeWithTag(9, value.openExternalApp)
        size += ConditionAction.ADAPTER.encodedSizeWithTag(10, value.condition)
        size += RetrieveDataAction.ADAPTER.encodedSizeWithTag(11, value.retrieveData)
        return size
      }

      public override fun encode(writer: ProtoWriter, `value`: Action): Unit {
        CustomAction.ADAPTER.encodeWithTag(writer, 1, value.custom)
        NavigateToAction.ADAPTER.encodeWithTag(writer, 2, value.navigateTo)
        NavigateBackAction.ADAPTER.encodeWithTag(writer, 3, value.navigateBack)
        ShowDialogAction.ADAPTER.encodeWithTag(writer, 4, value.showDialog)
        ShowMenuAction.ADAPTER.encodeWithTag(writer, 5, value.showMenu)
        UpdateModifierAction.ADAPTER.encodeWithTag(writer, 6, value.updateModifier)
        StoreDataAction.ADAPTER.encodeWithTag(writer, 7, value.storeData)
        SendHttpRequestAction.ADAPTER.encodeWithTag(writer, 8, value.sendHttpRequest)
        OpenExternalAppAction.ADAPTER.encodeWithTag(writer, 9, value.openExternalApp)
        ConditionAction.ADAPTER.encodeWithTag(writer, 10, value.condition)
        RetrieveDataAction.ADAPTER.encodeWithTag(writer, 11, value.retrieveData)
        writer.writeBytes(value.unknownFields)
      }

      public override fun encode(writer: ReverseProtoWriter, `value`: Action): Unit {
        writer.writeBytes(value.unknownFields)
        RetrieveDataAction.ADAPTER.encodeWithTag(writer, 11, value.retrieveData)
        ConditionAction.ADAPTER.encodeWithTag(writer, 10, value.condition)
        OpenExternalAppAction.ADAPTER.encodeWithTag(writer, 9, value.openExternalApp)
        SendHttpRequestAction.ADAPTER.encodeWithTag(writer, 8, value.sendHttpRequest)
        StoreDataAction.ADAPTER.encodeWithTag(writer, 7, value.storeData)
        UpdateModifierAction.ADAPTER.encodeWithTag(writer, 6, value.updateModifier)
        ShowMenuAction.ADAPTER.encodeWithTag(writer, 5, value.showMenu)
        ShowDialogAction.ADAPTER.encodeWithTag(writer, 4, value.showDialog)
        NavigateBackAction.ADAPTER.encodeWithTag(writer, 3, value.navigateBack)
        NavigateToAction.ADAPTER.encodeWithTag(writer, 2, value.navigateTo)
        CustomAction.ADAPTER.encodeWithTag(writer, 1, value.custom)
      }

      public override fun decode(reader: ProtoReader): Action {
        var custom: CustomAction? = null
        var navigateTo: NavigateToAction? = null
        var navigateBack: NavigateBackAction? = null
        var showDialog: ShowDialogAction? = null
        var showMenu: ShowMenuAction? = null
        var updateModifier: UpdateModifierAction? = null
        var storeData: StoreDataAction? = null
        var sendHttpRequest: SendHttpRequestAction? = null
        var openExternalApp: OpenExternalAppAction? = null
        var condition: ConditionAction? = null
        var retrieveData: RetrieveDataAction? = null
        val unknownFields = reader.forEachTag { tag ->
          when (tag) {
            1 -> custom = CustomAction.ADAPTER.decode(reader)
            2 -> navigateTo = NavigateToAction.ADAPTER.decode(reader)
            3 -> navigateBack = NavigateBackAction.ADAPTER.decode(reader)
            4 -> showDialog = ShowDialogAction.ADAPTER.decode(reader)
            5 -> showMenu = ShowMenuAction.ADAPTER.decode(reader)
            6 -> updateModifier = UpdateModifierAction.ADAPTER.decode(reader)
            7 -> storeData = StoreDataAction.ADAPTER.decode(reader)
            8 -> sendHttpRequest = SendHttpRequestAction.ADAPTER.decode(reader)
            9 -> openExternalApp = OpenExternalAppAction.ADAPTER.decode(reader)
            10 -> condition = ConditionAction.ADAPTER.decode(reader)
            11 -> retrieveData = RetrieveDataAction.ADAPTER.decode(reader)
            else -> reader.readUnknownField(tag)
          }
        }
        return Action(
          custom = custom,
          navigateTo = navigateTo,
          navigateBack = navigateBack,
          showDialog = showDialog,
          showMenu = showMenu,
          updateModifier = updateModifier,
          storeData = storeData,
          sendHttpRequest = sendHttpRequest,
          openExternalApp = openExternalApp,
          condition = condition,
          retrieveData = retrieveData,
          unknownFields = unknownFields
        )
      }

      public override fun redact(`value`: Action): Action = value.copy(
        custom = value.custom?.let(CustomAction.ADAPTER::redact),
        navigateTo = value.navigateTo?.let(NavigateToAction.ADAPTER::redact),
        navigateBack = value.navigateBack?.let(NavigateBackAction.ADAPTER::redact),
        showDialog = value.showDialog?.let(ShowDialogAction.ADAPTER::redact),
        showMenu = value.showMenu?.let(ShowMenuAction.ADAPTER::redact),
        updateModifier = value.updateModifier?.let(UpdateModifierAction.ADAPTER::redact),
        storeData = value.storeData?.let(StoreDataAction.ADAPTER::redact),
        sendHttpRequest = value.sendHttpRequest?.let(SendHttpRequestAction.ADAPTER::redact),
        openExternalApp = value.openExternalApp?.let(OpenExternalAppAction.ADAPTER::redact),
        condition = value.condition?.let(ConditionAction.ADAPTER::redact),
        retrieveData = value.retrieveData?.let(RetrieveDataAction.ADAPTER::redact),
        unknownFields = ByteString.EMPTY
      )
    }

    @JvmField
    public val CREATOR: Parcelable.Creator<Action> = AndroidMessage.newCreator(ADAPTER)

    private const val serialVersionUID: Long = 0L
  }
}
