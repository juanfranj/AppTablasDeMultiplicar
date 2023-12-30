package com.estudiartablas.tablasmultiplicar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.estudiartablas.tablasmultiplicar.estudiartablas.ui.EstudiarTablasScreen
import com.estudiartablas.tablasmultiplicar.estudiartablas.ui.EstudiarTablasViewModel
import com.estudiartablas.tablasmultiplicar.estudiartablasseleccion.ui.EstudiarTablasSeleccionScreen
import com.estudiartablas.tablasmultiplicar.estudiartablasseleccion.ui.EstudiarTablasSeleccionViewModel
import com.estudiartablas.tablasmultiplicar.model.Routes
import com.estudiartablas.tablasmultiplicar.presentacion.ui.PresentacionScreen
import com.estudiartablas.tablasmultiplicar.presentacion.ui.PresentacionViewModel
import com.estudiartablas.tablasmultiplicar.ui.theme.TablasMultiplicarTheme
import com.estudiartablas.tablasmultiplicar.vertablas.ui.VerTablasScreen
import com.estudiartablas.tablasmultiplicar.vertablas.ui.VerTablasViewModel
import com.estudiartablas.tablasmultiplicar.vertablasseleccion.ui.VerTablasSeleccionScreen
import com.estudiartablas.tablasmultiplicar.vertablasseleccion.ui.VerTablasSeleccionViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val tablasViewModel: PresentacionViewModel by viewModels()
    private val verTablasViewModel: VerTablasViewModel by viewModels()
    private val verTablasSeleccionViewModel: VerTablasSeleccionViewModel by viewModels()
    private val estudiarTablasViewModel: EstudiarTablasViewModel by viewModels()
    private val estudiarTablasSeleccionViewModel: EstudiarTablasSeleccionViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TablasMultiplicarTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navigationController = rememberNavController()
                    NavHost(
                        navController = navigationController,
                        startDestination = Routes.Presentacion.route,

                        ) {
                        composable(Routes.Presentacion.route) {
                            PresentacionScreen(
                                tablasViewModel,
                                navigationController
                            )
                        }
                        composable(Routes.VerTablas.route) {
                            VerTablasScreen(
                                verTablasViewModel,
                                navigationController
                            )
                        }
                        composable(
                            Routes.VerTablasSeleccion.route,
                            arguments = listOf(navArgument("tabla") { type = NavType.IntType })
                        ) { backStackEntry ->
                            VerTablasSeleccionScreen(
                                verTablasSeleccionViewModel,
                                navigationController,
                                backStackEntry.arguments?.getInt("tabla") ?: 0
                            )
                        }
                        composable(Routes.EstudiarTablas.route) {
                            EstudiarTablasScreen(estudiarTablasViewModel, navigationController)
                        }
                        composable(
                            Routes.EstudiarTablasSeleccion.route,
                            arguments = listOf(navArgument("tabla") {type = NavType.IntType})
                        ) { backStackEntry ->
                            EstudiarTablasSeleccionScreen(
                                estudiarTablasSeleccionViewModel,
                                navigationController,
                                backStackEntry.arguments?.getInt("tabla") ?: 0
                            )

                        }

                    }


                }
            }
        }
    }
}

