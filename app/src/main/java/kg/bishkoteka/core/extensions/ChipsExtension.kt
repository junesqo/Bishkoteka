package kg.bishkoteka.core.extensions

import android.view.LayoutInflater
import android.view.View
import androidx.core.content.ContextCompat
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import kg.bishkoteka.R

fun ChipGroup.addChip(
    text: String,
    isTouchTargeSize: Boolean = false,
    closeIconListener: View.OnClickListener? = null
) {
    val chip: Chip = LayoutInflater.from(context).inflate(R.layout.item_chip,null,false) as Chip
    chip.text = if (text.length > 9) text.substring(0,9) + "..." else text
    chip.isClickable = false
    chip.setEnsureMinTouchTargetSize(isTouchTargeSize)
    if (closeIconListener != null){
        chip.closeIcon = ContextCompat.getDrawable(context, com.google.android.material.R.drawable.ic_mtrl_chip_close_circle)
        chip.isCloseIconVisible = true
        chip.setOnCloseIconClickListener(closeIconListener)
    }
    addView(chip)
}