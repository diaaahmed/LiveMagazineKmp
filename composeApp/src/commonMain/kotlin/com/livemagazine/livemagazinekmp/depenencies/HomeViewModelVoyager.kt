package com.livemagazine.livemagazinekmp.depenencies

import androidx.lifecycle.viewModelScope
import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

private const val TAG = "HomeViewModelVoyager"


class HomeViewModelVoyager(
    private val serviceRepo: ServiceRepo

): ScreenModel {

    private var _productTitle: MutableStateFlow<Resource<List<BaseResponseItem>>>
            = MutableStateFlow(Resource.Empty())

    val productTitle: StateFlow<Resource<List<BaseResponseItem>>> = _productTitle

    fun getProducts()
    {
        screenModelScope.launch {
            serviceRepo.getProducts()
                .collect{response->
                    when(response)
                    {
                        is Resource.Empty -> {
                            _productTitle.update { Resource.Empty() }

                        }
                        is Resource.Error -> {
                            _productTitle.update { Resource.Error(response.message.toString()) }

                        }
                        is Resource.Loading -> {
                            _productTitle.update { Resource.Loading() }

                        }
                        is Resource.Success -> {
                            _productTitle.update { Resource.Success(response.data) }
                        }
                    }
                }
        }
    }

    override fun onDispose() {
        super.onDispose()
        android.util.Log.d(TAG, "onDispose: ")
    }
}