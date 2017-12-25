package com.wqfhr.www.funnyboxa.mvp.model

import com.wqfhr.www.funnyboxa.api.GankApi
import com.wqfhr.www.funnyboxa.bean.FuckGoods
import com.wqfhr.www.funnyboxa.bean.JsonResult
import com.wqfhr.www.funnyboxa.mvp.contract.FuckGoodsContract
import com.wqfhr.www.funnyboxa.ui.fragment.AndroidFragment
import com.wqfhr.www.funnyboxa.ui.fragment.GirlFragment
import com.wqfhr.www.funnyboxa.ui.fragment.IOSFragment
import rx.Observable
import javax.inject.Inject

/**
 * Created by wing on 16-11-24.
 */
class FuckGoodsModel
@Inject constructor(private val api: GankApi) : FuckGoodsContract.Model {

  override fun getData(page: Int, type: String): Observable<JsonResult<List<FuckGoods>>> {
    when (type) {
      AndroidFragment.ANDROID -> return api.getAndroidData(page)
      IOSFragment.IOS -> return api.getiOSData(page)
      GirlFragment.GIRL -> return api.getGirlData(page)
      else -> return api.getAndroidData(page)
    }
  }
}
