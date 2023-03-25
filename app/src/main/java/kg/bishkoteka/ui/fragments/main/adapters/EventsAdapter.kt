package kg.bishkoteka.ui.fragments.main.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import kg.bishkoteka.core.network.paging.BaseDiffUtilItemCallback
import kg.bishkoteka.data.remote.dto.events.EventModel
import kg.bishkoteka.databinding.ItemDefaultEventBinding
import kg.bishkoteka.databinding.ItemEventBinding

class EventsAdapter(val onTourClick: (Int) -> Unit) :
    PagingDataAdapter<EventModel, EventsAdapter.TourModelPagingViewHolder>(
        BaseDiffUtilItemCallback()
    ) {

    override fun onBindViewHolder(holder: TourModelPagingViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TourModelPagingViewHolder {
        return TourModelPagingViewHolder(
            ItemDefaultEventBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    inner class TourModelPagingViewHolder(
        private val binding: ItemDefaultEventBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(model: EventModel) {
            with(binding.inDefaultEvent) {
                tvEventTitle.text = model.title
                tvEventDatetime.text = model.start_time.toString()
                tvEventAddress.text = model.location

                itemView.setOnClickListener {
                    onTourClick(model.id)
                }
            }
        }
    }
}