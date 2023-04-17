//package kg.bishkoteka.ui.fragments.main.adapters
//
//import android.annotation.SuppressLint
//import android.view.LayoutInflater
//import android.view.ViewGroup
//import androidx.paging.PagingDataAdapter
//import androidx.recyclerview.widget.RecyclerView
//import kg.bishkoteka.core.network.paging.BaseDiffUtilItemCallback
//import kg.bishkoteka.data.models.get.events.EventModel
//
//class DefaultAdapter(val onTourClick: (String) -> Unit) :
//    PagingDataAdapter<EventModel, DefaultAdapter.TourModelPagingViewHolder>(
//        BaseDiffUtilItemCallback()
//    ) {
//
//    override fun onBindViewHolder(holder: TourModelPagingViewHolder, position: Int) {
//        getItem(position)?.let { holder.bind(it) }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TourModelPagingViewHolder {
//        return TourModelPagingViewHolder(
//            ItemHorseBinding.inflate(
//                LayoutInflater.from(parent.context),
//                parent, false
//            )
//        )
//    }
//
//    inner class TourModelPagingViewHolder(
//        private val binding: ItemHorseBinding,
//    ) : RecyclerView.ViewHolder(binding.root) {
//        @SuppressLint("SetTextI18n")
//        fun bind(model: ShortTourModel) {
//            with(binding.inHorse) {
//                ivImage.load(model.tour_images.getMainImage())
//                tvTitle.text = model.title
//                tvPrice.text = model.price.toString()
//
//                itemView.setOnClickListener {
//                    onTourClick(model.slug)
//                }
//            }
//        }
//    }
//}