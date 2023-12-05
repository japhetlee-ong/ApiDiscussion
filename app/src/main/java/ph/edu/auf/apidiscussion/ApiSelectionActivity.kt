package ph.edu.auf.apidiscussion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import ph.edu.auf.apidiscussion.databinding.ActivityApiSelectionBinding

class ApiSelectionActivity : AppCompatActivity(), OnClickListener {
    private lateinit var binding: ActivityApiSelectionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityApiSelectionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnQuotesApi.setOnClickListener(this)
        binding.btnWeatherApi.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0!!.id){
            (R.id.btn_quotes_api)->{
                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
            }
            (R.id.btn_weather_api)->{
                val intent = Intent(this,WeatherActivity::class.java)
                startActivity(intent)
            }
        }
    }
}