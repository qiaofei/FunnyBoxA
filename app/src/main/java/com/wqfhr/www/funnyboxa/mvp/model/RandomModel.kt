package com.wqfhr.www.funnyboxa.mvp.model

import com.wqfhr.www.funnyboxa.api.GankApi
import com.wqfhr.www.funnyboxa.bean.FuckGoods
import com.wqfhr.www.funnyboxa.bean.JsonResult
import com.wqfhr.www.funnyboxa.mvp.contract.RandomContract
import rx.Observable
import javax.inject.Inject

/**
 * Created by wing on 16-11-25.
 */
class RandomModel
@Inject constructor(private val api:GankApi) :RandomContract.Model{

    override fun getRandom(type:String): Observable<JsonResult<List<FuckGoods>>> {
        return api.getRandom(type)
    }
}
