package kg.bishkoteka.ui.fragments.authentication.signIn

import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import kg.bishkoteka.R
import kg.bishkoteka.core.base.BaseFragment
import kg.bishkoteka.core.extensions.activityNavController
import kg.bishkoteka.core.extensions.navigateSafely
import kg.bishkoteka.data.local.preferences.UserPreferences
import kg.bishkoteka.databinding.FragmentSignInBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SignInFragment :
    BaseFragment<FragmentSignInBinding, SignInViewModel>(R.layout.fragment_sign_in) {
    override val binding by viewBinding(FragmentSignInBinding::bind)
    override val viewModel by viewModels<SignInViewModel>()

    @Inject
    lateinit var userPreferences: UserPreferences

    override fun constructListeners() {
        binding.btnSignIn.setOnClickListener {
            viewModel.signIn(
                binding.etUsername.text.toString(),
                binding.etPassword.text.toString(),
            )
        }
        binding.tvSignUp.setOnClickListener {
            findNavController().navigateSafely(R.id.action_signInFragment_to_signUpFragment)
        }
    }

    override fun launchObservers() {
        viewModel.signInState.spectateUiState(success = {
            userPreferences.accessToken = it.access
            userPreferences.refreshToken = it.refresh
//            userPreferences.accessToken = getAuthenticationToken(it.tokens, true)
//            userPreferences.refreshToken = getAuthenticationToken(it.tokens, false)
            //TODO: поменять на true
            userPreferences.isAuthenticated = false
            activityNavController().navigateSafely(R.id.action_authenticationFlowFragment_to_mainFlowFragment)
        }, error = {
            Toast.makeText(requireContext(), "ne ok", Toast.LENGTH_SHORT).show()
        })
    }

//    private fun getAuthenticationToken(
//        tokenString: String,
//        shouldGetAccessToken: Boolean
//    ) = when (shouldGetAccessToken) {
//        true -> {
//            val tokenMap = tokenString.substring(1, tokenString.length - 1)
//                .split(", ")
//                .map { it.split(": ") }
//                .associate { (k, v) -> k to v }
//            tokenMap["'access'"]?.removeSurrounding("'")
//        }
//        false -> {
//            val tokenMap = tokenString.substring(1, tokenString.length - 1)
//                .split(", ")
//                .map { it.split(": ") }
//                .associate { (k, v) -> k to v }
//            tokenMap["'refresh'"]?.removeSurrounding("'")
//        }
//    }

}