package ph.edu.auf.apidiscussion.models

import com.google.gson.annotations.SerializedName

data class WindModel(
    @SerializedName("speed")
    var speed : Double? = null,
    @SerializedName("deg")
    var deg: Int?= null
)
