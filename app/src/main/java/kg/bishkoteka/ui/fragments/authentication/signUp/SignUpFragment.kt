package kg.bishkoteka.ui.fragments.authentication.signUp

import android.app.DatePickerDialog
import android.widget.DatePicker
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kg.bishkoteka.R
import kg.bishkoteka.core.base.BaseFragment
import kg.bishkoteka.core.extensions.navigateSafely
import kg.bishkoteka.databinding.FragmentSignUpBinding
import java.text.SimpleDateFormat
import java.util.*

@AndroidEntryPoint
class SignUpFragment :
    BaseFragment<FragmentSignUpBinding, SignUpViewModel>(R.layout.fragment_sign_up), DatePickerDialog.OnDateSetListener {
    override val binding by viewBinding(FragmentSignUpBinding::bind)
    override val viewModel by viewModels<SignUpViewModel>()
    private val calendar = Calendar.getInstance()


    override fun initListeners() {
        binding.btnSignUp.setOnClickListener {
            viewModel.signUp(
                binding.etUsername.text.toString(),
                binding.etEmail.text.toString(),
                binding.etPassword.text.toString(),
                binding.etConfirmPassword.text.toString(),
            )
        }
        binding.tvSignIn.setOnClickListener {
            findNavController().navigateSafely(R.id.action_signUpFragment_to_signInFragment)
        }
    }

    private fun showDatePickerDialog() {
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        val datePickerDialog = DatePickerDialog(
            requireContext(),
            R.style.MySpinnerDatePickerStyle,
            this, // Set the onDateSetListener object
            year,
            month,
            day,
        )
        datePickerDialog.show()
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        val sdf = SimpleDateFormat("yyyy-MM-dd")
        calendar.set(year, month, dayOfMonth)
        val selectedDate = sdf.format(calendar.time)
//        binding.tvBirthdate.text = selectedDate
    }

    override fun initSubscribers() {
        viewModel.signUpState.spectateUiState(success = {
            Toast.makeText(requireContext(), "ok", Toast.LENGTH_SHORT).show()
            findNavController().navigateSafely(R.id.action_signUpFragment_to_signInFragment)
        }, error = {
            Toast.makeText(requireContext(), "ne ok", Toast.LENGTH_SHORT).show()

        })
    }


}