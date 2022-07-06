package lazycoder21.droid.myapplication.data.repository

import lazycoder21.droid.myapplication.model.PixelBay
import lazycoder21.droid.myapplication.data.network.MyApi
import javax.inject.Inject

class PixelRepository @Inject constructor(
    private val myApi: MyApi
) {

    suspend fun getPixelsImage(): PixelBay? {
        val response = myApi.getItems()
        if (response.isSuccessful) {
            return response.body()
        }
        return null
    }
}