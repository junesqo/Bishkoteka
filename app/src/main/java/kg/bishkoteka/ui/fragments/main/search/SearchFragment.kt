package kg.bishkoteka.ui.fragments.main.search

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import kg.bishkoteka.core.base.BaseFragment
import kg.bishkoteka.ui.fragments.main.search.SearchViewModel
import kg.bishkoteka.R

import kg.bishkoteka.databinding.FragmentSearchBinding

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment :
    BaseFragment<FragmentSearchBinding, SearchViewModel>(R.layout.fragment_search) {
    override val binding: FragmentSearchBinding by viewBinding(FragmentSearchBinding::bind)
    override val viewModel by viewModels<SearchViewModel>()
}