package com.estudiartablas.tablasmultiplicar.estudiartablasseleccion.ui

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.estudiartablas.tablasmultiplicar.estudiartablasseleccion.model.BotonResultado
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
open class EstudiarTablasSeleccionViewModel @Inject constructor() : ViewModel() {


    private var _myRespuesta = mutableStateListOf<BotonResultado>()
    val myRespuestas: List<BotonResultado> = _myRespuesta

    private val _activate = mutableStateListOf<Boolean>()
    val activate: List<Boolean> = _activate

    private val _textoResultado = mutableStateListOf<String>()
    val textoResultado: List<String> = _textoResultado

    private val _showDialog = MutableLiveData<Boolean>()
    val showDialog: LiveData<Boolean> = _showDialog

    fun addButtom(ind: Int) {

        val activate: Boolean
        _myRespuesta.add(BotonResultado())
        activate = ind == 1
        _activate.add(activate)
        _textoResultado.add("")
    }

    fun modificarActivado(index: Int) {
        (0..9).forEach { _activate[it] = false }
        _activate[index] = true
    }

    fun actualizarResultado(result: Int) {
        val index = _activate.indexOf(true)
        _textoResultado[index] = result.toString()
        modificarActivado(indiceSiguiente())
    }

    fun indiceSiguiente(): Int {
        var index = 0
        var fin = false
        while (_textoResultado[index] != "" && !fin) {
            index = (0..9).random()
//            Log.i("juanfran", (_textoResultado.subList(0,10).count { it == "" }).toString())
//            Log.i("juanfran", textoResultado.size.toString())
            if (_textoResultado.subList(0, 10).count { it == "" } == 0) {
                fin = true
            }
        }
        return index
    }

    fun iniciarTabla() {

        (0..9).map { _textoResultado[it] = "" }
        (0..9).map { _activate[it] = false }

        _activate[0] = true
    }

    fun comprobarResultado(tabla: Int) {
        var result: String
        var cont:Int = 0
        for (index in (0..9)) {
            result = _textoResultado[index]
            if (result == ((index + 1) * tabla).toString()) {
                cont += 1
            } else {
                _textoResultado[index] = ""

            }
            modificarActivado(indiceSiguiente())
        }
        if (cont == 10){
            _showDialog.value = true
        }
    }

    fun offResultDialog(navigationController: NavHostController) {
        navigationController.popBackStack()
        _showDialog.value = false
        iniciarTabla()
    }

    fun incrementaIndice(inc:Int){
        val index = _activate.indexOf(true) + inc
        when(index){
            -1 -> modificarActivado(9)
            in 0..9 -> modificarActivado(index)
            10 -> modificarActivado(0)
        }
    }

}






