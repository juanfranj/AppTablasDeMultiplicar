package com.estudiartablas.tablasmultiplicar.estudiartablasseleccion.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavHostController
import com.estudiartablas.tablasmultiplicar.R
import com.estudiartablas.tablasmultiplicar.estudiartablasseleccion.model.BotonRespuestas
import com.estudiartablas.tablasmultiplicar.estudiartablasseleccion.model.BotonResultado
import com.estudiartablas.tablasmultiplicar.ui.theme.Boton
import com.estudiartablas.tablasmultiplicar.ui.theme.Fondo
import com.estudiartablas.tablasmultiplicar.ui.theme.cardPresentation

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EstudiarTablasSeleccionScreen(
    estudiarTablasViewModel: EstudiarTablasSeleccionViewModel,
    navigationController: NavHostController,
    tabla: Int
) {
    Scaffold() {
        it

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Fondo),
            verticalArrangement = Arrangement.Top,
        ) {
            val showResult: Boolean by estudiarTablasViewModel.showDialog.observeAsState(initial = false)

            HeadEstudiar(
                Modifier.align(Alignment.CenterHorizontally),
                tabla,
                navigationController,
                estudiarTablasViewModel
            )
            BodyEstudiar(
                Modifier.align(Alignment.CenterHorizontally),
                tabla,
                estudiarTablasViewModel
            )
            FooterEstudiar(tabla, estudiarTablasViewModel)
            ResultDialog(show = showResult) { estudiarTablasViewModel.offResultDialog(navigationController) }

        }
    }
}

@Composable
fun FooterEstudiar(
    tabla: Int,
    estudiarTablasViewModel: EstudiarTablasSeleccionViewModel,

    ) {
    val aux: List<Int> = (1..10).shuffled()
    val myResult: List<Int> = (1..10).map { it * tabla }



    Row(modifier = Modifier.padding(8.dp)) {
        Column(Modifier.weight(0.7f)) {
            Row {
                (0..4).forEach { indice ->
                    BotonRespuestas(tabla).CrearBoton(
                        Modifier.weight(0.2f),
                        myResult[indice],
                        estudiarTablasViewModel,
                        indice
                    )
                }
            }
            Row {
                (5..9).forEach { indice ->
                    BotonRespuestas(tabla).CrearBoton(
                        Modifier.weight(0.2f),
                        myResult[indice],
                        estudiarTablasViewModel,
                        indice
                    )
                }

            }

        }
        Button(
            onClick = { estudiarTablasViewModel.comprobarResultado(tabla) },
            shape = MaterialTheme.shapes.small,
            colors = ButtonDefaults.buttonColors(
                containerColor = Boton,
                contentColor = Color.White,
                disabledContentColor = cardPresentation
            ),
            modifier = Modifier
                .padding(2.dp)
                .weight(0.3f)
                .fillMaxWidth()
                .height(100.dp),
            contentPadding = PaddingValues(8.dp)
        ) {
            Text(
                text = stringResource(R.string.selecionar_calcular),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
            )

        }
    }
}


@Composable
fun BodyEstudiar(
    modifier: Modifier,
    tabla: Int,
    estudiarTablasViewModel: EstudiarTablasSeleccionViewModel
) {
    val index: List<Int> = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val listResultado: List<BotonResultado> = estudiarTablasViewModel.myRespuestas

    Card(
        modifier = Modifier
            .padding(vertical = 16.dp, horizontal = 24.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = cardPresentation,
            contentColor = Color.Gray
        ),
        border = BorderStroke(1.dp, Color.LightGray)
    ) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(2.dp),
            modifier = Modifier.padding(8.dp),
            content = {
                items(index) { ind ->
                    estudiarTablasViewModel.addButtom(ind)
                    ItemRow(index = ind, modifier, tabla, listResultado, estudiarTablasViewModel)
                }

            })
    }

}

@Composable
fun HeadEstudiar(
    modifier: Modifier,
    num: Int,
    navigationController: NavHostController,
    estudiarTablasViewModel: EstudiarTablasSeleccionViewModel
) {
    //val num: Int = 6
    Card(
        modifier = Modifier.padding(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.LightGray,
            contentColor = Color.White
        ),
        border = BorderStroke(1.dp, Color.LightGray)
    ) {
        Row() {
            Text(
                text = "Tabla del $num",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                modifier = modifier
                    .padding(24.dp)
                    .weight(1f)

            )
            IconButton(
                onClick = {
                    navigationController.popBackStack()
                    estudiarTablasViewModel.iniciarTabla()
                },
                modifier.padding(end = 8.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "volver",
                    modifier = Modifier.fillMaxHeight()
                )
            }
        }

    }
}


@Composable
fun ItemRow(
    index: Int,
    modifier: Modifier,
    num: Int,
    botonResultado: List<BotonResultado>,
    estudiarTablasViewModel: EstudiarTablasSeleccionViewModel
) {
    //val num: Int = 6

    Row() {
        Spacer(modifier = Modifier.weight(0.1f))

        Box(
            Modifier
                .weight(.2f)
        ) {
            Text(text = " $num ", fontSize = 28.sp, fontWeight = FontWeight.Bold)
        }
        Box(
            Modifier
                .weight(.2f)
        ) {
            Text(text = " x ", fontSize = 28.sp, fontWeight = FontWeight.Bold)
        }
        Box(
            Modifier
                .weight(.2f)
        ) {
            Text(text = " $index ", fontSize = 28.sp, fontWeight = FontWeight.Bold)
        }
        Box(
            Modifier
                .weight(.2f)
        ) {
            Text(text = " = ", fontSize = 28.sp, fontWeight = FontWeight.Bold)
        }
        Box(
            Modifier
                .weight(.2f)

        ) {
//
            botonResultado[index - 1].CrearBoton(estudiarTablasViewModel, index - 1)

        }
        Spacer(modifier = Modifier.weight(0.1f))

    }
}

@Composable
fun ResultDialog(show: Boolean, onDismiss: () -> Unit) {
    if (show) {
        Dialog(
            onDismissRequest = { onDismiss() },
            properties = DialogProperties(dismissOnBackPress = false, dismissOnClickOutside = false)
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.LightGray,
                    contentColor = Color.White
                ),
                border = BorderStroke(1.dp, Color.LightGray)
            ) {
                Column(
                    Modifier
                        .padding(24.dp)
                ) {
                    Text(
                        text = stringResource(id = R.string.texto_dialogo),
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        fontSize = 28.sp
                    )
                    Button(
                        onClick = { onDismiss() }, modifier = Modifier
                            .fillMaxWidth()
                            .padding(24.dp),
                        shape = MaterialTheme.shapes.small,
                    ) {
                        Text(text = stringResource(id = R.string.boton_dialogo), fontSize = 28.sp, fontWeight = FontWeight.Bold)
                    }
                }
            }

        }
    }
}

