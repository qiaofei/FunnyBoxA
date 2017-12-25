package com.wqfhr.www.funnyboxa.di.component

import com.wqfhr.www.funnyboxa.mvp.contract.FuckGoodsContract
import com.wqfhr.www.funnyboxa.ui.fragment.AndroidFragment
import com.wqfhr.www.funnyboxa.ui.fragment.GirlFragment
import com.wqfhr.www.funnyboxa.ui.fragment.IOSFragment
import dagger.Module
import dagger.Provides
import dagger.Subcomponent

/**
 * Created by wing on 16-11-24.
 */
@Subcomponent(modules = arrayOf(FuckGoodsModule::class))
interface FuckGoodsComponent {
    fun inject(fragment: AndroidFragment)
    fun inject(fragment: IOSFragment)

    fun inject(fragment: GirlFragment)
}

@Module
class FuckGoodsModule(private val mView: FuckGoodsContract.View){
    @Provides fun getView() = mView
}