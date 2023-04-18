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
import kg.bishkoteka.databinding.ItemDefaultEventBinding

class OnetimeEventAdapter(val onEventClick: (Int) -> Unit) :
    PagingDataAdapter<OnetimeEventResponse, OnetimeEventAdapter.EventModelPagingViewHolder>(
        BaseDiffUtilItemCallback()
    ) {

    override fun onBindViewHolder(holder: EventModelPagingViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventModelPagingViewHolder {
        return EventModelPagingViewHolder(
            ItemDefaultEventBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    inner class EventModelPagingViewHolder(
        private val binding: ItemDefaultEventBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(model: OnetimeEventResponse) {
            with(binding.inDefaultEvent) {
                tvEventTitle.text = model.title
                tvEventDatetime.text = model.start_time.toString()
                tvEventAddress.text = model.location
                tvEventDatetime.text = model.start_time.toDate()

                itemView.setOnClickListener {
                    onEventClick(model.id)
                    Log.e("model.id:", model.id.toString())
                }
            }
        }
    }
}