package com.wqfhr.www.funnyboxa.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.airbnb.deeplinkdispatch.DeepLink
import com.wqfhr.www.funnyboxa.router.GankClientUri
import com.wqfhr.www.funnyboxa.R

@DeepLink(GankClientUri.ABOUT)
class AboutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

    }
}
