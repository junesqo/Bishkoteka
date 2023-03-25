package kg.bishkoteka.ui.fragments.main.home

import android.graphics.Color
import android.view.View
import android.view.WindowManager
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint
import kg.bishkoteka.R
import kg.bishkoteka.core.base.BaseFragment
import kg.bishkoteka.databinding.FragmentHomeBinding
import kg.bishkoteka.ui.fragments.main.adapters.EventsAdapter

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(R.layout.fragment_home) {
    override val binding: FragmentHomeBinding by viewBinding(FragmentHomeBinding::bind)
    override val viewModel by viewModels<HomeViewModel>()
    private val eventsAdapter by lazy { EventsAdapter(this::onTourClick) }


    override fun initialize() {
        super.initialize()
        initAdapters()
        transparentStatusBar()
    }

    override fun initRequest() {
        super.initRequest()
//        getHotTours()
    }

    override fun initSubscribers() {
        super.initSubscribers()
        subscribeCategoryTours()
//        subscribeHotTours()
    }

    override fun initListeners() {
        super.initListeners()
//        onHotTourClick()
    }

    private fun subscribeCategoryTours() {
        viewModel.getConcertEvents().spectatePaging { eventsAdapter.submitData(it) }
    }

//    private fun subscribeHotTours() {
//        viewModel.getToursState.collectUIState { response ->
//
//            // тестовые данные
//            val testData = arrayListOf<ShortTourModel>()
//            testData.add(response.results[0])
//            testData.add(response.results[1])
//            testData.add(response.results[3])
//            animate(testData)
//
//            // должно работать, если бек будет работать ;)
////            animate(response.results.filter { it.is_hot })
//        }
//    }

    private fun initAdapters() {
        with(binding) {
            rvEvents.adapter = eventsAdapter
//            inBike.rvCategory.adapter = horseAdapter
//            inBike.tvCategory.text = "Велотуры"
        }
    }

//    private fun animate(data: List<ShortTourModel>): Animation? {
//
//        val anim = AnimationUtils.loadAnimation(requireContext(), R.anim.hot_tour_anim)
//        anim.repeatCount = Animation.INFINITE
//
//        viewModel.animateHotTours(data)
//        viewModel.hotTourAnimation.collectUIState { hotTour ->
//            binding.ivHotTour.startAnimation(anim)
//            Glide.with(requireContext())
//                .load(hotTour.tour_images.getMainImage())
//                .transition(withCrossFade(1000))
//                .into(binding.ivHotTour)
//        }
//        return anim
//    }

    private fun onTourClick(id: Int) {
//        findNavController().navigate(
//            R.id.detailTourFragment, bundleOf(KEY_DETAIL_TOUR_HOME to slug)
//        )
    }

//    private fun onHotTourClick(){
//        binding.cvHotTour.setOnClickListener {
//            viewModel.hotTourAnimation.collectUIState {
//                onTourClick(it.slug)
//            }
//        }
//    }

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