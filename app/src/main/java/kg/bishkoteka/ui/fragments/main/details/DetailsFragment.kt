package kg.bishkoteka.ui.fragments.main.details

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kg.bishkoteka.R
import kg.bishkoteka.core.base.BaseBottomSheetDialogFragment
import kg.bishkoteka.databinding.FragmentDetailsBinding

@AndroidEntryPoint
class DetailsFragment :
    BaseBottomSheetDialogFragment<FragmentDetailsBinding, DetailsViewModel>(R.layout.fragment_favorite) {
    override val binding: FragmentDetailsBinding by viewBinding(FragmentDetailsBinding::bind)
    override val viewModel by viewModels<DetailsViewModel>()
}