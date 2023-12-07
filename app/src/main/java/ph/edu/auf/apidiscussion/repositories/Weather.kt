package ph.edu.auf.apidiscussion.repositories

import ph.edu.auf.apidiscussion.constants.Api
import ph.edu.auf.apidiscussion.models.MainModel
import retrofit2.http.GET
import retrofit2.http.Query

interface Weather {

    @GET(Api.CURRENT_WEATHER)
    suspend fun getCurrentWeather(
        @Query("lat") lat : Double,
        @Query("lon") lon : Double,
        @Query("appid") appId: String,
        @Query("units") units: String
    ): MainModel

}