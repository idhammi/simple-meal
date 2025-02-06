package com.example.simplemeal.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.simplemeal.data.remote.response.CategoriesItem
import com.example.simplemeal.ui.MainViewModel

@Composable
fun HomeScreen(modifier: Modifier = Modifier, viewModel: MainViewModel) {
    val categories by viewModel.categories.collectAsState()

    Scaffold(modifier = modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            ListCategories(categories)
        }
    }
}

@Composable
fun ListCategories(categories: List<CategoriesItem>) {
    LazyColumn(
        modifier = Modifier.graphicsLayer { renderEffect = null },
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(categories) { item ->
            ItemCategories(item)
        }
    }
}

@Composable
fun ItemCategories(item: CategoriesItem) {
    Card(
        onClick = { /* TODO */ }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = item.strCategoryThumb,
                contentDescription = "Meal Image",
                modifier = Modifier.size(64.dp)
            )
            Spacer(modifier = Modifier.size(16.dp))
            Text(
                text = item.strCategory
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreen_Preview() {
    val categories = listOf(
        CategoriesItem(
            strCategory = "Beef",
            strCategoryDescription = "Beef Description",
            idCategory = "1",
            strCategoryThumb = "Beef Thumb"
        ),
        CategoriesItem(
            strCategory = "Chicken",
            strCategoryDescription = "Chicken Description",
            idCategory = "2",
            strCategoryThumb = "Chicken Thumb"
        ),
        CategoriesItem(
            strCategory = "Dessert",
            strCategoryDescription = "Dessert Description",
            idCategory = "3",
            strCategoryThumb = "Dessert Thumb"
        ),
    )

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            ListCategories(categories)
        }
    }
}
