package com.wqfhr.www.funnyboxa.mvp.contract

import com.wqfhr.www.funnyboxa.bean.FuckGoods
import com.wqfhr.www.funnyboxa.bean.JsonResult
import rx.Observable

/**
 * Created by wing on 16-11-24.
 */
interface FuckGoodsContract {
    interface View {
        fun  setData(results: List<FuckGoods>)

    }

    interface Model {

        fun getData(page: Int,type:String): Observable<JsonResult<List<FuckGoods>>>
    }

    interface Presenter {

        open fun getData(page: Int, type: String)
    }
}