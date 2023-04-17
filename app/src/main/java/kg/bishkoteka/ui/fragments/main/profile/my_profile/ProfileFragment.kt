package kg.bishkoteka.ui.fragments.main.profile.my_profile

import android.util.Log
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import kg.bishkoteka.core.base.BaseFragment
import kg.bishkoteka.data.local.preferences.UserPreferences
import dagger.hilt.android.AndroidEntryPoint
import kg.bishkoteka.R
import kg.bishkoteka.core.extensions.activityNavController
import kg.bishkoteka.core.extensions.navigateSafely
import kg.bishkoteka.databinding.FragmentProfileBinding
import kg.bishkoteka.ui.fragments.main.profile.ProfileViewModel
import javax.inject.Inject

@AndroidEntryPoint
class ProfileFragment :
    BaseFragment<FragmentProfileBinding, ProfileViewModel>(R.layout.fragment_profile) {
    override val binding by viewBinding(FragmentProfileBinding::bind)
    override val viewModel by viewModels<ProfileViewModel>()

    @Inject
    lateinit var userPreferences: UserPreferences

    override fun initListeners() {
        binding.btnEditProfile.setOnClickListener {
            findNavController().navigateSafely(R.id.action_profileFragment_to_profileEditFragment)
        }
        binding.btnMyOrganizations.setOnClickListener {
            findNavController().navigateSafely(R.id.action_profileFragment_to_myOrganizationsFragment)
        }
        binding.btnLogOut.setOnClickListener {
            userPreferences.clearPreferences()
            userPreferences.isAuthenticated = false
            requireActivity().recreate()
//            activityNavController().navigateSafely(R.id.action_mainFlowFragment_to_authenticationFlowFragment)
        }
        binding.btnSignInOrUp.setOnClickListener {
            activityNavController().navigateSafely(R.id.action_mainFlowFragment_to_authenticationFlowFragment)
        }
    }

    override fun initialize() {
        checkAuth()
//        binding.tvUsername.text = userPreferences.username
//        binding.tvEmail.text = userPreferences.userEmail
        Log.e("prefs", userPreferences.username.toString())
    }

    private fun checkAuth() {
        when {
            userPreferences.isAuthenticated -> {
                binding.signContainer.isVisible = false
                binding.tvUsername.isVisible = true
                binding.tvUsername.text = userPreferences.username
                binding.tvEmail.text = userPreferences.userEmail
            }
            !userPreferences.isAuthenticated -> {
                binding.tvUsername.isVisible = false
                binding.signContainer.isVisible = true
                binding.personalContainer.isVisible = false
                binding.btnLogOut.isVisible = false
            }
        }
    }

    override fun initRequest() {
        super.initRequest()
        getMyProfile()
    }

    private fun getMyProfile() {
        viewModel.getMyProfile()
        viewModel.getMyProfileState.collectUIState { response ->
            binding.tvUsername.text = response.username
            binding.tvName.text = response.first_name + " " + response.last_name
            binding.tvFollowers.text = response.following_count.toString()
            binding.tvEmail.text = response.email
            Log.e("My profile", response.toString())
        }
    }

//    override fun initialize() {
//        super.initialize()
//        setupViewPager()
//        setupTabLayout()
//    }

//    private fun setupTabLayout() {
//        TabLayoutMediator(
//            binding.tabLayout, binding.viewPager
//        ) { tab, position -> when(position) {
//            0 -> tab.text = "Детали"
//            1 -> tab.text = "Мероприятия"
//        }
//
//        }.attach()
//    }
//
//    private fun setupViewPager() {
//        val adapter = ViewPagerAdapter(requireActivity(), 2)
//        binding.viewPager.adapter = adapter
//    }
}
