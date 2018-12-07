package app.woovictory.seminar6_23th.network

import android.app.Application
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by VictoryWoo
 */
class ApplicationController : Application(){

    private val baseUrl = "http://bghgu.tk:8080/"
    lateinit var networkService: NetworkService

    companion object {
        lateinit var instance : ApplicationController
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        buildNetwork()
    }

    fun buildNetwork(){

        var gson = GsonBuilder().setLenient().create()
        var builder = Retrofit.Builder()
        var retrofit = builder
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        networkService = retrofit.create(NetworkService::class.java)
    }

}