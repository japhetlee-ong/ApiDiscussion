package ph.edu.auf.apidiscussion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ph.edu.auf.apidiscussion.databinding.ActivityWeatherBinding
import java.text.SimpleDateFormat
import java.util.Locale

class WeatherActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWeatherBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWeatherBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun getDay(timeStamp: Long): String{
        return SimpleDateFormat("EEEE", Locale.ENGLISH).format(timeStamp * 1000)
    }

    private fun getTime(timeStamp: Long): String{
        return SimpleDateFormat("hh:mm aa", Locale.ENGLISH).format(timeStamp * 1000)
    }
}