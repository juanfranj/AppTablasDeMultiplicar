package com.estudiartablas.tablasmultiplicar.estudiartablasseleccion.ui

import androidx.lifecycle.ViewModel
import com.estudiartablas.tablasmultiplicar.estudiartablasseleccion.model.BotonRespuestas
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EstudiarTablasSeleccionViewModel @Inject constructor(): ViewModel() {

    private val _myResult = mutableListOf<BotonRespuestas>()
    val myResult:List<BotonRespuestas> = _myResult
}