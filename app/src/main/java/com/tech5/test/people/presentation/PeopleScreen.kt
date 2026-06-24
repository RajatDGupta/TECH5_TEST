package com.tech5.test.people.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.tech5.test.people.presentation.components.PersonItem

@Composable
fun PeopleScreen(
    onPersonClick: (com.tech5.test.people.domain.model.Person) -> Unit,
    viewModel: PeopleViewModel = hiltViewModel()
) {
    val people = viewModel.peopleState.collectAsLazyPagingItems()

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(people.itemCount) { index ->
                people[index]?.let { person ->
                    PersonItem(
                        person = person,
                        onClick = { onPersonClick(person) }
                    )
                }
            }

            when (val state = people.loadState.append) {
                is LoadState.Error -> {
                    item {
                        Text(
                            text = "Error: ${state.error.localizedMessage}",
                            modifier = Modifier.padding(16.dp),
                            color = MaterialTheme.colorScheme.error
                        )
                    }
                }
                is LoadState.Loading -> {
                    item {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            CircularProgressIndicator(modifier = Modifier.padding(16.dp))
                        }
                    }
                }
                else -> {}
            }
        }

        if (people.loadState.refresh is LoadState.Loading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        }

        if (people.loadState.refresh is LoadState.Error) {
            val error = (people.loadState.refresh as LoadState.Error).error
            Column(
                modifier = Modifier.align(Alignment.Center),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Refresh",
                    color = MaterialTheme.colorScheme.error
                )
                Spacer(modifier = Modifier.height(8.dp))
                IconButton(onClick = { people.retry() }) {
                    Icon(
                        imageVector = Icons.Default.Refresh,
                        contentDescription = "Retry"
                    )
                }
            }
        }
    }
}

