package com.roccocarbone.testandroidcarbone.data.models

import com.google.gson.annotations.SerializedName

data class MediaResponse(
    val status: Boolean,
    val lang: String,
    val content: List<Media>
)

data class Media(
    @SerializedName("mediaId") val mediaId: Int,
    @SerializedName("mediaUrl") val mediaUrl: String,
    @SerializedName("mediaUrlBig") val mediaUrlBig: String,
    @SerializedName("mediaType") val mediaType: String,
    @SerializedName("mediaDate") val mediaDate: MediaDateModel,
    @SerializedName("mediaTitleCustom") val mediaTitleCustom: String,
)

data class MediaDateModel (
    @SerializedName("dateString") val dateString: String,
    @SerializedName("year") val year: String,
)