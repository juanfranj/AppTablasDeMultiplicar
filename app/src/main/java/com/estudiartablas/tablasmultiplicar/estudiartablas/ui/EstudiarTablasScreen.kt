package com.estudiartablas.tablasmultiplicar.estudiartablas.ui

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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.estudiartablas.tablasmultiplicar.R
import com.estudiartablas.tablasmultiplicar.model.Routes
import com.estudiartablas.tablasmultiplicar.ui.theme.Boton
import com.estudiartablas.tablasmultiplicar.ui.theme.Fondo
import com.estudiartablas.tablasmultiplicar.ui.theme.TituloCard
import com.estudiartablas.tablasmultiplicar.ui.theme.cardPresentation


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EstudiarTablasScreen(
    EstudiarTablasViewModel: EstudiarTablasViewModel,
    navigationController: NavHostController
) {

    Scaffold(
//        topBar = {
//            MyTopAppBar()
//        },
    ) {
        it
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 8.dp, end = 8.dp)
                .background(Fondo),
            verticalArrangement = Arrangement.Top,

            ) {
            HeadVer(Modifier.align(Alignment.CenterHorizontally), navigationController)
            //Spacer(modifier = Modifier.size(12.dp))
            BodyVer(navigationController)
            EndVer()

        }
    }

}

@Composable
fun EndVer() {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = TituloCard,
            contentColor = Color.White
        ),
        border = BorderStroke(1.dp, Color.LightGray)
    ) {
        Box(contentAlignment = Alignment.CenterStart) {
            Text(
                text = stringResource(id = R.string.selecionar_estudiar),
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                color = Color.White,
                textAlign = TextAlign.Center
            )
        }
    }


}

@Composable
fun BodyVer(navigationController: NavHostController) {
    val tablas = listOf(2, 3, 4, 5, 6, 7, 8, 9, 10)
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 24.dp),
        colors = CardDefaults.cardColors(
            containerColor = cardPresentation,
            contentColor = Color.White
        ),
    ) {
        Spacer(modifier = Modifier.size(36.dp))
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement =
            Arrangement.spacedBy(16.dp), content = {
                items(tablas) { index ->
                    ItemVerTabla(num = index.toString(), navigationController)
                }
            }
        )
        Spacer(modifier = Modifier.size(36.dp))

    }

}

@Composable
fun HeadVer(modifier: Modifier, navigationController: NavHostController) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 24.dp),
        colors = CardDefaults.cardColors(
            containerColor = TituloCard,
            contentColor = Color.White
        ),
        border = BorderStroke(1.dp, Color.LightGray)
    ) {
        Row {
            Text(
                text = stringResource(R.string.estudiar_name),
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                modifier = modifier
                    .padding(24.dp)
                    .weight(1f)

            )
            IconButton(
                onClick = { navigationController.popBackStack() },
                modifier.padding(end = 8.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "volver",
                    modifier = Modifier.fillMaxSize()
                )
            }
        }

    }
}


@Composable
fun ItemVerTabla(num: String, navigationController: NavHostController) {
    Button(
        onClick = { navigationController.navigate(Routes.EstudiarTablasSeleccion.createEstudiarTabla(num.toInt())) },
        border = BorderStroke(2.dp, Color.LightGray),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
            .height(100.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Boton,
            contentColor = Color.White
        ),
        shape = MaterialTheme.shapes.small
    ) {
        Column() {
            Text(
                text = stringResource(R.string.boton_name),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 4.dp),
                fontSize = 16.sp,
                fontStyle = FontStyle.Italic
            )
            Text(
                text = num,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 4.dp),
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold
            )

        }

    }
}

