package kg.bishkoteka.ui.fragments.authentication.chooseTypeOfAccount;

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kg.bishkoteka.R
import kg.bishkoteka.core.base.BaseFragment
import kg.bishkoteka.core.extensions.navigateSafely
import kg.bishkoteka.databinding.FragmentChooseAccountTypeBinding

@AndroidEntryPoint
class ChooseAccountTypeFragment :
    BaseFragment<FragmentChooseAccountTypeBinding, ChooseAccountTypeViewModel>(R.layout.fragment_choose_account_type) {
    override val binding: FragmentChooseAccountTypeBinding by viewBinding(FragmentChooseAccountTypeBinding::bind)
    override val viewModel by viewModels<ChooseAccountTypeViewModel>()

    override fun initListeners() {
        binding.btnGuest.setOnClickListener {
            findNavController().navigateSafely(R.id.action_chooseAccountTypeFragment_to_signUpFragment)
        }
        binding.btnOrganizator.setOnClickListener {
//            findNavController().navigateSafely(R.id.action_chooseAccountTypeFragment_to_signUpOrganizationFragment)
        }
    }
}