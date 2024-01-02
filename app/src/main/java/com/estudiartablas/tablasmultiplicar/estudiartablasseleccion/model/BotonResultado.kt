package com.estudiartablas.tablasmultiplicar.estudiartablasseleccion.model

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.estudiartablas.tablasmultiplicar.estudiartablasseleccion.ui.EstudiarTablasSeleccionViewModel
import com.estudiartablas.tablasmultiplicar.ui.theme.Boton
import com.estudiartablas.tablasmultiplicar.ui.theme.Fondo
import com.estudiartablas.tablasmultiplicar.ui.theme.cardPresentation
import com.estudiartablas.tablasmultiplicar.ui.theme.disabledBoton

class BotonResultado() {

    @Composable
    fun CrearBoton(estudiarTablasSeleccionViewModel: EstudiarTablasSeleccionViewModel, index:Int){

        val activado: Boolean = estudiarTablasSeleccionViewModel.activate[index]
        val textoResultado:String = estudiarTablasSeleccionViewModel.textoResultado[index]

        Button(
            modifier = Modifier.height(38.dp),
            onClick = { /*TODO*/ },
            //border = BorderStroke(2.dp, Color.Black),
            shape = MaterialTheme.shapes.small,
            colors = ButtonDefaults.buttonColors(
                containerColor = disabledBoton,
                contentColor = Color.White,
                disabledContentColor = Color.Gray,
                disabledContainerColor = cardPresentation
            ),
            enabled = activado,
            contentPadding = PaddingValues(2.dp)
        ) {
            Text(
                text = "${textoResultado}",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
            )
        }
    }


}