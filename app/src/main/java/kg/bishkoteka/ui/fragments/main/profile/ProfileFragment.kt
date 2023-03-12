package kg.bishkoteka.ui.fragments.main.profile

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import kg.bishkoteka.core.base.BaseFragment
import kg.bishkoteka.data.local.preferences.UserPreferences
import dagger.hilt.android.AndroidEntryPoint
import kg.bishkoteka.R
import kg.bishkoteka.core.extensions.activityNavController
import kg.bishkoteka.core.extensions.navigateSafely
import kg.bishkoteka.databinding.FragmentProfileBinding
import javax.inject.Inject

@AndroidEntryPoint
class ProfileFragment :
    BaseFragment<FragmentProfileBinding, ProfileViewModel>(R.layout.fragment_profile) {
    override val binding by viewBinding(FragmentProfileBinding::bind)
    override val viewModel by viewModels<ProfileViewModel>()

    @Inject
    lateinit var userPreferences: UserPreferences

    override fun initListeners() {
        binding.btnLogOut.setOnClickListener {
            userPreferences.accessToken = ""
            userPreferences.refreshToken = ""
            userPreferences.isAuthenticated = false
            activityNavController().navigateSafely(R.id.action_mainFlowFragment_to_authenticationFlowFragment)
        }
    }
}
