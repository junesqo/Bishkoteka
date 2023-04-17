package kg.bishkoteka.ui.fragments.main.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kg.bishkoteka.data.models.get.organization.OrganizationResponse
import kg.bishkoteka.databinding.ItemOrganizationBinding

class OrganizationAdapter(private val onOrganizationClick: (Int) -> Unit) : RecyclerView.Adapter<OrganizationAdapter.OrganizationViewHolder>() {

    private val data = arrayListOf<OrganizationResponse>()

    fun addData(newData: List<OrganizationResponse>) {
        data.clear()
        data.addAll(newData)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrganizationViewHolder {
        return OrganizationViewHolder(ItemOrganizationBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: OrganizationViewHolder, position: Int) {
        holder.bind(data[position])
    }

    inner class OrganizationViewHolder(private val binding: ItemOrganizationBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(model: OrganizationResponse) {
            binding.tvOrganizationName.text = model.name
            binding.tvOrganizationType.text = model.type
            itemView.setOnClickListener {
                onOrganizationClick(model.id)
            }
        }
    }
}