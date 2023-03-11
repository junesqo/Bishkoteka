package kg.bishkoteka.ui.fragments.main

import androidx.navigation.NavController
import androidx.navigation.ui.NavigationUI.setupWithNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import kg.bishkoteka.R
import kg.bishkoteka.core.base.BaseFlowFragment
import kg.bishkoteka.databinding.FragmentMainFlowBinding

class MainFlowFragment :
    BaseFlowFragment(R.layout.fragment_main_flow, R.id.nav_host_fragment_main) {

    private val binding by viewBinding(FragmentMainFlowBinding::bind)

    override fun setupNavigation(navController: NavController) {
        constructBottomNavigation(navController)
    }

    private fun constructBottomNavigation(navController: NavController) {
        setupWithNavController(binding.bottomNavigation, navController)
    }
}