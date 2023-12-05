package ph.edu.auf.apidiscussion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ph.edu.auf.apidiscussion.adapters.QuotesAdapter
import ph.edu.auf.apidiscussion.databinding.ActivityMainBinding
import ph.edu.auf.apidiscussion.models.ResultsModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: QuotesAdapter
    private lateinit var quoteList : ArrayList<ResultsModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        quoteList = arrayListOf()
        adapter = QuotesAdapter(quoteList,this)
        val llManager : RecyclerView.LayoutManager = LinearLayoutManager(this)

        binding.rvQuotes.adapter = adapter
        binding.rvQuotes.layoutManager = llManager
        binding.rvQuotes.visibility = View.GONE
        binding.animationView.visibility = View.GONE

        binding.rvQuotes.addOnScrollListener(object: RecyclerView.OnScrollListener(){
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if(!recyclerView.canScrollVertically(1) && newState == RecyclerView.SCROLL_STATE_IDLE){

                }
            }
        })
    }
}