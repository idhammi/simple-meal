package com.example.simplemeal.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.simplemeal.data.remote.ApiClient
import com.example.simplemeal.data.remote.response.CategoriesItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val _categories = MutableStateFlow<List<CategoriesItem>>(emptyList())
    val categories = _categories

    private val apiClient = ApiClient.service

    init {
        fetchCategories()
    }

    private fun fetchCategories() {
        viewModelScope.launch {
            try {
                val response = apiClient.getCategories()
                _categories.value = response.categories
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}