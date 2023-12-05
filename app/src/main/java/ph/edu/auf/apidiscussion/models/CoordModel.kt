package ph.edu.auf.apidiscussion.models

import com.google.gson.annotations.SerializedName

data class CoordModel(
    @SerializedName("lon" )
    var lon : Double? = null,
    @SerializedName("lat" )
    var lat : Double? = null
)
