package com.livemagazine.livemagazinekmp.depenencies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MyViewModel(
    private val serviceRepo: ServiceRepo
) : ViewModel()
{
    private var _productTitle:MutableStateFlow<Resource<List<BaseResponseItem>>>
    = MutableStateFlow(Resource.Empty())

    val productTitle:StateFlow<Resource<List<BaseResponseItem>>> = _productTitle

    fun getProducts()
    {
        viewModelScope.launch {
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
}