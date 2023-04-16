package kg.bishkoteka.ui.fragments.main.event.create_event

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.util.Log
import android.view.View
import android.widget.*
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kg.bishkoteka.R
import kg.bishkoteka.core.base.BaseFragment
import kg.bishkoteka.data.remote.dto.events.CreateEventDto
import kg.bishkoteka.data.util.showToast
import kg.bishkoteka.databinding.FragmentCreateEventBinding
import kg.bishkoteka.ui.fragments.main.organization.my_organizations.MyOrganizationsFragment
import kg.bishkoteka.ui.fragments.main.organization.organization_details.OrganizationDetailsFragment.Companion.KEY_ORGANIZATION_DETAIL
import java.text.SimpleDateFormat
import java.util.*


@AndroidEntryPoint
class CreateEventFragment :
    BaseFragment<FragmentCreateEventBinding, CreateEventViewModel>(kg.bishkoteka.R.layout.fragment_create_event),
    AdapterView.OnItemSelectedListener, DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {
    override val binding: FragmentCreateEventBinding by viewBinding(
        FragmentCreateEventBinding::bind
    )
    override val viewModel by viewModels<CreateEventViewModel>()
    private var organizationId: Int = -1
    private var eventEntry: String = "свободный"
    private val calendar = Calendar.getInstance()
    private var startDate: String = ""
    private var startTime: String = ""
    private var endDate: String = ""
    private var endTime: String = ""
    val sdf = SimpleDateFormat("HH:mm, dd MMMM yyyy ")
    var day = 0
    var month = 0
    var year = 0
    var hour = 0
    var minute = 0

    var savedDay = 0
    var savedMonth = 0
    var savedYear = 0
    var savedHour = 0
    var savedMinute = 0

    var millis: Long = 1657204941288

    override fun initialize() {
        super.initialize()
        initId()
    }

    private fun initId() {
        checkId(KEY_ORGANIZATION_DETAIL)
    }

    private fun checkId(key: String) {
        if (arguments?.getInt(key) != null) {
            organizationId = arguments?.getInt(key)!!
            Log.e("checkId", "Success")
            Log.e("checkId", organizationId.toString())
        }
    }

    override fun initListeners() {
        super.initListeners()
        viewModel.createEvent.collectUIState { Log.e("aga", "initListeners: success") }

        ArrayAdapter.createFromResource(
            requireContext(),
            kg.bishkoteka.R.array.entry_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            binding.spinnerEntry.adapter = adapter
        }
        binding.spinnerEntry.onItemSelectedListener = this

        with(binding) {
            btnCreateOrganization.setOnClickListener {
                if (etEventTitle.text.toString()
                        .isNotEmpty() && etEventStartTime.text.toString()
                        .isNotEmpty() && etEventLocation.text.toString()
                        .isNotEmpty() && etEventDescription.text.toString().isNotEmpty()
                ) {
                    viewModel.createEvent(
                        organizationId,
                        CreateEventDto(
                            organizationId = organizationId,
                            title = etEventTitle.text.toString(),
                            description = etEventDescription.text.toString(),
                            price = etEventPrice.text.toString(),
                            location = etEventLocation.text.toString(),
                            entry = eventEntry,
                            start_time = millis.toString(),
                            end_time = millis.plus(3600).toString(),
                        )
                    )
                    viewModel.createEvent.collectUIState {
                        findNavController().navigateUp()
                    }
                } else if (etEventTitle.text.toString().isEmpty()) {
                    requireContext().showToast("Поле названия не должно быть пустым")
                } else if (etEventLocation.text.toString().isEmpty()) {
                    requireContext().showToast("Поле адреса не должно быть пустым")
                } else if (etEventDescription.text.toString().isEmpty()) {
                    requireContext().showToast("Поле дополнительной информации не должно быть пустым")
                }
            }

            etEventStartDate.setOnClickListener {
                showDatePicker(true)
            }
            etEventEndDate.setOnClickListener {
                showDatePicker(false)
            }
            etEventStartTime.setOnClickListener {
                showTimePicker(true)
            }
            etEventEndTime.setOnClickListener {
                showTimePicker(false)
            }
        }
    }

//    private fun getDateTimeCalendar(){
//        day = calendar.get(Calendar.DAY_OF_MONTH)
//        month = calendar.get(Calendar.MONTH)
//        year = calendar.get(Calendar.YEAR)
//        hour = calendar.get(Calendar.HOUR)
//        minute = calendar.get(Calendar.MINUTE)
//        millis = calendar.timeInMillis
//    }
//
//    private fun pickDate() {
//        binding.etEventStartDate.setOnClickListener {
//            getDateTimeCalendar()
//            DatePickerDialog(requireContext(), this, year, month, day).show()
//        }
////        binding.date.text = sdf.format(millis)
//    }
//
//    override fun onDateSet(p0: DatePicker?, p1: Int, p2: Int, p3: Int) {
//        savedDay = p3
//        savedMonth = p2
//        savedYear = p1
//
//        getDateTimeCalendar()
//        TimePickerDialog(requireContext(), this, hour, minute, true).show()
//        calendar.set(Calendar.DAY_OF_MONTH, p3)
//        calendar.set(Calendar.MONTH, p2)
//        calendar.set(Calendar.YEAR, p1)
//    }
//
//    override fun onTimeSet(p0: TimePicker?, p1: Int, p2: Int) {
//        savedHour = p1
//        savedMinute = p2
//        calendar.set(Calendar.MINUTE, p2)
//        calendar.set(Calendar.HOUR, p1)
//        millis = calendar.timeInMillis
//
//        binding.etEventStartDate.setText(sdf.format(millis))
////        binding.date.text = "$savedHour:$savedMinute, $savedDay-$savedMonth $savedYear"
//    }

    private fun showDatePicker(isStart: Boolean) {
        val cal = Calendar.getInstance()
        val year = cal.get(Calendar.YEAR)
        val month = cal.get(Calendar.MONTH)
        val day = cal.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            requireContext(),
            { _, year, month, dayOfMonth ->
                // Update date button text
                val sdf = SimpleDateFormat("MM/dd/yyyy", Locale.US)
                val selectedDate = sdf.format(Date(year - 1900, month, dayOfMonth))
                if (isStart) {
                    binding.etEventStartDate.setText(selectedDate)
                    startDate = selectedDate
                } else {
                    binding.etEventEndDate.setText(selectedDate)
                    endDate = selectedDate
                }
            },
            year,
            month,
            day
        )
        datePickerDialog.show()
    }

    private fun showTimePicker(isStart: Boolean) {
        val cal = Calendar.getInstance()
        val hour = cal.get(Calendar.HOUR_OF_DAY)
        val minute = cal.get(Calendar.MINUTE)
        millis = cal.timeInMillis

        val timePickerDialog = TimePickerDialog(
            requireContext(),
            { _, hourOfDay, minute ->
                // Update time button text
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                if (isStart) {
                    binding.etEventStartTime.setText(selectedTime)
                } else {
                    binding.etEventEndTime.setText(selectedTime)
                }
            },
            hour,
            minute,
            true // 24 hour format
        )
        timePickerDialog.show()
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        val sdf = SimpleDateFormat("HH:mm yyyy-MM-dd")
        calendar.set(year, month, dayOfMonth)
//        val selectedDate = sdf.format(calendar.time)
//        val selectedDate = "$dayOfMonth/${month + 1}/$year"
//        val selectedDateTextView = view?.findViewById<TextView>(kg.bishkoteka.R.id.selected_date_text_view)
//        selectedDateTextView?.text = selectedDate
    }

    override fun onTimeSet(p0: TimePicker?, hour: Int, minute: Int) {
        calendar.set(hour, minute)
        millis = calendar.timeInMillis

//        binding.date.text = sdf.format(millis)
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        eventEntry = parent?.getItemAtPosition(position).toString()
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
}

