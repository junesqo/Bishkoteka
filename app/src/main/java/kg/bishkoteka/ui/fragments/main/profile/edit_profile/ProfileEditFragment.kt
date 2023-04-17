package kg.bishkoteka.ui.fragments.main.profile.edit_profile

import kg.bishkoteka.data.models.post.organization.OrganizationCreateRequest
import kg.bishkoteka.data.models.post.profile.ProfileEditRequest
import kg.bishkoteka.data.util.showToast
import kg.bishkoteka.databinding.FragmentProfileEditBinding
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
class ProfileEditFragment :
    BaseFragment<FragmentProfileEditBinding, ProfileViewModel>(R.layout.fragment_profile_edit) {
    override val binding by viewBinding(FragmentProfileEditBinding::bind)
    override val viewModel by viewModels<ProfileViewModel>()

    @Inject
    lateinit var userPreferences: UserPreferences

    override fun initListeners() {
        with(binding) {
            btnCancel.setOnClickListener {
                findNavController().navigateUp()
            }
            btnSave.setOnClickListener {
                if (etUsername.text.toString()
                        .isNotEmpty() && etFirstName.text.toString()
                        .isNotEmpty() && etLastName.text.toString().isNotEmpty()
                ) {
                    viewModel.editProfile(
                        ProfileEditRequest(
                            username = etUsername.text.toString(),
                            first_name = etFirstName.text.toString(),
                            last_name = etLastName.text.toString()
                        )
                    )
                    Log.e("my access token", userPreferences.accessToken.toString())
                    viewModel.editProfile.collectUIState {
                        findNavController().navigateUp()
                    }
                } else if (etUsername.text.toString().isEmpty()) {
                    requireContext().showToast("Введите username")
                } else if (etFirstName.text.toString().isEmpty()) {
                    requireContext().showToast("Введите имя")
                } else if (etLastName.text.toString().isEmpty()) {
                    requireContext().showToast("Введите фамилию")
                }
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
            binding.etUsername.setText(response.username)
            binding.etFirstName.setText(response.first_name)
            binding.etLastName.setText(response.last_name)
            Log.e("Edit Profile", response.toString())
        }
    }
}
