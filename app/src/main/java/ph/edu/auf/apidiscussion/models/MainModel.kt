package ph.edu.auf.apidiscussion.models

import com.google.gson.annotations.SerializedName

data class MainModel (
    @SerializedName("coord")
    var coord: CoordModel? = CoordModel(),
    @SerializedName("weather")
    var weather: ArrayList<WeatherModel> = arrayListOf(),
    @SerializedName("base")
    var base: String?= null,
    @SerializedName("main")
    var main: MainWeatherModel? = MainWeatherModel(),
    @SerializedName("visibility")
    var visibility : Int? = null,
    @SerializedName("wind")
    var wind: WindModel? = WindModel(),
    @SerializedName("clouds")
    var clouds: CloudsModel? = CloudsModel(),
    @SerializedName("dt")
    var dt: Long? = null,
    @SerializedName("sys")
    var sys: SysModel? = SysModel(),
    @SerializedName("timezone")
    var timezone: Int? = null,
    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("cod")
    var cod: Int? = null
)