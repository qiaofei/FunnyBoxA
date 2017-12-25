package com.wqfhr.www.funnyboxa.ui.fragment

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.wqfhr.www.funnyboxa.bean.FuckGoods
import com.wqfhr.www.funnyboxa.databinding.ViewRecyclerBinding
import com.wqfhr.www.funnyboxa.di.component.FuckGoodsModule
import com.wqfhr.www.funnyboxa.getMainComponent
import com.wqfhr.www.funnyboxa.mvp.contract.FuckGoodsContract
import com.wqfhr.www.funnyboxa.mvp.presenter.FuckGoodsPresenter
import com.wqfhr.www.funnyboxa.router.GankClientUri
import com.wqfhr.www.funnyboxa.router.GankRouter
import com.wqfhr.www.funnyboxa.ui.adapter.FuckGoodsAdapter
import java.net.URLEncoder
import java.util.*
import javax.inject.Inject

/**
 * Created by wing on 11/25/16.
 */
class IOSFragment : BaseBingingFragment<ViewRecyclerBinding>() ,FuckGoodsContract.View{

  private var mList = ArrayList<FuckGoods>()
  private lateinit var mAdapter: FuckGoodsAdapter
  private var mPage = 1
  @Inject lateinit var mPresenter: FuckGoodsPresenter

  override fun createDataBinding(inflater: LayoutInflater?, container: ViewGroup?,
      savedInstanceState: Bundle?): ViewRecyclerBinding {
    return ViewRecyclerBinding.inflate(inflater!!,container,false)
  }

  override fun initView() {
    mAdapter = FuckGoodsAdapter(mList)
    context.getMainComponent().plus(FuckGoodsModule(this)).inject(this)
    with(mBinding!!) {
      recyclerView.adapter = mAdapter
      recyclerView.layoutManager = LinearLayoutManager(context)
      recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
          super.onScrolled(recyclerView, dx, dy)
          if(!recyclerView?.canScrollVertically(1)!!){
            mPresenter.getData(++mPage, IOS)
          }
        }

        override fun onScrollStateChanged(recyclerView: RecyclerView?, newState: Int) {
          super.onScrollStateChanged(recyclerView, newState)
        }
      })

      mPresenter.getData(mPage, IOS)
    }

    mAdapter.setOnItemClickListener {
      pos ->
      val url = URLEncoder.encode(mList[pos].url)
      GankRouter.router(context, GankClientUri.DETAIL + url)
    }

  }

  override fun setData(results: List<FuckGoods>) {

    mList.addAll(results)
    mAdapter.notifyDataSetChanged()
  }


  override fun onDestroy() {
    super.onDestroy()
    mPresenter.unSubscribe()
  }

  companion object {
    val IOS = "iOS"
    fun newInstance(): IOSFragment {
      val fragment = IOSFragment()
      val bundle = Bundle()
      fragment.arguments = bundle
      return fragment
    }
  }
}