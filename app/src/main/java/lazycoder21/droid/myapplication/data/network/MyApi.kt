package lazycoder21.droid.myapplication.data.network

import lazycoder21.droid.myapplication.model.PixelBay
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MyApi {

    @GET("api/")
    suspend fun getItems(
        @Query("key") key : String = "21828675-73538776f3bf54d088e9e7cf8",
    ) : Response<PixelBay>

    companion object {
        const val BASE_url = "https://pixabay.com/"
    }
}