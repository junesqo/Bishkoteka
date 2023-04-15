package kg.bishkoteka.ui.fragments.main.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kg.bishkoteka.data.remote.dto.events.CategoryModel
import kg.bishkoteka.databinding.ItemCategoryBinding

class CategoryAdapter(private val onCategoryClick: (Int) -> Unit) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    private val data = arrayListOf<CategoryModel>()

    fun addData(newData: List<CategoryModel>) {
        data.clear()
        data.addAll(newData)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder(ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(data[position])
    }

    inner class CategoryViewHolder(private val binding: ItemCategoryBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(model: CategoryModel) {
            binding.tvCategoryTitle.text = model.title

            itemView.setOnClickListener {
                onCategoryClick(model.id)
            }
        }
    }
}