package com.wqfhr.www.funnyboxa.di.component

import com.wqfhr.www.funnyboxa.App
import com.wqfhr.www.funnyboxa.di.module.ApiModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by wing on 16-11-23.
 */
@Singleton
@Component(modules = arrayOf(ApiModule::class))
interface ApiComponent {
  fun inject(app: App)
  fun plus(module: FuckGoodsModule): FuckGoodsComponent
  fun plus(module: RandomModule): RandomComponent
}

