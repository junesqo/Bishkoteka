package kg.bishkoteka.util

import android.content.Context
import android.content.Intent
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.geeks.ulul.data.util.Constant.CORRECT_IMAGE_URL
import com.geeks.ulul.data.util.Constant.INVALID_IMAGE_URL


//fun FilterModel.changeFilter(newFilter: FilterModel) {
//    this.category = newFilter.category
//    this.date_departure = newFilter.date_departure
//    this.complexity = newFilter.complexity
//    this.duration = newFilter.duration
//    this.price_max = newFilter.price_max
//}
//
//fun List<Region>.getRegions(): String {
//    var result = ""
//    if (this.isNotEmpty()) {
//        for (i in 0 until this.size) {
//            result += if (i != this.size - 1) {
//                this[i].name + ", "
//            } else {
//                this[i].name
//            }
//        }
//    }
//    return result
//}

fun Intent.share(text: String?): Intent? {
    this.apply {
        action = Intent.ACTION_SEND
        putExtra(Intent.EXTRA_TEXT, text ?: "")
        type = "text/plain"
    }
    return Intent.createChooser(this, null)
}

fun String.correctUrl(): String {
    return CORRECT_IMAGE_URL + this.substring(INVALID_IMAGE_URL.length, this.length)
}

fun ImageView.load(url: String) {
    Glide.with(this).load(url).into(this)
}

fun String.getDuration(): String {
    var result = "$this "
    when (this.toInt()) {
        1 -> result += "день"
        3 -> result += "дня"
        7 -> result += "дней"
    }
    return result
}

//fun List<TourImage>.getMainImage(): String {
//    if (this.isNotEmpty()) {
//        for (i in this) {
//            if (i.is_main) {
//                return i.images.correctUrl()
//            }
//        }
//    }
//    return ""
//}

//fun List<TourImage>.getMainImageFavorite(): String {
//    if (this.isNotEmpty()) {
//        for (i in this) {
//            if (i.is_main) {
//                return CORRECT_IMAGE_URL + i.images
//            }
//        }
//    }
//    return ""
//}

fun Context.showToast(text: String) {
    Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
}

fun String.correctDate() = this.substring(2, 4) + "/" + this.substring(5, 7) + "/" + this.substring(8, 10)

fun String.getRating(): Float {
    if (this == "No reviews yet") {
        return 0F
    }
    return this.toFloat()
}