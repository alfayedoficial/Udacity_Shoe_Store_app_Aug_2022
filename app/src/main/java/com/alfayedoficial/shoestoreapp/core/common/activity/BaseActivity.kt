package com.alfayedoficial.shoestoreapp.core.common.activity

import android.content.Context
import android.content.res.Configuration
import android.os.Build
import android.os.Bundle
import android.os.PersistableBundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.navigation.NavController
import androidx.navigation.ui.AppBarConfiguration
import com.alfayedoficial.kotlinutils.KUConstants.KU_LOCALE
import com.alfayedoficial.kotlinutils.KUPreferences
import com.alfayedoficial.kotlinutils.kuRes
import com.alfayedoficial.kotlinutils.kuSnackBarError
import java.util.*
import javax.inject.Inject

/**
 * Created by ( Eng Ali Al Fayed)
 * Class do :
 * Date 9/7/2021 - 9:25 PM
 */
abstract class BaseActivity<T> : AppCompatActivity() where T : ViewDataBinding {

    @Inject
    protected lateinit var  appPreferences: KUPreferences

    @get:LayoutRes
    protected abstract val layoutResourceId : Int
    private var _dataBinder: T? = null
    protected val dataBinder: T
        get() = _dataBinder!!
    lateinit var appBarConfiguration: AppBarConfiguration
    lateinit var navController: NavController

    abstract fun onActivityCreated(dataBinder : T)

    final override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        this@BaseActivity.initial()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this@BaseActivity.initial()
        setUpViewModelStateObservers()
    }

    private fun initial(){
        this@BaseActivity.layoutResourceId.let {
            val dataBinder = DataBindingUtil.setContentView<T>(this@BaseActivity , it)
            this._dataBinder = dataBinder
            this@BaseActivity.onActivityCreated(dataBinder)
        }
    }

    override fun onBackPressed() {
        val fm = supportFragmentManager
        if (fm.backStackEntryCount > 1) {
            fm.popBackStack()
        } else {
            super.onBackPressed()
        }
    }

    open fun setUpViewModelStateObservers(){}

    fun snackBarError(msg:String , bgColor : Int , tvColor : Int){
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M){
            kuSnackBarError(msg, kuRes.getColor(bgColor ,theme), kuRes.getColor(tvColor ,theme))
        }else{
            kuSnackBarError(msg, kuRes.getColor(bgColor), kuRes.getColor(tvColor))
        }
    }


    override fun onDestroy() {
        _dataBinder?.unbind()
        _dataBinder = null
        super.onDestroy()
    }


}