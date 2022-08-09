package com.sahan.disher.category

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
//import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.sahan.disher.category.model.Category
import com.sahan.disher.category.viewmodel.CategoryViewModel

// any of these parameters change --> recomposition
/**
This remember:
essentially like giving our compose functions a little bit of memory in the compose function
so when it gets recomposed as opposed to this list getting read and again and again and again
what we've got is like this little slice of memory so its going to be like okay im going to read a list
of categories im going to hold on to it and if this function gets recomposed ,remember we dont really have control
of it it wont then again unless the values changed from the viewmodel ,it wont then again go oh i need to i need
to do something i need to its got i ve got a bit of memory im going to keep hold of it which is clean. -- caching
 */
@Composable
fun CategoryScreen(
    viewmodel: CategoryViewModel = hiltViewModel(),
    onItemClick: (category: String) -> Unit
) {
    val listOfCategories by remember {
        viewmodel.listOfCategories
    }
    Column {
        Text("Category", modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
        Spacer(modifier = Modifier.height(30.dp))
        LazyColumn {
            items(listOfCategories) { item ->
                SingleCategoryItem(category = item){ category ->
                    onItemClick.invoke(category)
                }
            }
        }
    }
}

@OptIn(ExperimentalCoilApi::class)
@Composable
fun SingleCategoryItem(
    category: Category,
    onItemClick: (category: String) -> Unit
) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable {
                onItemClick.invoke(category.strCategory)
            },
        elevation = 8.dp,
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {

            Image(
                modifier = Modifier.size(80.dp),
                painter = rememberImagePainter(
                    category.strCategoryThumb
                ),
                contentDescription = null
            )
            Text(
                text = category.strCategory,
                fontSize = 24.sp
            )
        }
    }


}
