package ph.edu.auf.apidiscussion.models

import com.google.gson.annotations.SerializedName

data class CloudsModel(
    @SerializedName("all")
    var all : Int? = null
)