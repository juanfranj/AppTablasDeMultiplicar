package com.estudiartablas.tablasmultiplicar.presentacion.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.estudiartablas.tablasmultiplicar.R
import com.estudiartablas.tablasmultiplicar.model.Routes
import com.estudiartablas.tablasmultiplicar.ui.theme.Boton
import com.estudiartablas.tablasmultiplicar.ui.theme.cardPresentation

@Composable
fun PresentacionScreen(
    presentacionViewModel: PresentacionViewModel,
    navigationController: NavHostController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 35.dp, bottom = 35.dp, start = 8.dp, end = 8.dp),
        verticalArrangement = Arrangement.Top
    ) {
        Head(Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.size(75.dp))
        Body(navigationController)
    }

}


@Composable
fun Head(modifier: Modifier) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 24.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.LightGray,
            contentColor = Color.White
        ),
        border = BorderStroke(1.dp, Color.LightGray)
    ) {
        Text(
            text = stringResource(R.string.app_name),
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            modifier = modifier.padding(24.dp)

        )
    }

}



@Composable
fun Body(navigationController: NavHostController) {

    Card(
        modifier = Modifier
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = cardPresentation
        ),
        border = BorderStroke(1.dp, Color.LightGray)
    ) {

        Spacer(modifier = Modifier.size(16.dp))

        Button(
            onClick = { navigationController.navigate(Routes.VerTablas.route)},
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .height(100.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Boton,
                contentColor = Color.White
            ),
            shape = MaterialTheme.shapes.small
        ) {
            Text(text = stringResource(R.string.verTablas), fontSize = 24.sp, fontWeight = FontWeight.ExtraBold)
        }
        Spacer(modifier = Modifier.size(16.dp))
        Button(
            onClick = { navigationController.navigate(Routes.EstudiarTablas.route) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .height(100.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Boton,
                contentColor = Color.White
            ),
            shape = MaterialTheme.shapes.small
        ) {
            Text(text = stringResource(R.string.estudiarTablas), fontSize = 24.sp, fontWeight = FontWeight.ExtraBold)
        }
        Spacer(modifier = Modifier.size(16.dp))
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .height(100.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Boton,
                contentColor = Color.White
            ),
            shape = MaterialTheme.shapes.small
        ) {
            Text(text = stringResource(R.string.repasarTablas), fontSize = 24.sp, fontWeight = FontWeight.ExtraBold)
        }
        Spacer(modifier = Modifier.size(16.dp))


    }

}

