package ph.edu.auf.apidiscussion.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import ph.edu.auf.apidiscussion.constants.ApiState
import ph.edu.auf.apidiscussion.repositories.QuotesRepository

class QuotesViewModel(private var quotesRepository: QuotesRepository): ViewModel() {

    val quotesVMState: MutableStateFlow<ApiState> = MutableStateFlow(ApiState.Empty)

    fun getQuotes(page: Int) = viewModelScope.launch(Dispatchers.IO){
        quotesVMState.value = ApiState.Loading
        quotesRepository.getQuotes(page)
            .catch { e->
                quotesVMState.value = ApiState.Failure(e)
            }.collect{data ->
                quotesVMState.value = ApiState.Success(data)
            }
    }

}