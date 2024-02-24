package com.example.mexstylemx.models

import java.io.Serializable

data class CartProduct(
    val idProduct:Int,
    var quantity:Int,
    val options: HashMap<String, String>,
) : Serializable