package com.wqfhr.www.funnyboxa

import android.app.Application
import com.wqfhr.www.funnyboxa.di.component.ApiComponent
import com.wqfhr.www.funnyboxa.di.component.DaggerApiComponent
import com.wqfhr.www.funnyboxa.di.module.ApiModule
import com.wqfhr.www.funnyboxa.di.module.AppModule
import javax.inject.Inject

/**
 * Created by wing on 16-11-22.
 */
class App : Application() {
  init {
    instance = this
  }

  @Inject lateinit var apiComponent: ApiComponent
  override fun onCreate() {
    super.onCreate()
    DaggerApiComponent.builder()
     .apiModule(ApiModule())
     .appModule(AppModule(this))
     .build()
     .inject(this)
  }

  companion object {
    lateinit var instance: App

  }
}