package com.livemagazine.livemagazinekmp.depenencies

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CategoryData(
    @SerialName("created_at")
    val createdAt: String = "",
    val icon: String = "",
    val id: Int = 0,
    @SerialName("name_ar")
    val nameAr: String= "",
    @SerialName("name_en")
    val nameEn: String = "",
    val sort: Int =0,
    @SerialName("staff_id")
    val staffId: Int = 0,
    val status: Int = 0,
    @SerialName("updated_at")
    val updatedAt: String = ""
)