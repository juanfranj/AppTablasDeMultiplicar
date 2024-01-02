package com.estudiartablas.tablasmultiplicar.vertablasseleccion.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.estudiartablas.tablasmultiplicar.R
import com.estudiartablas.tablasmultiplicar.ui.theme.Boton
import com.estudiartablas.tablasmultiplicar.ui.theme.Fondo
import com.estudiartablas.tablasmultiplicar.ui.theme.cardPresentation

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VerTablasSeleccionScreen(
    verTablasSeleccionViewModel: VerTablasSeleccionViewModel,
    navigationController: NavHostController,
    tabla: Int
) {
    Scaffold() { innerPadding ->
        innerPadding
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .background(Fondo),
            verticalArrangement = Arrangement.Top,
        ) {
            HeadVer(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                navigationController = navigationController,
                tabla = tabla,
                verTablasSeleccionViewModel
            )
            crearTabla(
                tabla,
                Modifier.align(Alignment.CenterHorizontally),
                verTablasSeleccionViewModel
            )

        }

    }
}

@Composable
fun crearTabla(
    tabla: Int,
    modifier: Modifier,
    verTablasSeleccionViewModel: VerTablasSeleccionViewModel
) {
    val showResult: Boolean by verTablasSeleccionViewModel.showResult.observeAsState(initial = false)
    val result: String by verTablasSeleccionViewModel.result.observeAsState(initial = "")
    val textButtom: String by verTablasSeleccionViewModel.textButton.observeAsState(
        initial = stringResource(
            R.string.ver_resultado
        )
    )
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp, horizontal = 24.dp),
        colors = CardDefaults.cardColors(
            containerColor = cardPresentation,
            contentColor = Color.Gray
        ),
    ) {
        for (num in (1..10)) {
            Row(modifier) {
                Spacer(modifier = Modifier.weight(.1f))
                Box(Modifier.weight(.2f)) {
                    Text(
                        text = " $tabla ",
                        modifier = modifier.padding(vertical = 2.dp),
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                Box(Modifier.weight(.2f)) {
                    Text(
                        text = " x ",
                        modifier = modifier.padding(vertical = 2.dp),
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                Box(Modifier.weight(.2f)) {
                    Text(
                        text = " $num ",
                        modifier = modifier.padding(vertical = 2.dp),
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                Box(Modifier.weight(.2f)) {
                    Text(
                        text = " = ",
                        modifier = modifier.padding(vertical = 2.dp),
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                if (showResult) {
                    verTablasSeleccionViewModel.onResult("${tabla * num}")
                    verTablasSeleccionViewModel.onButtonResult(stringResource(R.string.ocultar_resultado))
                } else {
                    verTablasSeleccionViewModel.onResult("")
                    verTablasSeleccionViewModel.onButtonResult(stringResource(R.string.ver_resultado))
                }
                Box(Modifier.weight(.2f)) {
                    Text(
                        text = result,
                        modifier = modifier.padding(vertical = 2.dp),
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                Spacer(modifier = Modifier.weight(.1f))

            }

        }

    }
    Button(
        onClick = { verTablasSeleccionViewModel.onShowResult(showResult) }, modifier = Modifier
            .fillMaxWidth()
            .height(64.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Boton,
            contentColor = Color.White
        ),
        shape = MaterialTheme.shapes.small
    ) {
        Text(text = textButtom, fontSize = 24.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun HeadVer(
    modifier: Modifier,
    navigationController: NavHostController,
    tabla: Int,
    verTablasSeleccionViewModel: VerTablasSeleccionViewModel
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
        Row {
            Text(
                text = stringResource(R.string.ver_tabla_seleccion) + " $tabla",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                modifier = modifier
                    .padding(24.dp)
                    .weight(1f)

            )
            IconButton(
                onClick = {
                    verTablasSeleccionViewModel.onResult("")
                    navigationController.popBackStack()
                    verTablasSeleccionViewModel.onShowResult(true)
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
