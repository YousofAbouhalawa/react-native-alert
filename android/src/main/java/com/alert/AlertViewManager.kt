package com.alert

import android.graphics.Color
import com.facebook.react.module.annotations.ReactModule
import com.facebook.react.uimanager.SimpleViewManager
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.ViewManagerDelegate
import com.facebook.react.uimanager.annotations.ReactProp
import com.facebook.react.viewmanagers.AlertViewManagerInterface
import com.facebook.react.viewmanagers.AlertViewManagerDelegate

@ReactModule(name = AlertViewManager.NAME)
class AlertViewManager : SimpleViewManager<AlertView>(),
  AlertViewManagerInterface<AlertView> {
  private val mDelegate: ViewManagerDelegate<AlertView>

  init {
    mDelegate = AlertViewManagerDelegate(this)
  }

  override fun getDelegate(): ViewManagerDelegate<AlertView>? {
    return mDelegate
  }

  override fun getName(): String {
    return NAME
  }

  public override fun createViewInstance(context: ThemedReactContext): AlertView {
    return AlertView(context)
  }

  @ReactProp(name = "color")
  override fun setColor(view: AlertView?, color: Int?) {
    view?.setBackgroundColor(color ?: Color.TRANSPARENT)
  }

  companion object {
    const val NAME = "AlertView"
  }
}
