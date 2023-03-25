package kg.bishkoteka.core.base

import android.os.Bundle
import android.view.View
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment

abstract class BaseFlowFragment(
    @LayoutRes layoutId: Int,
    @IdRes private val navHostFragmentId: Int
) : androidx.fragment.app.Fragment(layoutId) {

    final override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navHostFragment =
            childFragmentManager.findFragmentById(navHostFragmentId) as NavHostFragment
        val navController = navHostFragment.navController

        setupNavigation(navController)
        defineActionBar()
    }

    protected open fun setupNavigation(navController: NavController) {
    }

    protected open fun setupStatusBar() {

    }

    protected  open fun defineActionBar(){

    }
}