package com.brian.kaizn.features.habit_history.domain.model

import com.brian.kaizn.data.utils.Rezults

sealed class KaiznUiEvents{
    //when I specify generic type <T>, I get an error when declaring this property in the viewmodel class:
    //one type argument expected for class KaiznUiEvent<T>
    data class Error(val message: String? = null) : KaiznUiEvents()
    data class Success(val data: Long) : KaiznUiEvents()

}