package kg.bishkoteka.ui.fragments.main.event.event_details

import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kg.bishkoteka.R
import kg.bishkoteka.core.base.BaseFragment
import kg.bishkoteka.core.extensions.addChip
import kg.bishkoteka.core.extensions.toDate
import kg.bishkoteka.databinding.FragmentEventDetailsBinding
import kg.bishkoteka.ui.fragments.main.all.FilteredEventsFragment.Companion.KEY_DETAIL_EVENT_FILTERED

import kg.bishkoteka.ui.fragments.main.home.HomeFragment.Companion.KEY_DETAIL_EVENT_HOME

@AndroidEntryPoint
class EventDetailsFragment :
    BaseFragment<FragmentEventDetailsBinding, EventDetailsViewModel>(R.layout.fragment_event_details) {
    override val binding: FragmentEventDetailsBinding by viewBinding(FragmentEventDetailsBinding::bind)
    override val viewModel by viewModels<EventDetailsViewModel>()
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

        viewModel.getEventByIdState.collectUIState { model ->
            with(binding) {
                Log.e("collectEventById", "Success")
                Log.e("collectEventById", model.toString())
                eventId = model.id
                tvTitle.text = model.title
                tvOrganizationName.text = model.organization
                tvEventAddress.text = model.location
                tvEventStartTime.text = model.start_time.toDate()
                tvDescription.text = model.description
                Log.e("Model chips", model.categories.toString())
                tags.apply {
                    removeAllViews()
                    addChip("Вход " + model.entry + " сом")
                    if (model.price == 0) {
                        addChip("Бесплатно")
                    } else {
                        addChip("от " + model.price.toString())
                    }
                    if (model.categories.isNullOrEmpty()){} else {
                        model.categories.forEach { tag -> addChip(tag.title)}
                    }

                }
//                tags.apply {
//                    if (model.categories.isNullOrEmpty()){
//                        tags.visibility = View.GONE
//                    }else {
//                        removeAllViews()
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
        checkId(KEY_DETAIL_EVENT_FILTERED)
//        checkSlug(KEY_DETAIL_TOUR_BY_WORD)
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