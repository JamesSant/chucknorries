package com.example.testchucknorris.mainModule.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testchucknorris.mainModule.model.MainRepository
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    private val mainRepository = MainRepository()

    private val _result = MutableLiveData<List<String>>()
    val result: LiveData<List<String>> get() = _result

    private val loader = MutableLiveData<Boolean>()
    fun getLoader() = loader

    fun getCategoriesList() {
        viewModelScope.launch {
            try {
                val newResult = mainRepository.invokeCategories()
                _result.value = newResult
            } catch (e: Exception) {

            } finally {
                loader.value = true
            }
        }
    }
}