package lazycoder21.droid.myapplication.model


import com.google.gson.annotations.SerializedName

data class PixelBay(
    @SerializedName("hits")
    val hits: List<Hit>,
    @SerializedName("total")
    val total: Int,
    @SerializedName("totalHits")
    val totalHits: Int
)