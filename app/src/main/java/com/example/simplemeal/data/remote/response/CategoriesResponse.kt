package com.example.simplemeal.data.remote.response

data class CategoriesResponse(
    val categories: List<CategoriesItem>
)

data class CategoriesItem(
    val strCategory: String,
    val strCategoryDescription: String,
    val idCategory: String,
    val strCategoryThumb: String
)
