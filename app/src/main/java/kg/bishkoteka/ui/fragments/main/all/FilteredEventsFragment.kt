package kg.bishkoteka.ui.fragments.main.all

import android.util.Log
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kg.bishkoteka.R
import kg.bishkoteka.core.base.BaseFragment
import kg.bishkoteka.data.remote.dto.events.FilterModel
import kg.bishkoteka.databinding.FragmentFilteredEventsBinding
import kg.bishkoteka.ui.fragments.main.adapters.FilteredEventsAdapter
import kg.bishkoteka.ui.fragments.main.home.HomeFragment.Companion.KEY_CATEGORY_HOME
import kg.bishkoteka.ui.fragments.main.home.HomeFragment.Companion.KEY_FILTER

@Suppress("DEPRECATION")
@AndroidEntryPoint
class FilteredEventsFragment :
    BaseFragment<FragmentFilteredEventsBinding, FilteredEventsViewModel>(R.layout.fragment_filtered_events) {

    override val binding by viewBinding(FragmentFilteredEventsBinding::bind)
    override val viewModel by viewModels<FilteredEventsViewModel>()
        private val filter by lazy { arguments?.getSerializable(KEY_CATEGORY_HOME) as FilterModel }
//    private val categoryId: Int = requireArguments().getInt(KEY_CATEGORY_HOME, 0)
//    private val filterModel = FilterModel("", categoryId)
    private val filteredEventsAdapter by lazy { FilteredEventsAdapter(this::onEventClick) }

    override fun initialize() {
        super.initialize()
        initAdapter()

//        initCategory()
    }

    private fun initAdapter(){
        binding.rvEvents.adapter = filteredEventsAdapter
    }

    override fun initRequest() {
        super.initRequest()
        getEvents()
    }

    override fun initSubscribers() {
        super.initSubscribers()
        collectTours()
    }

    private fun collectTours() {
        viewModel.getPagingEvent.spectatePaging { filteredEventsAdapter.submitData(it) }
    }

    private fun getEvents() {

        viewModel.setFilter(filter)
        viewModel.getFilteredEvents()
    }

    private fun onEventClick(id: Int) {
        findNavController().navigate(
            R.id.detailsFragment, bundleOf(KEY_DETAIL_EVENT_FILTERED to id)
        )
    }

//    private fun initCategory() {
//        checkCategoryId(KEY_CATEGORY_HOME)
//    }

//    private fun checkCategoryId(key: String) {
//        if (arguments?.getInt(key) != null) {
//            categoryId = arguments?.getInt(key)!!
//            Log.e("checkId", "Success")
//
//        }
//    }

    companion object {
        const val KEY_DETAIL_EVENT_FILTERED = "key.detail.event.filtered"
    }
}