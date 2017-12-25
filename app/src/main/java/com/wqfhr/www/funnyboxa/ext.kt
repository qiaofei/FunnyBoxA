package com.wqfhr.www.funnyboxa

import android.content.Context
import android.widget.Toast

/**
 * Created by wing on 11/23/16.
 */
fun Context.getMainComponent() = App.instance.apiComponent

fun Context.toast(msg:String,length:Int = Toast.LENGTH_SHORT){
  Toast.makeText(this, msg, length).show()
}