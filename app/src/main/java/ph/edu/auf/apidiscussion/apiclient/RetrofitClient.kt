package ph.edu.auf.apidiscussion.apiclient

import com.google.gson.GsonBuilder
import ph.edu.auf.apidiscussion.constants.Api
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private val GSON = GsonBuilder().setLenient().create()

    val retrofit : Retrofit by lazy{
        Retrofit.Builder()
            .baseUrl(Api.QUOTE_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GSON))
            .build()
    }

    val weatherRetrofit : Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(Api.WEATHER_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GSON))
            .build()
    }


}