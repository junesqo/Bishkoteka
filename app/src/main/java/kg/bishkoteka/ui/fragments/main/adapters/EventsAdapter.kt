package kg.bishkoteka.ui.fragments.main.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import kg.bishkoteka.core.network.paging.BaseDiffUtil
import kg.bishkoteka.data.remote.dto.events.EventDto
import kg.bishkoteka.databinding.ItemEventBinding
import kg.bishkoteka.ui.models.EventUi

class EventsAdapter(private val onItemClick: (eventId: Int) -> Unit) :
    PagingDataAdapter<EventUi, EventsAdapter.EventsViewHolder>(BaseDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = EventsViewHolder(
        ItemEventBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )

    override fun onBindViewHolder(holder: EventsViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
    }

    inner class EventsViewHolder(private val binding: ItemEventBinding) :
        ViewHolder(binding.root) {
        fun onBind(event: EventUi) {
            binding.tvEventTitle.text = event.title
            binding.tvEventAddress.text = event.location
            binding.tvEventDatetime.text = event.start_time.toString()
//            binding.imFlag.loadSvgImage(country.flags.svg)

        }

        init {
            binding.root.setOnClickListener {
                getItem(absoluteAdapterPosition)?.let {
                    onItemClick(it.id)
                }
            }
        }
    }
}