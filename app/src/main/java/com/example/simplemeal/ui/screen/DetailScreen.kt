package com.example.simplemeal.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import kotlinx.serialization.Serializable

@Serializable
data class Detail(
    val name: String,
    val description: String,
    val image: String
)

@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    name: String,
    description: String,
    image: String
) {
    Scaffold { innerPadding ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            AsyncImage(
                model = image,
                contentDescription = name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
            )
            Text(
                modifier = Modifier.padding(horizontal = 16.dp),
                text = name
            )
            Text(
                modifier = Modifier.padding(horizontal = 16.dp),
                text = description
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DetailScreen_Preview() {
    DetailScreen(
        name = "Name",
        description = "Description",
        image = ""
    )
}