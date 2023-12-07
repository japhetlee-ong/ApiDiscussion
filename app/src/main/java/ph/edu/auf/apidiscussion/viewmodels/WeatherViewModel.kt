package ph.edu.auf.apidiscussion.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import ph.edu.auf.apidiscussion.constants.ApiState
import ph.edu.auf.apidiscussion.repositories.WeatherRepository

class WeatherViewModel(private var weatherRepository: WeatherRepository): ViewModel() {

    val weatherVMState: MutableStateFlow<ApiState> = MutableStateFlow(ApiState.Empty)

    fun getCurrentWeather(lat: Double, lon: Double) = viewModelScope.launch(Dispatchers.IO) {
        weatherVMState.value = ApiState.Loading
        weatherRepository.getCurrentWeather(lat,lon)
            .catch { e ->
                weatherVMState.value = ApiState.Failure(e)
            }.collect{ data ->
                weatherVMState.value = ApiState.Success(data)
            }
    }

}