package kg.bishkoteka.ui.fragments.main.organization.organization_details

import android.util.Log
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import kg.bishkoteka.R
import kg.bishkoteka.core.base.BaseFragment
import kg.bishkoteka.core.extensions.addChip
import kg.bishkoteka.core.extensions.navigateSafely
import kg.bishkoteka.core.extensions.toDate
import kg.bishkoteka.databinding.FragmentOrganizationDetailsBinding
import kg.bishkoteka.ui.fragments.main.adapters.FilteredEventsAdapter
import kg.bishkoteka.ui.fragments.main.adapters.ViewPagerAdapter
import kg.bishkoteka.ui.fragments.main.all.FilteredEventsFragment
import kg.bishkoteka.ui.fragments.main.home.HomeFragment
import kg.bishkoteka.ui.fragments.main.organization.my_organizations.MyOrganizationsFragment.Companion.KEY_MY_ORGANIZATION_DETAIL

@AndroidEntryPoint
class OrganizationDetailsFragment :
    BaseFragment<FragmentOrganizationDetailsBinding, OrganizationDetailsViewModel>(R.layout.fragment_organization_details) {
    override val binding: FragmentOrganizationDetailsBinding by viewBinding(
        FragmentOrganizationDetailsBinding::bind
    )
    override val viewModel by viewModels<OrganizationDetailsViewModel>()
    private var organizationId: Int = -1
    private val eventsAdapter by lazy { FilteredEventsAdapter(this::onEventClick) }

    private fun onEventClick(id: Int) {
//        TODO("Сделать PATCH запрос чтобы менять ивент")
        findNavController().navigate(
            R.id.detailsFragment, bundleOf(FilteredEventsFragment.KEY_DETAIL_EVENT_FILTERED to id)
        )
    }

    override fun initListeners() {
        super.initListeners()
        binding.btnCreateEvent.setOnClickListener {
            findNavController().navigate(
                R.id.createEventFragment,
                bundleOf(KEY_ORGANIZATION_DETAIL to organizationId)
            )
        }
    }

    override fun initRequest() {
        super.initRequest()
        getMyOrganizationById()
    }

    override fun initSubscribers() {
        super.initSubscribers()
        Log.e("initSubscribers", "Success")
        collectOrganizationById()
    }

    private fun collectOrganizationById() {
        viewModel.getMyOrganizationByIdState.collectUIState { model ->
            with(binding) {
                tvOrganizationName.text = model.name
                tvOrganizationType.text = model.type
                tvOrganizationDescription.text = model.description
                tvOrganizationInstagram.text = model.insta_link
                tvOrganizationPhone.text = model.phone_number
                tvOrganizationLocation.text = model.address
                eventsAdapter.apply { model.events }
                }
            }
    }

    private fun getMyOrganizationById() {
        viewModel.getMyOrganizationById(organizationId)
        Log.e("getOrganizationById", viewModel.getMyOrganizationById(organizationId).toString())
    }

    override fun initialize() {
        super.initialize()
        initId()
        initAdapter()
    }

    private fun initAdapter(){
        binding.rvEvents.adapter = eventsAdapter
    }

    private fun initId() {
        checkId(KEY_MY_ORGANIZATION_DETAIL)
    }

    private fun checkId(key: String) {
        if (arguments?.getInt(key) != null) {
            organizationId = arguments?.getInt(key)!!
            Log.e("checkId", "Success")
            Log.e("checkId", organizationId.toString())
        }
    }

    companion object {
        const val KEY_ORGANIZATION_DETAIL = "key.organization.detail"
    }

}