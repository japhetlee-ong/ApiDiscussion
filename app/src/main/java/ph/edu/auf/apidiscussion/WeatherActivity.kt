package ph.edu.auf.apidiscussion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import ph.edu.auf.apidiscussion.constants.Api
import ph.edu.auf.apidiscussion.constants.ApiState
import ph.edu.auf.apidiscussion.databinding.ActivityWeatherBinding
import ph.edu.auf.apidiscussion.models.MainModel
import ph.edu.auf.apidiscussion.repositories.WeatherRepository
import ph.edu.auf.apidiscussion.viewmodels.WeatherViewModel
import ph.edu.auf.apidiscussion.viewmodels.factories.WeatherViewModelFactory
import java.text.SimpleDateFormat
import java.util.Locale

class WeatherActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWeatherBinding
    private lateinit var viewModel: WeatherViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWeatherBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this,
            WeatherViewModelFactory(WeatherRepository())
        )[WeatherViewModel::class.java]

        viewModel.getCurrentWeather(15.1463554,120.5245999)

        binding.cardWeather.visibility = View.GONE

        lifecycleScope.launch {
            viewModel.weatherVMState.collect{
                when(it){
                    is ApiState.Loading ->{
                        binding.animationView.visibility = View.VISIBLE
                    }
                    is ApiState.Success ->{
                        binding.cardWeather.visibility = View.VISIBLE
                        binding.animationView.visibility = View.GONE

                        val result = it.data as MainModel
                        setupView(result)
                    }
                    is ApiState.Failure ->{
                        it.e.printStackTrace()
                    }
                    is ApiState.Empty ->{
                        binding.cardWeather.visibility = View.GONE
                        binding.animationView.visibility = View.VISIBLE
                    }
                }
            }
        }

    }

    private fun setupView(data: MainModel){

        binding.txtWeatherType.text = data.weather[0].main
        binding.txtTemp.text = String.format("%s\u2103 ", data.main!!.temp)
        binding.txtFeelsTemp.text = String.format("%s℃ RealFeel", data.main!!.feelsLike)
        binding.txtDateTime.text = String.format("%s | %s",getDay(data.dt!!), getTime(data.dt!!))


        Glide.with(this)
            .load(Api.BASE_WEATHER_IMG_URL+data.weather[0].icon+"@2x.png")
            .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
            .override(200,200)
            .into(binding.imgWeather)

    }

    private fun getDay(timeStamp: Long): String{
        return SimpleDateFormat("EEEE", Locale.ENGLISH).format(timeStamp * 1000)
    }

    private fun getTime(timeStamp: Long): String{
        return SimpleDateFormat("hh:mm aa", Locale.ENGLISH).format(timeStamp * 1000)
    }
}