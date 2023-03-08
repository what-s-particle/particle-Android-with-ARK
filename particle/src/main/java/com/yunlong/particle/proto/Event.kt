// Code generated by Wire protocol buffer compiler, do not edit.
// Source: com.yunlong.particle.proto.Event in generate/particle.proto
package com.yunlong.particle.proto

import com.squareup.wire.EnumAdapter
import com.squareup.wire.ProtoAdapter
import com.squareup.wire.Syntax.PROTO_3
import com.squareup.wire.WireEnum
import kotlin.Int
import kotlin.jvm.JvmField
import kotlin.jvm.JvmStatic

/**
 * An event is a notification that a specific action or interaction has occurred within a software
 * application.
 * Events can include user interactions such as clicking a button or scrolling a page, system
 * notifications such as
 * errors or warnings, or any other type of application-specific behavior.
 *
 * Events can be used to trigger other actions or behaviors within an application, or to provide
 * feedback
 * to the user about the state of the application.
 */
public enum class Event(
  public override val `value`: Int,
) : WireEnum {
  /**
   * User Events 0 ~19
   * The event when the user touches the screen.
   */
  TOUCH_EVENT(0),
  /**
   * The event when the user taps the screen.
   */
  TAP_EVENT(1),
  /**
   * The event when the user  double tap the screen.
   */
  DOUBLE_TAP_EVENT(2),
  /**
   * The event when the user zooms in or out using two fingers on the screen.
   */
  PINCH_EVENT(3),
  /**
   * The event when the user presses and holds the screen.
   */
  LONG_PRESS_EVENT(4),
  /**
   * The event when the user scrolls on the screen.
   */
  SCROLL_EVENT(5),
  /**
   * The event when the user presses a key on the keyboard.
   */
  ROTATE_EVENT(6),
  /**
   * The event when an element loses focus.
   */
  BLUR_EVENT(12),
  /**
   * The event when the value of an element changes.
   */
  CHANGE_EVENT(13),
  /**
   * The event when an element gains focus.
   */
  FOCUS_EVENT(14),
  /**
   * The event when the user inputs text.
   */
  INPUT_EVENT(15),
  /**
   * The event when a form element is reset.
   */
  RESET_EVENT(16),
  /**
   * Application and page lifecycle Events 20~29
   */
  APP_START_EVENT(20),
  APP_FOREGROUND_EVENT(21),
  APP_BACKGROUND_EVENT(22),
  APP_EXIT_EVENT(23),
  PAGE_LOADED_EVENT(24),
  /**
   * System Events 30~39
   */
  PUSH_NOTIFICATION_RECEIVED(30),
  PUSH_NOTIFICATION_OPENED(31),
  /**
   * The event when the device connects to a network.
   */
  NETWORK_CONNECTED_EVENT(32),
  /**
   * The event when the device disconnects from a network.
   */
  NETWORK_DISCONNECTED_EVENT(33),
  /**
   * Device events  40~49
   */
  BATTERY_LOW(40),
  BATTERY_CHANGE(41),
  SCREEN_ON(42),
  SCREEN_OFF(43),
  /**
   * Location Events
   * The event when the device location changes.
   */
  LOCATION_UPDATE_EVENT(50),
  /**
   * Bluetooth Events
   * GPS Events
   * Layout and element Events 100~200
   */
  ON_ACTION_SHEET_ITEM_CLICK(100),
  ON_CHECKBOX_CHANGE(101),
  ON_NAVIGATION_BAR_ITEM_CLICK(102),
  ON_PICKER_ITEM_CLICK(103),
  ON_RADIO_BUTTON_CLICK(104),
  ON_SLIDER_VALUE_CHANGED(105),
  ON_TEXT_FIELD_VALUE_CHANGED(106),
  ON_TEXT_EDITOR_VALUE_CHANGED(107),
  ON_TOGGLE_CHECKED_CHANGE(108),
  ;

  public companion object {
    @JvmField
    public val ADAPTER: ProtoAdapter<Event> = object : EnumAdapter<Event>(
      Event::class, 
      PROTO_3, 
      Event.TOUCH_EVENT
    ) {
      public override fun fromValue(`value`: Int): Event? = Event.fromValue(value)
    }

    @JvmStatic
    public fun fromValue(`value`: Int): Event? = when (value) {
      0 -> TOUCH_EVENT
      1 -> TAP_EVENT
      2 -> DOUBLE_TAP_EVENT
      3 -> PINCH_EVENT
      4 -> LONG_PRESS_EVENT
      5 -> SCROLL_EVENT
      6 -> ROTATE_EVENT
      12 -> BLUR_EVENT
      13 -> CHANGE_EVENT
      14 -> FOCUS_EVENT
      15 -> INPUT_EVENT
      16 -> RESET_EVENT
      20 -> APP_START_EVENT
      21 -> APP_FOREGROUND_EVENT
      22 -> APP_BACKGROUND_EVENT
      23 -> APP_EXIT_EVENT
      24 -> PAGE_LOADED_EVENT
      30 -> PUSH_NOTIFICATION_RECEIVED
      31 -> PUSH_NOTIFICATION_OPENED
      32 -> NETWORK_CONNECTED_EVENT
      33 -> NETWORK_DISCONNECTED_EVENT
      40 -> BATTERY_LOW
      41 -> BATTERY_CHANGE
      42 -> SCREEN_ON
      43 -> SCREEN_OFF
      50 -> LOCATION_UPDATE_EVENT
      100 -> ON_ACTION_SHEET_ITEM_CLICK
      101 -> ON_CHECKBOX_CHANGE
      102 -> ON_NAVIGATION_BAR_ITEM_CLICK
      103 -> ON_PICKER_ITEM_CLICK
      104 -> ON_RADIO_BUTTON_CLICK
      105 -> ON_SLIDER_VALUE_CHANGED
      106 -> ON_TEXT_FIELD_VALUE_CHANGED
      107 -> ON_TEXT_EDITOR_VALUE_CHANGED
      108 -> ON_TOGGLE_CHECKED_CHANGE
      else -> null
    }
  }
}
