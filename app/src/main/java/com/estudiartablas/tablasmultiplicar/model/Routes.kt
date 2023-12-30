package com.estudiartablas.tablasmultiplicar.model

sealed class Routes (val route:String) {
    object Presentacion:Routes("presentacion")
    object VerTablas:Routes("verTablas")
    object VerTablasSeleccion:Routes("verTablasSeleccion/{tabla}"){
        fun createTabla(tabla:Int) = "verTablasSeleccion/$tabla"
    }
    object EstudiarTablas:Routes("estudiarTablas")
    object EstudiarTablasSeleccion:Routes("estudiarTablasSeleccion/{tabla}"){
        fun createEstudiarTabla(tabla:Int) = "estudiarTablasSeleccion/$tabla"
    }
}