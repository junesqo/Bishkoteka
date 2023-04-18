package kg.bishkoteka.ui.fragments.main.home

import android.graphics.Color
import android.util.Log
import android.view.View
import android.view.WindowManager
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kg.bishkoteka.R
import kg.bishkoteka.core.base.BaseFragment
import kg.bishkoteka.data.models.get.events.CategoryResponse
import kg.bishkoteka.data.models.post.events.OnetimeEventFilter
import kg.bishkoteka.databinding.FragmentHomeBinding
import kg.bishkoteka.ui.fragments.main.adapters.CategoryAdapter
import kg.bishkoteka.ui.fragments.main.adapters.OnetimeEventAdapter
import kg.bishkoteka.ui.fragments.main.adapters.RegularEventsAdapter

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(R.layout.fragment_home) {
    override val binding: FragmentHomeBinding by viewBinding(FragmentHomeBinding::bind)
    override val viewModel by viewModels<HomeViewModel>()
    private val onetimeFilter by lazy { OnetimeEventFilter() }
    private val onetimeEventAdapter by lazy { OnetimeEventAdapter(this::onEventClick) }
    private val regularEventAdapter by lazy { RegularEventsAdapter(this::onEventClick) }
    private val categoryAdapter by lazy { CategoryAdapter(this::onCategoryClick) }
    private val categoriesList = arrayListOf<CategoryResponse>()

    override fun initialize() {
        super.initialize()
        initAdapters()
        transparentStatusBar()
    }

    override fun initRequest() {
        super.initRequest()
        getCategories()
        getOnetimeEvents()
        getRegularEvents()
    }

    private fun initAdapters() {
        with(binding) {
            rvEvents.adapter = onetimeEventAdapter
            rvCategories.adapter = categoryAdapter
            rvRegularEvents.adapter = regularEventAdapter
        }
    }

    private fun getRegularEvents() {
        viewModel.getRegularEvents()
        viewModel.getPagingRegularEvent.spectatePaging { regularEventAdapter.submitData(it) }
    }

    private fun getOnetimeEvents() {
        viewModel.getOnetimeEvents()
        viewModel.getPagingOnetimeEvent.spectatePaging { onetimeEventAdapter.submitData(it)}
    }

    private fun getCategories() {
        viewModel.getCategories()
        viewModel.getCategoriesState.collectUIState {
            categoriesList.clear()
            categoriesList.addAll(it)
            categoryAdapter.addData(categoriesList)
            binding.content.visibility = View.VISIBLE
            binding.progressBar.progressBar.visibility = View.GONE
        }
    }

    private fun onEventClick(id: Int) {
//        DetailEventFragment().show(parentFragmentManager, "tag")
        Log.e("onEventClick", id.toString())
        findNavController().navigate(
            R.id.detailsFragment, bundleOf(KEY_DETAIL_EVENT_HOME to id)
        )
//        findNavController().navigate(
//            R.id.action_homeFragment_to_detailsFragment, bundleOf(KEY_DETAIL_EVENT_HOME to id)
//        )
    }

    private fun onCategoryClick(categoryId: Int) {
        Log.e("Filter1", categoryId.toString())
        onetimeFilter.category = categoryId.toString()
//        findNavController().navigateSafelyWithArgs(R.id.action_homeFragment_to_filteredEventsFragment, categoryId)
        findNavController().navigate(
            R.id.filteredEventsFragment,
            bundleOf(KEY_CATEGORY_HOME to onetimeFilter)
        )
    }

    private fun transparentStatusBar() {

        val fragment = activity?.findViewById<View>(R.id.mainFlowFragment)
        val statusBarBgColor = fragment?.background ?: Color.WHITE
        activity?.window?.apply {
            clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)

            statusBarColor = statusBarBgColor as Int
            decorView.systemUiVisibility =
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }
    }

    companion object {
        const val KEY_CATEGORY_HOME = "key.category.home"
        const val KEY_FILTER = "key.filter"
        const val KEY_DETAIL_EVENT_HOME = "key.detail.event.home"
    }

}