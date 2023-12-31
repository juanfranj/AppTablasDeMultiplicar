package com.estudiartablas.tablasmultiplicar.estudiartablasseleccion.ui

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.estudiartablas.tablasmultiplicar.estudiartablasseleccion.model.BotonResultado
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
open class EstudiarTablasSeleccionViewModel @Inject constructor() : ViewModel() {

//    private val _myResult = mutableListOf<BotonRespuestas>()
//    val myResult:List<BotonRespuestas> = _myResult

    private val _myRespuesta = mutableStateListOf<BotonResultado>()
    val myRespuestas: List<BotonResultado> = _myRespuesta

//    private val _activate = MutableLiveData<Boolean>()
//    val activate: LiveData<Boolean> = _activate

    private val _activate = mutableStateListOf<Boolean>()
    val activate: List<Boolean> = _activate


    fun addButtom() {
        _myRespuesta.add(BotonResultado())
        _activate.add(false)
    }

    fun modificarActivado(index:Int) {
        (0..9).forEach { _activate[it] = false }
        _activate[index] = true
    }


}

