package com.example.testchucknorris.mainModule.viewModel

import androidx.lifecycle.*
import com.example.testchucknorris.common.entidies.DetailJoker
import com.example.testchucknorris.mainModule.model.MainRepository
import kotlinx.coroutines.launch

class JokerViewModel: ViewModel() {
    private val mainRepository = MainRepository()

    private val _resultJoker = MutableLiveData<DetailJoker>()
    val resultJoker: LiveData<DetailJoker> get() = _resultJoker

    fun getDetailJoker(category: String) {
        viewModelScope.launch {
            val newResultJoker = mainRepository.invokeDetailJoker(category)
            _resultJoker.value = newResultJoker
        }
    }
}