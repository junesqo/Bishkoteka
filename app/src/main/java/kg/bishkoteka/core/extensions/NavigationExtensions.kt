package kg.bishkoteka.core.extensions

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.findNavController
import kg.bishkoteka.R

fun Fragment.activityNavController() = requireActivity().findNavController(R.id.nav_host_fragment)
// Проверка на нажатие двух кнопок которые навигируют на разные фрагменты
fun NavController.navigateSafely(@IdRes actionId: Int) {
    currentDestination?.getAction(actionId)?.let { navigate(actionId) }
}

fun NavController.navigateSafely(directions: NavDirections) {
    currentDestination?.getAction(directions.actionId)?.let { navigate(directions) }
}