package com.livemagazine.livemagazinekmp.depenencies

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.url
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

interface ServiceRepo {


    suspend fun getProducts(): Flow<Resource<List<BaseResponseItem>>>
}

class ServiceRepoImpl(
    private val httpClient: HttpClient

) : ServiceRepo {
    override suspend fun getProducts(): Flow<Resource<List<BaseResponseItem>>> = flow{

        emit(Resource.Loading())

        try {

            val getProducts = httpClient.get{
                url(HttpRoutes.products)
            }.body<List<BaseResponseItem>>()

            emit(Resource.Success(getProducts))

        } catch (e: Exception) {
            emit(Resource.Error(e.message.toString()))
        }
    }
}