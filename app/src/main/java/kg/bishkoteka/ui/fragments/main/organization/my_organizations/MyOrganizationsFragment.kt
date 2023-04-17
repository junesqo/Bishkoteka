package kg.bishkoteka.ui.fragments.main.organization.my_organizations

import android.util.Log
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kg.bishkoteka.R
import kg.bishkoteka.core.base.BaseFragment
import kg.bishkoteka.core.extensions.navigateSafely
import kg.bishkoteka.data.models.get.organization.OrganizationResponse
import kg.bishkoteka.databinding.FragmentMyOrganizationsBinding
import kg.bishkoteka.ui.fragments.main.adapters.OrganizationAdapter

@AndroidEntryPoint
class MyOrganizationsFragment :
    BaseFragment<FragmentMyOrganizationsBinding, MyOrganizationsViewModel>(R.layout.fragment_my_organizations) {
    override val binding: FragmentMyOrganizationsBinding by viewBinding(
        FragmentMyOrganizationsBinding::bind
    )
    override val viewModel by viewModels<MyOrganizationsViewModel>()
    private val organizationAdapter by lazy { OrganizationAdapter(this::onOrganizationClick) }
    private val myOrganizationsList = arrayListOf<OrganizationResponse>()

    override fun initialize() {
        super.initialize()
        initAdapters()
    }

    override fun initListeners() {
        super.initListeners()
        binding.btnCreateOrganization.setOnClickListener {
            findNavController().navigateSafely(R.id.action_myOrganizationsFragment_to_createOrganizationFragment)
        }

    }

    override fun initRequest() {
        super.initRequest()
        getMyOrganizations()
    }

    private fun getMyOrganizations() {
        viewModel.getMyOrganizations()
        viewModel.getMyOrganizationsState.collectUIState { response ->
            myOrganizationsList.clear()
            myOrganizationsList.addAll(response)
            organizationAdapter.addData(myOrganizationsList)
            Log.e("View model List size", response.size.toString())
            Log.e("Fragment List size", myOrganizationsList.size.toString())
        }
    }

    private fun initAdapters() {
        with(binding) {
            rvMyOrganizations.adapter = organizationAdapter
        }
    }

    private fun onOrganizationClick(organizationId: Int) {
        findNavController().navigate(
            R.id.organizationDetailsFragment,
            bundleOf(KEY_MY_ORGANIZATION_DETAIL to organizationId)
        )
    }

    companion object {
        const val KEY_MY_ORGANIZATION_DETAIL = "key.my.organization.detail"
    }
}