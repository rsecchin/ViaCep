package com.ricardosecchin.primecep.model

data class CEP (
    var cep: String,
    var logradouro: String,
    var complemento: String,
    var bairro: String,
    var localidade: String,
    var uf: String
)