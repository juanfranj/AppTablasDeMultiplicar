package com.estudiartablas.tablasmultiplicar.estudiartablasseleccion.model


import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.estudiartablas.tablasmultiplicar.estudiartablasseleccion.ui.EstudiarTablasSeleccionViewModel
import com.estudiartablas.tablasmultiplicar.ui.theme.Boton
import com.estudiartablas.tablasmultiplicar.ui.theme.cardPresentation

class BotonRespuestas(val tabla:Int) {

    private val aux: List<Int> = (1..10).shuffled()
    private val myResult: List<Int> = aux.map { it * tabla }

    @Composable
    fun CrearBoton(
        modifier: Modifier,
        result: Int,
        estudiarTablasViewModel: EstudiarTablasSeleccionViewModel,
        indice: Int
    ) {


        val size = if(result>=100) 22.sp else 24.sp
        Button(
            onClick = { estudiarTablasViewModel.actualizarResultado(result)}, shape = MaterialTheme.shapes.small,
            colors = ButtonDefaults.buttonColors(
                containerColor = Boton,
                contentColor = Color.White,
                disabledContentColor = cardPresentation
            ), modifier = modifier
                .padding(2.dp),
            contentPadding = PaddingValues(4.dp)

        ) {

            Text(
                text = "${result}",
                fontSize = size,
                fontWeight = FontWeight.Bold,
                )
        }
    }
}