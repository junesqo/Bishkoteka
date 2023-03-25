package kg.bishkoteka.ui.fragments.main.home

import android.graphics.Color
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kg.bishkoteka.R
import kg.bishkoteka.core.base.BaseFragment
import kg.bishkoteka.data.remote.dto.events.CategoryModel
import kg.bishkoteka.databinding.FragmentHomeBinding
import kg.bishkoteka.ui.fragments.main.adapters.CategoryAdapter
import kg.bishkoteka.ui.fragments.main.adapters.EventAdapter

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(R.layout.fragment_home) {
    override val binding: FragmentHomeBinding by viewBinding(FragmentHomeBinding::bind)
    override val viewModel by viewModels<HomeViewModel>()
    private val eventAdapter by lazy { EventAdapter(this::onTourClick) }
    private val categoryAdapter by lazy { CategoryAdapter(this::onCategoryClick) }

    private val categoriesList = arrayListOf<CategoryModel>()

    override fun initialize() {
        super.initialize()
        initAdapters()
        transparentStatusBar()
    }


    override fun initRequest() {
        super.initRequest()
        getCategories()
    }

    private fun getCategories() {
        viewModel.getCategories()
    }

    private fun getCategoriesState() {
        viewModel.getCategoriesState.collectUIState {
            categoriesList.addAll(it)
            Log.e("Categories", it.toString())
            categoryAdapter.addData(categoriesList)
        }
    }

    override fun initSubscribers() {
        super.initSubscribers()
        subscribeDefaultEvents()
        getCategoriesState()
    }

    private fun subscribeDefaultEvents() {
        viewModel.getDefaultEvents().spectatePaging { eventAdapter.submitData(it) }
    }

    private fun initAdapters() {
        with(binding) {
            rvEvents.adapter = eventAdapter
            rvCategories.adapter = categoryAdapter
        }
    }

    private fun onTourClick(id: Int) {
//        findNavController().navigate(
//            R.id.detailTourFragment, bundleOf(KEY_DETAIL_TOUR_HOME to slug)
//        )
    }

    private fun onCategoryClick(id: Int) {
        Toast.makeText(requireContext(), id, Toast.LENGTH_SHORT).show()
//        findNavController().navigate(
//            R.id.detailsFragment,
//            bundleOf(KEY_DETAIL_TOUR_BY_WORD to tourSlug)
//        )
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
        const val KEY_DETAIL_TOUR_HOME = "key.detail.tour.home"
    }

}