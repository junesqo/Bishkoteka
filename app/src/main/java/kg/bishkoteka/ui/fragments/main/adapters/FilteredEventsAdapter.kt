package kg.bishkoteka.ui.fragments.main.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import kg.bishkoteka.core.extensions.toDate
import kg.bishkoteka.core.network.paging.BaseDiffUtilItemCallback
import kg.bishkoteka.data.remote.dto.events.EventModel
import kg.bishkoteka.databinding.ItemDefaultEventBinding
import kg.bishkoteka.databinding.ItemDefaultWideEventBinding

class FilteredEventsAdapter(val onEventClick: (Int) -> Unit) :
    PagingDataAdapter<EventModel, FilteredEventsAdapter.WideEventModelPagingViewHolder>(
        BaseDiffUtilItemCallback()
    ) {

    override fun onBindViewHolder(holder: WideEventModelPagingViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WideEventModelPagingViewHolder {
        return WideEventModelPagingViewHolder(
            ItemDefaultWideEventBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    inner class WideEventModelPagingViewHolder(
        private val binding: ItemDefaultWideEventBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(model: EventModel) {
            with(binding.inDefaultWideEvent) {
                tvEventTitle.text = model.title
//                tvEventDatetime.text = model.start_time.toString()
                tvEventAddress.text = model.location
                tvEventDatetime.text = model.start_time.toDate()

                itemView.setOnClickListener {
                    onEventClick(model.id)
                }
            }
        }
    }
}