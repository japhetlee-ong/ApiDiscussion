package ph.edu.auf.apidiscussion.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import ph.edu.auf.apidiscussion.databinding.ContentRvQuotesBinding
import ph.edu.auf.apidiscussion.models.ResultsModel

class QuotesAdapter(private var quotesList: ArrayList<ResultsModel>, private var context: Context): RecyclerView.Adapter<QuotesAdapter.QuotesViewHolder>() {

    inner class QuotesViewHolder(val binding: ContentRvQuotesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ResultsModel) {
            binding.txtQuote.text = item.content
            binding.txtAuthor.text = item.author
            binding.chipTags.removeAllViews()
            for (tag in item.tags) {
                addChip(tag, binding.chipTags)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuotesViewHolder {
        val binding =
            ContentRvQuotesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return QuotesViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return quotesList.size
    }

    override fun onBindViewHolder(holder: QuotesViewHolder, position: Int) {
        holder.bind(quotesList[position])
    }

    private fun addChip(tag: String, layout: ChipGroup) {
        val chip = Chip(context)
        chip.text = tag
        layout.addView(chip)
    }
}