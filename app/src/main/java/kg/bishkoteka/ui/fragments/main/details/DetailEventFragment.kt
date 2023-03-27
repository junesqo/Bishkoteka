package kg.bishkoteka.ui.fragments.main.details

import android.util.Log
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import dagger.hilt.android.AndroidEntryPoint
import kg.bishkoteka.R
import kg.bishkoteka.core.base.BaseBottomSheetDialogFragment
import kg.bishkoteka.core.extensions.toDate
import kg.bishkoteka.databinding.FragmentDetailEventBinding

import kg.bishkoteka.ui.fragments.main.home.HomeFragment.Companion.KEY_DETAIL_EVENT_HOME

@AndroidEntryPoint
class DetailEventFragment :
    BaseBottomSheetDialogFragment<FragmentDetailEventBinding, DetailEventViewModel>(R.layout.fragment_detail_event) {
    override val binding: FragmentDetailEventBinding by viewBinding(FragmentDetailEventBinding::bind)
    override val viewModel by viewModels<DetailEventViewModel>()
    private var eventId: Int = -1
    private val COLLAPSEDHEIGHT = 500

    override fun getTheme() = R.style.AppBottomSheetDialogTheme

    override fun onStart() {
        super.onStart()
        Log.e("onStart", "Success")
        Log.e("Details", eventId.toString())
        expandFragment()
    }

    private fun expandFragment() {
        val density = requireContext().resources.displayMetrics.density
        dialog?.let {
            // Находим сам bottomSheet и достаём из него Behaviour
            val bottomSheet = it.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet) as FrameLayout
            val behavior = BottomSheetBehavior.from(bottomSheet)

            // Выставляем высоту для состояния collapsed и выставляем состояние collapsed
            behavior.peekHeight = (COLLAPSEDHEIGHT * density).toInt()
            behavior.state = BottomSheetBehavior.STATE_COLLAPSED

            // Достаём корневые лэйауты
            val coordinator = (it as BottomSheetDialog).findViewById<CoordinatorLayout>(com.google.android.material.R.id.coordinator)
            val containerLayout = it.findViewById<FrameLayout>(com.google.android.material.R.id.container)

            // Надуваем наш лэйаут с кнопкой
            val buttons = it.layoutInflater.inflate(R.layout.button, null)

            // Выставляем параметры для нашей кнопки
            buttons.layoutParams = FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                height = (60 * density).toInt()
                gravity = Gravity.BOTTOM
            }
            // Добавляем кнопку в контейнер
            containerLayout?.addView(buttons)

            // Перерисовываем лэйаут
            buttons.post {
                (coordinator?.layoutParams as ViewGroup.MarginLayoutParams).apply {
                    buttons.measure(
                        View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
                        View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED)
                    )
                    // Устраняем разрыв между кнопкой и скролящейся частью
                    this.bottomMargin = (buttons.measuredHeight - 8 * density).toInt()
                    containerLayout?.requestLayout()
                }
            }

            behavior.addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {

                override fun onStateChanged(bottomSheet: View, newState: Int) {
                    // Нам не нужны действия по этому колбеку
                }

                override fun onSlide(bottomSheet: View, slideOffset: Float) {
                    with(binding) {
                        // Нас интересует только положительный оффсет, тк при отрицательном нас устроит стандартное поведение - скрытие фрагмента
                        if (slideOffset > 0) {
                            // Делаем "свёрнутый" layout более прозрачным
                            layoutCollapsed.alpha = 1 - 2 * slideOffset
                            // И в то же время делаем "расширенный layout" менее прозрачным
                            layoutExpanded.alpha = slideOffset * slideOffset

                            // Когда оффсет превышает половину, мы скрываем collapsed layout и делаем видимым expanded
                            if (slideOffset > 0.5) {
                                layoutCollapsed.visibility = View.GONE
                                layoutExpanded.visibility = View.VISIBLE
                            }

                            // Если же оффсет меньше половины, а expanded layout всё ещё виден, то нужно скрывать его и показывать collapsed
                            if (slideOffset < 0.5 && binding.layoutExpanded.visibility == View.VISIBLE) {
                                layoutCollapsed.visibility = View.VISIBLE
                                layoutExpanded.visibility = View.INVISIBLE
                            }
                        }
                    }
                }
            })
        }
    }

    override fun initRequest() {
        super.initRequest()
        Log.e("initRequest", "Success")
        getEventById()
    }

    override fun initSubscribers() {
        super.initSubscribers()
        Log.e("initSubscribers", "Success")
        collectEventById()
    }

    private fun getEventById() {
        Log.e("getEventById", "Success")
        viewModel.getEventById(eventId)

    }

    private fun collectEventById() {
        viewModel.getEventByIdState.collectUIState { model ->
            with(binding) {
                Log.e("collectEventById", "Success")
                Log.e("collectEventById", model.toString())
                eventId = model.id
                tvTitle.text = model.title
                tvOrganizationName.text = model.organization
                tvEntry.text = model.entry
                tvEventAddress.text = model.location
                tvEventStartTime.text = model.start_time.toDate()
                tvDescription.text = model.description
            }
        }
    }

    override fun initialize() {
        super.initialize()
        initId()
    }
    private fun initId() {
        checkId(KEY_DETAIL_EVENT_HOME)
//        checkSlug(KEY_DETAIL_TOUR_BY_WORD)
//        checkSlug(KEY_DETAIL_TOUR_FILTERED)
//        checkSlug(KEY_DETAIL_TOUR_FAVORITE)
    }
    private fun checkId(key: String) {
        if (arguments?.getInt(key) != null) {
            eventId = arguments?.getInt(key)!!
            Log.e("checkId", "Success")

        }
    }

}