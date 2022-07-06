package lazycoder21.droid.myapplication.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import lazycoder21.droid.myapplication.data.network.MyApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApiModule {

    @Provides
    @Singleton
    fun provideMyApi() : MyApi = Retrofit.Builder()
        .baseUrl(MyApi.BASE_url)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create()
}