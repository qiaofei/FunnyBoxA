package com.wqfhr.www.funnyboxa.ui.activity

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import com.wqfhr.www.funnyboxa.bean.FuckGoods
import com.wqfhr.www.funnyboxa.di.component.RandomModule
import com.wqfhr.www.funnyboxa.getMainComponent
import com.wqfhr.www.funnyboxa.mvp.contract.RandomContract
import com.wqfhr.www.funnyboxa.mvp.presenter.RandomPresenter
import com.wqfhr.www.funnyboxa.router.GankClientUri
import com.wqfhr.www.funnyboxa.router.GankRouter
import com.wqfhr.www.funnyboxa.toast
import com.wqfhr.www.funnyboxa.ui.fragment.IOSFragment
import com.wqfhr.www.funnyboxa.R
import com.wqfhr.www.funnyboxa.databinding.ActivityMainBinding
import com.wqfhr.www.funnyboxa.ui.fragment.AndroidFragment
import kotlinx.android.synthetic.main.activity_main.*
import java.net.URLEncoder
import java.util.*
import javax.inject.Inject

class MainActivity : BaseBindingActivity<ActivityMainBinding>(), RandomContract.View {


  lateinit var mFragments: MutableList<Fragment>
  @Inject lateinit var mPresenter : RandomPresenter
  override fun createDataBinding(savedInstanceState: Bundle?): ActivityMainBinding {
    return DataBindingUtil.setContentView(this, R.layout.activity_main)
  }

  override fun initView() {
    initFragments()
    getMainComponent().plus(RandomModule(this)).inject(this)
    viewPager.adapter = object : FragmentPagerAdapter(supportFragmentManager) {
      override fun getItem(position: Int) = mFragments[position]
      override fun getCount() = mFragments.size
    }

    viewPager.offscreenPageLimit = 4

    navigationView.setOnNavigationItemSelectedListener { item ->
      var tab = 0
      when (item.itemId) {
        R.id.menu_android -> tab = 0
        R.id.menu_ios -> tab = 1
/*        R.id.menu_girl -> tab = 2
        R.id.menu_about -> tab = 3*/
      }
      viewPager.currentItem = tab
      false
    }


    floatingButton.setOnClickListener {
      mPresenter.getRandom("Android")
    }

  }
  override fun onRandom(goods : FuckGoods) {

    val url = URLEncoder.encode(goods.url)
    toast("手气不错～")
    GankRouter.router(this, GankClientUri.DETAIL + url)
  }
  private fun initFragments() {
    mFragments = ArrayList()
    mFragments.add(AndroidFragment.newInstance())
    mFragments.add(IOSFragment.newInstance())
//    mFragments.add(GirlFragment.newInstance())
//    mFragments.add(FragmentHolder())
  }

}
