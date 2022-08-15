package com.alfayedoficial.shoestoreapp.ui.view

import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import com.alfayedoficial.shoestoreapp.R
import com.alfayedoficial.shoestoreapp.R.*
import com.alfayedoficial.shoestoreapp.core.common.activity.BaseActivity
import com.alfayedoficial.shoestoreapp.databinding.ActivityOneSingleBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OneSingleActivity : BaseActivity<ActivityOneSingleBinding>() {

    override val layoutResourceId: Int
        get() = R.layout.activity_one_single

    override fun onActivityCreated(dataBinder: ActivityOneSingleBinding) {
        dataBinder.apply {
            activity = this@OneSingleActivity
            lifecycleOwner = this@OneSingleActivity

            val navHostFragment = supportFragmentManager.findFragmentById(id.navLaunchGraph) as NavHostFragment
            navController = navHostFragment.navController

            appBarConfiguration = AppBarConfiguration(
                topLevelDestinationIds = setOf(
                    // set all your top level destinations in here
                    id.homeFragment,
                )
            )
        }
    }
}