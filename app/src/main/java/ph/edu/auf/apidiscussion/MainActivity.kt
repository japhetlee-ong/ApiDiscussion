package ph.edu.auf.apidiscussion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import ph.edu.auf.apidiscussion.adapters.QuotesAdapter
import ph.edu.auf.apidiscussion.constants.ApiState
import ph.edu.auf.apidiscussion.databinding.ActivityMainBinding
import ph.edu.auf.apidiscussion.models.QuotesModel
import ph.edu.auf.apidiscussion.models.ResultsModel
import ph.edu.auf.apidiscussion.repositories.QuotesRepository
import ph.edu.auf.apidiscussion.viewmodels.QuotesViewModel
import ph.edu.auf.apidiscussion.viewmodels.factories.QuotesViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: QuotesAdapter
    private lateinit var quoteList : ArrayList<ResultsModel>
    private lateinit var viewModel : QuotesViewModel
    private var page: Int = 1
    private var firstLoad: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this,QuotesViewModelFactory(QuotesRepository()))[QuotesViewModel::class.java]

        quoteList = arrayListOf()
        adapter = QuotesAdapter(quoteList,this)

        val llManager : RecyclerView.LayoutManager = LinearLayoutManager(this)

        binding.rvQuotes.adapter = adapter
        binding.rvQuotes.layoutManager = llManager
        binding.rvQuotes.visibility = View.GONE
        binding.animationView.visibility = View.VISIBLE

        binding.rvQuotes.addOnScrollListener(object: RecyclerView.OnScrollListener(){
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if(!recyclerView.canScrollVertically(1) && newState == RecyclerView.SCROLL_STATE_IDLE){
                    page += 1
                    viewModel.getQuotes(page)
                }
            }
        })

        viewModel.getQuotes(page)

        lifecycleScope.launch {
            viewModel.quotesVMState.collect{
                when(it){
                    is ApiState.Loading -> {
                        if(firstLoad){
                            binding.animationView.visibility = View.VISIBLE
                            firstLoad = false
                        }
                    }
                    is ApiState.Failure -> {
                        binding.animationView.visibility = View.GONE
                        binding.rvQuotes.visibility = View.GONE
                        it.e.printStackTrace()
                    }
                    is ApiState.Success -> {
                        binding.animationView.visibility = View.GONE
                        binding.rvQuotes.visibility = View.VISIBLE

                        val results = it.data as QuotesModel
                        quoteList.addAll(results.results)
                        adapter.notifyItemInserted(quoteList.size - 1)
                    }
                    is ApiState.Empty -> {
                        binding.animationView.visibility = View.VISIBLE
                    }
                }
            }
        }
    }
}