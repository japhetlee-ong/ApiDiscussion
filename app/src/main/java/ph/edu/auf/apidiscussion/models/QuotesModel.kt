package ph.edu.auf.apidiscussion.models

import com.google.gson.annotations.SerializedName

data class QuotesModel (
    @SerializedName("count")
    var count:Int?= null,
    @SerializedName("totalCount")
    var totalCount: Int? = null,
    @SerializedName("page")
    var page: Int? = null,
    @SerializedName("totalPages")
    var totalPages:Int? = null,
    @SerializedName("lastItemIndex")
    var lastItemIndex : Int? = null,
    @SerializedName("results")
    var results: ArrayList<ResultsModel> = arrayListOf()
)