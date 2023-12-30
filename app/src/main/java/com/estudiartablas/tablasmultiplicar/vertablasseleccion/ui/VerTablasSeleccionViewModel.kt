package com.estudiartablas.tablasmultiplicar.vertablasseleccion.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class VerTablasSeleccionViewModel @Inject constructor() : ViewModel() {


    private val _showResult = MutableLiveData<Boolean>()
    val showResult: LiveData<Boolean> = _showResult

    private val _result = MutableLiveData<String>()
    val result:LiveData<String> = _result

    private val _textButtom = MutableLiveData<String>()
    val textButton:LiveData<String> = _textButtom


    fun onShowResult(showResult: Boolean) {
        _showResult.value = !showResult
    }

    fun onResult(result: String) {
        _result.value = result
    }

    fun onButtonResult(text: String) {
        _textButtom.value =  text
    }

}