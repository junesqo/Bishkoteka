package kg.bishkoteka.ui.fragments.splash

import android.annotation.SuppressLint
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat
import by.kirich1409.viewbindingdelegate.viewBinding
import kg.bishkoteka.core.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kg.bishkoteka.R
import kg.bishkoteka.core.extensions.navigateSafely
import kg.bishkoteka.data.local.preferences.UserPreferences
import kg.bishkoteka.databinding.FragmentSplashScreenBinding
import kotlinx.coroutines.*
import kotlinx.coroutines.NonCancellable.start
import java.util.*
import java.util.logging.Handler
import javax.inject.Inject
import kotlin.concurrent.schedule

@SuppressLint("CustomSplashScreen")
@AndroidEntryPoint
class SplashScreenFragment :
    BaseFragment<FragmentSplashScreenBinding, SplashScreenViewModel>(R.layout.fragment_splash_screen) {
    override val binding: FragmentSplashScreenBinding by viewBinding(FragmentSplashScreenBinding::bind)
    override val viewModel by viewModels<SplashScreenViewModel>()

    @Inject
    lateinit var userPreferences: UserPreferences

    override fun initListeners() {

        //TODO: Поменять ГлобалСкоуп на что-то менее ресурсо-затратное
        GlobalScope.launch {
            delay(1000)
            withContext(Dispatchers.Main){

                //TODO: убрать эту строчку кода
                findNavController().navigateSafely(R.id.action_splashScreenFragment_to_mainFlowFragment)

//                when {
//                userPreferences.isAuthenticated -> {
//                    findNavController().navigateSafely(R.id.action_splashScreenFragment_to_mainFlowFragment)
//                }
//                !userPreferences.isAuthenticated -> {
//                    findNavController().navigateSafely(R.id.action_splashScreenFragment_to_authenticationFlowFragment)
//                }
//            }
            }
        }

//        Timer().schedule(1000) {
//            when {
//                    userPreferences.isAuthenticated -> {
//                    findNavController().navigateSafely(R.id.action_splashScreenFragment_to_mainFlowFragment)
//                }
//                    !userPreferences.isAuthenticated -> {
//                    findNavController().navigateSafely(R.id.action_splashScreenFragment_to_authAndRegFlowFragment)
//                    }
//                }
//        }

//        val avd = AnimatedVectorDrawableCompat.create(requireContext(), R.drawable.ic_snail_anim)
//
//        binding.logoAnim.setImageDrawable(avd)
//        binding.logoAnim.animate()
//            .alpha(1f)
//            .setDuration(3000L)
//            .withEndAction {
//                when {
//                    userPreferences.isAuthenticated -> {
//                    findNavController().navigateSafely(R.id.action_splashScreenFragment_to_mainFlowFragment)
//                }
//                    !userPreferences.isAuthenticated -> {
//                    findNavController().navigateSafely(R.id.action_splashScreenFragment_to_authAndRegFlowFragment)
//                    }
//                }
//            }
//            .start()
//
//        avd?.start()

    }
}