package kg.bishkoteka.ui.fragments.main.all

import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kg.bishkoteka.R
import kg.bishkoteka.core.base.BaseFragment
import kg.bishkoteka.data.models.post.events.OnetimeEventFilter
import kg.bishkoteka.databinding.FragmentFilteredEventsBinding
import kg.bishkoteka.ui.fragments.main.adapters.WideEventsAdapter
import kg.bishkoteka.ui.fragments.main.home.HomeFragment.Companion.KEY_CATEGORY_HOME

@Suppress("DEPRECATION")
@AndroidEntryPoint
class FilteredEventsFragment :
    BaseFragment<FragmentFilteredEventsBinding, FilteredEventsViewModel>(R.layout.fragment_filtered_events) {

    override val binding by viewBinding(FragmentFilteredEventsBinding::bind)
    override val viewModel by viewModels<FilteredEventsViewModel>()
        private val filter by lazy { arguments?.getSerializable(KEY_CATEGORY_HOME) as OnetimeEventFilter }
//    private val categoryId: Int = requireArguments().getInt(KEY_CATEGORY_HOME, 0)
//    private val filterModel = FilterModel("", categoryId)
    private val wideEventsAdapter by lazy { WideEventsAdapter(this::onEventClick) }

    override fun initialize() {
        super.initialize()
        initAdapter()
    }

    private fun initAdapter(){
        binding.rvEvents.adapter = wideEventsAdapter
    }

    override fun initRequest() {
        super.initRequest()
        getEvents()
    }

    override fun initSubscribers() {
        super.initSubscribers()
        collectEvents()
    }

    private fun collectEvents() {
        viewModel.getPagingOnetimeEvent.spectatePaging { wideEventsAdapter.submitData(it) }
    }

    private fun getEvents() {
        viewModel.setOnetimeFilter(filter)
        viewModel.getOnetimeEvents()
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