package com.wqfhr.www.funnyboxa.mvp.presenter

import com.wqfhr.www.funnyboxa.mvp.contract.RandomContract
import com.wqfhr.www.funnyboxa.mvp.model.RandomModel
import rx.android.schedulers.AndroidSchedulers
import javax.inject.Inject

/**
 * Created by wing on 16-11-25.
 */
class RandomPresenter
@Inject constructor(private val mModel: RandomModel,
                    private val mView: RandomContract.View) : RandomContract.Presenter, BasePresenter() {
    override fun getRandom(type: String) {
        addSubscription(mModel.getRandom(type).observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    res ->
                    if (!res.error) {
                        mView.onRandom(res.results[0])
                    }
                }, {}))
    }
}