package kg.bishkoteka.ui.fragments.main.details

import android.util.Log
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import dagger.hilt.android.AndroidEntryPoint
import kg.bishkoteka.R
import kg.bishkoteka.core.base.BaseBottomSheetDialogFragment
import kg.bishkoteka.core.base.BaseFragment
import kg.bishkoteka.core.extensions.addChip
import kg.bishkoteka.core.extensions.toDate
import kg.bishkoteka.data.remote.dto.events.CategoryModel
import kg.bishkoteka.databinding.FragmentDetailEventBinding
import kg.bishkoteka.ui.fragments.main.adapters.CategoryAdapter
import kg.bishkoteka.ui.fragments.main.all.FilteredEventsFragment.Companion.KEY_DETAIL_EVENT_FILTERED

import kg.bishkoteka.ui.fragments.main.home.HomeFragment.Companion.KEY_DETAIL_EVENT_HOME

@AndroidEntryPoint
class DetailEventFragment :
    BaseFragment<FragmentDetailEventBinding, DetailEventViewModel>(R.layout.fragment_detail_event) {
    override val binding: FragmentDetailEventBinding by viewBinding(FragmentDetailEventBinding::bind)
    override val viewModel by viewModels<DetailEventViewModel>()
//    private val categoryAdapter by lazy { CategoryAdapter(this::onCategoryClick) }

    private var eventId: Int = -1

    override fun initRequest() {
        super.initRequest()
        Log.e("initRequest", "Success")
        getEventById()
    }

    override fun initSubscribers() {
        super.initSubscribers()
        Log.e("initSubscribers", "Success")
        collectEventById()
    }

    private fun getEventById() {
        viewModel.getEventById(eventId)
        Log.e("getEventById", viewModel.getEventById(eventId).toString())
    }

    private fun collectEventById() {

//        val testCategoryData = arrayListOf<CategoryModel>()
//        testCategoryData.add(CategoryModel(1, "Концерты"))
//        testCategoryData.add(CategoryModel(2, "Фестивали"))
//        testCategoryData.add(CategoryModel(3, "Тусовки"))
//        testCategoryData.add(CategoryModel(4, "Вечеринки"))
//        testCategoryData.add(CategoryModel(5, "Развлечения"))
//        binding.tags.apply {
//            if (testCategoryData.isNullOrEmpty()){
//                binding.tags.visibility = View.GONE
//                Log.e("Chips1", "visibility - gone")
//            }else {
////                        removeAllViews()
//                if (testCategoryData.size > 2) {
//                    testCategoryData.subList(0, 2).forEach { tag -> addChip(tag.title) }
//                    addChip("+${testCategoryData.size - 2}")
//                    Log.e("Chips2", testCategoryData.toString())
//                } else {
//                    testCategoryData.forEach { tag -> addChip(tag.title) }
//                    Log.e("Chips3", testCategoryData.toString())
//                }
//            }
//        }

        viewModel.getEventByIdState.collectUIState { model ->
            with(binding) {
                Log.e("collectEventById", "Success")
                Log.e("collectEventById", model.toString())
                eventId = model.id
                tvTitle.text = model.title
                tvOrganizationName.text = model.organization
                tvEntryPrice.text = model.entry + " · " + model.price
                tvEventAddress.text = model.location
                tvEventStartTime.text = model.start_time.toDate()
                tvDescription.text = model.description
                Log.e("Model chips", model.categories.toString())
//                tags.apply {
//                    if (model.categories.isNullOrEmpty()){
//                        tags.visibility = View.GONE
//                    }else {
//                        removeAllViews()
//
//                        if (model.categories.size > 2) {
//                            model.categories.subList(0, 2).forEach { tag -> addChip(tag.title) }
//                            addChip("+${model.categories.size - 2}")
//                        } else {
//                            model.categories.forEach { tag -> addChip(tag.title) }
//                        }
//                    }
//                }
            }
        }
    }

    override fun initialize() {
        super.initialize()
        initId()
    }
    private fun initId() {
        checkId(KEY_DETAIL_EVENT_HOME)
//        checkSlug(KEY_DETAIL_TOUR_BY_WORD)
//        checkId(KEY_DETAIL_EVENT_FILTERED)
//        checkSlug(KEY_DETAIL_TOUR_FAVORITE)
    }
    private fun checkId(key: String) {
        if (arguments?.getInt(key) != null) {
            eventId = arguments?.getInt(key)!!
            Log.e("checkId", "Success")
            Log.e("checkId", eventId.toString())
        }
    }

}