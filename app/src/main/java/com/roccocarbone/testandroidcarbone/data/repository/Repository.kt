package com.roccocarbone.testandroidcarbone.data.repository


import com.roccocarbone.testandroidcarbone.data.models.Media
import com.roccocarbone.testandroidcarbone.data.network.RetrofitClient

class Repository {
    private val api = RetrofitClient.api

    suspend fun fetchMedia(): List<Media> {
        return api.fetchMedia().content
    }


}