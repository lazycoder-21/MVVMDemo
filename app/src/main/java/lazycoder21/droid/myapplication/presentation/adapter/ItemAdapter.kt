package lazycoder21.droid.myapplication.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import lazycoder21.droid.myapplication.databinding.RvImagesItemBinding
import lazycoder21.droid.myapplication.model.Images
import lazycoder21.droid.myapplication.utils.loadUrl

class ItemAdapter : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    private val items: MutableList<Images> = mutableListOf()

    class ViewHolder(private val binding: RvImagesItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(images: Images) {
            binding.image.loadUrl(images.imageUrl)
        }
    }

    fun addItems(items: List<Images>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout = RvImagesItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(layout)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[holder.adapterPosition])
    }

    override fun getItemCount(): Int {
        return items.size
    }
}