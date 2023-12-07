package ph.edu.auf.apidiscussion.repositories

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import ph.edu.auf.apidiscussion.apiclient.RetrofitClient
import ph.edu.auf.apidiscussion.models.QuotesModel

class QuotesRepository {

    fun getQuotes(page: Int) : Flow<QuotesModel> = flow{
        val r = RetrofitClient.retrofit.create(Quotes::class.java).getQuotes(page)
        emit(r)
    }.flowOn(Dispatchers.IO)

}