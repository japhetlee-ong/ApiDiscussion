package ph.edu.auf.apidiscussion.repositories

import ph.edu.auf.apidiscussion.constants.Api
import ph.edu.auf.apidiscussion.models.QuotesModel
import retrofit2.http.GET
import retrofit2.http.Query

interface Quotes {
    @GET(Api.QUOTES)
    suspend fun getQuotes(@Query("page") page: Int) : QuotesModel

}