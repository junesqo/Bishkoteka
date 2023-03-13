package kg.bishkoteka.ui.fragments.authentication.signUp

import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import kg.bishkoteka.R
import kg.bishkoteka.core.base.BaseFragment
import kg.bishkoteka.core.extensions.navigateSafely
import kg.bishkoteka.databinding.FragmentSignUpBinding
import kg.bishkoteka.ui.fragments.authentication.signUp.SignUpViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignUpFragment :
    BaseFragment<FragmentSignUpBinding, SignUpViewModel>(R.layout.fragment_sign_up) {
    override val binding by viewBinding(FragmentSignUpBinding::bind)
    override val viewModel by viewModels<SignUpViewModel>()

    override fun initListeners() {
        binding.btnSignUp.setOnClickListener {
            viewModel.signUp(
                binding.etFirstName.text.toString(),
                binding.etLastName.text.toString(),
                binding.etUsername.text.toString(),
                binding.etEmail.text.toString(),
                binding.etPassword.text.toString(),
                binding.etConfirmPassword.text.toString()
            )
        }
        binding.tvSignIn.setOnClickListener {
            findNavController().navigateSafely(R.id.action_signUpFragment_to_signInFragment)
        }
    }

    override fun initSubscribers() {
        viewModel.signUpState.spectateUiState(success = {
            Toast.makeText(requireContext(), "ok", Toast.LENGTH_SHORT).show()
        }, error = {
            Toast.makeText(requireContext(), "ne ok", Toast.LENGTH_SHORT).show()

        })
    }
}