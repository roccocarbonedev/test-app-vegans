package com.roccocarbone.testandroidcarbone.data.network


import com.roccocarbone.testandroidcarbone.data.models.MediaResponse
import retrofit2.http.GET

interface MediaApi {

    @GET("test.json")
    suspend fun fetchMedia(): MediaResponse

}