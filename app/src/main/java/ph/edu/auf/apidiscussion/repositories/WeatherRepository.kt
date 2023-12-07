package ph.edu.auf.apidiscussion.repositories

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import ph.edu.auf.apidiscussion.apiclient.RetrofitClient
import ph.edu.auf.apidiscussion.constants.Api
import ph.edu.auf.apidiscussion.models.MainModel

class WeatherRepository {

    fun getCurrentWeather(lat: Double, lon: Double): Flow<MainModel> = flow {
        val r = RetrofitClient.weatherRetrofit.create(Weather::class.java).getCurrentWeather(lat,lon,Api.API_KEY,"metric")
        emit(r)
    }.flowOn(Dispatchers.IO)

}