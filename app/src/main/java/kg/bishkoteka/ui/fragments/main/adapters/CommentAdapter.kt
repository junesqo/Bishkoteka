package kg.bishkoteka.ui.fragments.main.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kg.bishkoteka.data.models.get.events.CommentResponse
import kg.bishkoteka.databinding.ItemCommentBinding

class CommentAdapter() : RecyclerView.Adapter<CommentAdapter.CommentViewHolder>() {

    private val data = arrayListOf<CommentResponse>()

    fun addData(newData: List<CommentResponse>) {
        data.clear()
        data.addAll(newData)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        return CommentViewHolder(ItemCommentBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        holder.bind(data[position])
    }

    inner class CommentViewHolder(private val binding: ItemCommentBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(model: CommentResponse) {
            binding.tvUsername.text = model.username
            binding.tvText.text = model.text
        }
    }
}