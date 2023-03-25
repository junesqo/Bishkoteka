package kg.bishkoteka.ui.fragments.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI.setupWithNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import kg.bishkoteka.R
import kg.bishkoteka.core.base.BaseFlowFragment
import kg.bishkoteka.core.extensions.setStatusBarColor
import kg.bishkoteka.databinding.FragmentMainFlowBinding

class MainFlowFragment :
    BaseFlowFragment(R.layout.fragment_main_flow, R.id.nav_host_fragment_main) {

    private val binding by viewBinding(FragmentMainFlowBinding::bind)

    private lateinit var navController: NavController


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        navController =
            (requireActivity() as AppCompatActivity).findNavController(R.id.nav_host_fragment_main)
//        setActionbar()
    }

    override fun setupNavigation(navController: NavController) {
        constructBottomNavigation(navController)
    }

    private fun constructBottomNavigation(navController: NavController) {
        setupWithNavController(binding.bottomNavigation, navController)
        binding.bottomNavigation.itemActiveIndicatorColor =
            ContextCompat.getColorStateList(requireContext(), R.color.white)
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.homeFragment -> {
                    navController.navigate(R.id.homeFragment)
                    true
                }
                R.id.searchFragment -> {
                    navController.navigate(R.id.searchFragment)
                    true
                }
                R.id.profileFragment -> {
                    navController.navigate(R.id.profileFragment)
                    true
                }
                else -> false
            }
        }
    }

    private val hideActionBarDestinations = setOf(
        R.id.detailsFragment,
        R.id.favoriteFragment,
        R.id.profileFragment,
    )

//    private fun setActionbar() {
//        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
//        navController.addOnDestinationChangedListener { _, destination, _ ->
//
//            if (destination.id == R.id.profileFragment)
//                setStatusBarColor(R.color.fragment_bg)
//
//            binding.toolbar.isVisible = hideActionBarDestinations.contains(destination.id)
//            binding.toolbar.navigationIcon =
//                when (hideActionBarDestinations.contains(destination.id)) {
//                    true -> ContextCompat.getDrawable(requireContext(), R.drawable.back)
//                    false -> null
//                }
//        }
//        binding.toolbar.setNavigationOnClickListener {
//            navController.navigateUp()
//        }
//    }
}