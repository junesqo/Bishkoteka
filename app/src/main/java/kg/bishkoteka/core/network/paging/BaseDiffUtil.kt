package kg.bishkoteka.core.network.paging

import androidx.recyclerview.widget.DiffUtil


interface BaseDiffModel<T> {
    val idDif: T
    override fun equals(other: Any?): Boolean
}

class BaseDiffUtilItemCallback<T : BaseDiffModel<S>, S> : DiffUtil.ItemCallback<T>() {

    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem.idDif == newItem.idDif
    }

    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem == newItem
    }
}