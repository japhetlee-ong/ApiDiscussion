package ph.edu.auf.apidiscussion.models

import com.google.gson.annotations.SerializedName

data class SysModel (
    @SerializedName("type")
    var type: Int?= null,
    @SerializedName("id")
    var id: Int?= null,
    @SerializedName("country")
    var country : String? = null,
    @SerializedName("sunrise")
    var sunrise : Int?= null,
    @SerializedName("sunset" )
    var sunset  : Int?= null
)