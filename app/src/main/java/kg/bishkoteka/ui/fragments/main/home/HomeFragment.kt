package kg.bishkoteka.ui.fragments.main.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.paging.PagingData
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kg.bishkoteka.R
import kg.bishkoteka.core.base.BaseFragment
import kg.bishkoteka.core.extensions.navigateSafely
import kg.bishkoteka.core.extensions.navigateSafelyWithArgs
import kg.bishkoteka.databinding.FragmentHomeBinding
import kg.bishkoteka.ui.fragments.main.adapters.EventsAdapter

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(R.layout.fragment_home) {
    override val binding: FragmentHomeBinding by viewBinding(FragmentHomeBinding::bind)
    override val viewModel by viewModels<HomeViewModel>()
    private val eventsAdapter = EventsAdapter(this::onItemClick)
    override fun initialize() {
        super.initialize()
        binding.rvEvents.adapter = eventsAdapter
    }

    override fun initSubscribers() {
        subscribeToEvents()
    }

    private fun onItemClick(eventId: Int) {
        findNavController().navigateSafelyWithArgs(R.id.action_homeFragment_to_detailsFragment, eventId)
    }

    private fun subscribeToEvents() = with(binding) {
        viewModel.events.spectateUiState(success = {
            safeFlowGather {
                eventsAdapter.submitData(PagingData.from(it))
            }
        }
//            gatherIfSucceed = {
//            btnRefresh.bindToUIStateNotLoading(it)
//            sflCountries.bindToUIStateLoading(it)
//        }, error = {
//            loge(it)
//        }
        )
    }
}