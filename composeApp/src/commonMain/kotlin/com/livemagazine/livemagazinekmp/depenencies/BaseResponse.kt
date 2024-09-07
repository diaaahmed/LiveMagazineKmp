package com.livemagazine.livemagazinekmp.depenencies

import kotlinx.serialization.Serializable

@Serializable
data class BaseResponse(
    val baseResponseItem: List<BaseResponseItem>
)