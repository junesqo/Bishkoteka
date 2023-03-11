package kg.bishkoteka.ui.fragments.main.favorite

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import kg.bishkoteka.databinding.FragmentFavoriteBinding
import dagger.hilt.android.AndroidEntryPoint
import kg.bishkoteka.R
import kg.bishkoteka.core.base.BaseFragment

@AndroidEntryPoint
class FavoriteFragment :
    BaseFragment<FragmentFavoriteBinding, FavoriteViewModel>(R.layout.fragment_favorite) {
        override val binding: FragmentFavoriteBinding by viewBinding(FragmentFavoriteBinding::bind)
        override val viewModel by viewModels<FavoriteViewModel>()
}