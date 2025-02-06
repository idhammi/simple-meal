package com.example.simplemeal.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.simplemeal.data.remote.ApiClient
import com.example.simplemeal.data.remote.response.CategoriesItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery

    private val categories = mutableListOf<CategoriesItem>()

    private val _categoriesFiltered = MutableStateFlow<List<CategoriesItem>>(emptyList())
    val categoriesFiltered: StateFlow<List<CategoriesItem>> = _categoriesFiltered

    private val apiClient = ApiClient.service

    init {
        fetchCategories()
    }

    private fun fetchCategories() {
        viewModelScope.launch {
            try {
                val response = apiClient.getCategories()
                categories.clear()
                categories.addAll(response.categories)
                _categoriesFiltered.value = response.categories
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun searchCategories(query: String) {
        _searchQuery.value = query
        _categoriesFiltered.value = categories.filter {
            it.strCategory.contains(query, ignoreCase = true)
        }
    }
}