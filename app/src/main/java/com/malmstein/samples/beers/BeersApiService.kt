package com.malmstein.samples.beers

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface BeersApiService {

    @GET("beers")
    fun beers(): Call<List<Beer>>

    @GET("beers/{beerId}")
    fun beerById(@Path("beerId") beerId: Int): Call<Beer>

    companion object Factory {

        val BASE_URL = "http://10.1.1.166:8080/api/"

        fun create(): BeersApiService {

            val retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(MoshiConverterFactory.create())
                    .build()

            return retrofit.create(BeersApiService::class.java);
        }
    }

}