package com.estudiartablas.tablasmultiplicar.estudiartablasseleccion.model

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.estudiartablas.tablasmultiplicar.estudiartablasseleccion.ui.EstudiarTablasSeleccionViewModel
import com.estudiartablas.tablasmultiplicar.ui.theme.Boton
import com.estudiartablas.tablasmultiplicar.ui.theme.cardPresentation

class BotonResultado() {

    @Composable
    fun CrearBoton(estudiarTablasSeleccionViewModel: EstudiarTablasSeleccionViewModel, index:Int){
        val activado: Boolean = estudiarTablasSeleccionViewModel.activate[index]
        Button(
            modifier = Modifier.height(36.dp),
            onClick = { /*TODO*/ },
            //border = BorderStroke(2.dp, Color.Black),
            shape = MaterialTheme.shapes.small,
            colors = ButtonDefaults.buttonColors(
                containerColor = Boton,
                contentColor = Color.White,
                disabledContentColor = cardPresentation
            ),
            enabled = activado
        ) {
        }
    }


}