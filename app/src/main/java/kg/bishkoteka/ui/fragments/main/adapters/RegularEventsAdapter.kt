package kg.bishkoteka.ui.fragments.main.adapters

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import kg.bishkoteka.core.extensions.toDate
import kg.bishkoteka.core.network.paging.BaseDiffUtilItemCallback
import kg.bishkoteka.data.models.get.events.OnetimeEventResponse
import kg.bishkoteka.data.models.get.events.RegularEventResponse
import kg.bishkoteka.databinding.ItemDefaultEventBinding
import kg.bishkoteka.databinding.ItemRegularEventBinding

class RegularEventsAdapter(val onEventClick: (Int) -> Unit) :
    PagingDataAdapter<RegularEventResponse, RegularEventsAdapter.EventModelPagingViewHolder>(
        BaseDiffUtilItemCallback()
    ) {

    override fun onBindViewHolder(holder: EventModelPagingViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventModelPagingViewHolder {
        return EventModelPagingViewHolder(
            ItemRegularEventBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    inner class EventModelPagingViewHolder(
        private val binding: ItemRegularEventBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(model: RegularEventResponse) {
            with(binding) {
                tvEventTitle.text = model.title
                tvEventDatetime.text = model.start_time + " ·"
                if (model.occurrence_days.isNotEmpty()) {
                    tvEventDatetime.append(" " + model.occurrence_days)
                }
                tvEventAddress.text = model.location
                itemView.setOnClickListener {
                    onEventClick(model.id)
                    Log.e("model.id:", model.id.toString())
                }
            }
        }
    }
}