package br.com.chckpoint_infinity_3sir.model

import java.io.Serializable

data class Filme(
    val idFilme: Int,
    val nome: String,
    val preco: Double,
    val produtora: String,
    val descricao: String
):Serializable




