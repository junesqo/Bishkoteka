package kg.bishkoteka.ui.fragments.main.organization.create_organization

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kg.bishkoteka.R
import kg.bishkoteka.core.base.BaseFragment
import kg.bishkoteka.data.models.post.organization.OrganizationCreateRequest
import kg.bishkoteka.data.util.showToast
import kg.bishkoteka.databinding.FragmentOrganizationCreateBinding

@AndroidEntryPoint
class OrganizationCreateFragment :
    BaseFragment<FragmentOrganizationCreateBinding, OrganizationCreateViewModel>(R.layout.fragment_organization_create) {
    override val binding: FragmentOrganizationCreateBinding by viewBinding(
        FragmentOrganizationCreateBinding::bind
    )
    override val viewModel by viewModels<OrganizationCreateViewModel>()

    override fun initListeners() {
        super.initListeners()
        with(binding) {
            btnCreateOrganization.setOnClickListener {
                if (etOrganizationName.text.toString()
                        .isNotEmpty() && etOrganizationDescription.text.toString()
                        .isNotEmpty() && etOrganizationType.text.toString().isNotEmpty()
                ) {
                    viewModel.createOrganization(
                        OrganizationCreateRequest(
                            name = etOrganizationName.text.toString(),
                            type = etOrganizationType.text.toString(),
                            description = etOrganizationDescription.text.toString(),
                            address = etOrganizationAddress.text.toString(),
                            phone_number = etOrganizationPhoneNumber.text.toString(),
                            insta_link = etOrganizationInstagram.text.toString()
                        )
                    )
                    viewModel.createOrganization.collectUIState {
                        findNavController().navigateUp()
                    }
                } else if (etOrganizationName.text.toString().isEmpty()) {
                    requireContext().showToast("Поле названия не должно быть пустым")
                } else if (etOrganizationType.text.toString().isEmpty()) {
                    requireContext().showToast("Поле сферы деятельности не должно быть пустым")
                } else if (etOrganizationDescription.text.toString().isEmpty()) {
                    requireContext().showToast("Поле информации об организации не должно быть пустым")
                }
            }
        }
    }
}