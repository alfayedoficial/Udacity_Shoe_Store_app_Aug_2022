package com.alfayedoficial.shoestoreapp.core.common.fragment

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.alfayedoficial.kotlinutils.KUPreferences
import com.alfayedoficial.kotlinutils.kuRes
import com.alfayedoficial.kotlinutils.kuSnackBarError
import javax.inject.Inject

/**
 * Created by ( Eng Ali Al Fayed)
 * Class do :
 * Date 9/13/2021 - 12:48 AM
 */
abstract class BaseFragment<T> : Fragment() where T: ViewDataBinding {

    @Inject
    protected lateinit var  appPreferences: KUPreferences

    @get:LayoutRes
    protected abstract val layoutResourceLayout : Int

    private var _navController: NavController? = null
    protected val navController: NavController
        get() = _navController!!

    private var _dataBinder: T? = null //  reference to the data binding object associated with this view. onDestroy() will be called when the view is destroyed. after onDestroy() is called, the reference will be set to null.
    protected val dataBinder: T
        get() = _dataBinder!!

    private var _rootView: View? = null
    protected val rootView: View
        get() = _rootView!!


    abstract fun onFragmentCreated(dataBinder : T)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        this@BaseFragment.layoutResourceLayout.let {
            _dataBinder = DataBindingUtil.inflate(inflater, it, container, false)
            this@BaseFragment.onFragmentCreated(dataBinder)
            _rootView = dataBinder.root
            setUpViewModelStateObservers()

            return rootView
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _navController = findNavController()
    }

    abstract fun setUpViewModelStateObservers()


    protected fun backFragment(){
        navController.popBackStack()
    }

    override fun onResume() {
        super.onResume()
    }


    override fun onDestroy() {
        _dataBinder?.unbind()
        _dataBinder = null
        _rootView = null
        _navController = null
        super.onDestroy()
    }

    fun snackBarError(msg:String , bgColor : Int , tvColor : Int){
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M){
            kuSnackBarError(msg, kuRes.getColor(bgColor ,requireContext().theme), kuRes.getColor(tvColor ,requireContext().theme))
        }else{
            kuSnackBarError(msg, kuRes.getColor(bgColor), kuRes.getColor(tvColor))
        }

    }

}
