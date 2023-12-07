package ph.edu.auf.apidiscussion.viewmodels.factories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ph.edu.auf.apidiscussion.repositories.WeatherRepository
import ph.edu.auf.apidiscussion.viewmodels.WeatherViewModel

@Suppress("UNCHECKED_CAST")
class WeatherViewModelFactory(private val weatherRepository: WeatherRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return WeatherViewModel(weatherRepository) as T
    }
}