@file:Suppress("UNCHECKED_CAST")

package ph.edu.auf.apidiscussion.viewmodels.factories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ph.edu.auf.apidiscussion.repositories.QuotesRepository
import ph.edu.auf.apidiscussion.viewmodels.QuotesViewModel

class QuotesViewModelFactory(private val quotesRepository: QuotesRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return QuotesViewModel(quotesRepository) as T
    }
}