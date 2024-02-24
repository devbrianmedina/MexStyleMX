package com.example.mexstylemx.models

import java.io.Serializable

data class Product(
    val id:Int,
    val imageResId: Int, // ID del recurso de imagen
    val name: String,
    val description: String,
    val sku: String,
    val price: Double,
    val options: HashMap<String, List<String>>
) : Serializable