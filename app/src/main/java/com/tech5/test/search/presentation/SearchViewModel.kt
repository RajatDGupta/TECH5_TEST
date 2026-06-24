package com.tech5.test.search.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tech5.test.movies.domain.model.Movie
import com.tech5.test.movies.domain.repository.MovieRepository
import com.tech5.test.people.domain.model.Person
import com.tech5.test.people.domain.repository.PersonRepository
import com.tech5.test.tvshows.domain.model.TvShow
import com.tech5.test.tvshows.domain.repository.TvShowRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val movieRepository: MovieRepository,
    private val tvShowRepository: TvShowRepository,
    private val personRepository: PersonRepository
) : ViewModel() {

    private val _searchQuery = MutableStateFlow("")
    val searchQuery = _searchQuery.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()

    private val _searchResults = MutableStateFlow<SearchResult>(SearchResult.Empty)
    val searchResults = _searchResults.asStateFlow()

    private var searchJob: Job? = null

    fun onSearchQueryChange(query: String, type: String) {
        _searchQuery.value = query
        if (query.isBlank()) {
            searchJob?.cancel()
            _searchResults.value = SearchResult.Empty
            _isLoading.value = false
            return
        }
        
        searchJob?.cancel()
        searchJob = viewModelScope.launch {
            _isLoading.value = true
            delay(500L) // Debounce
            search(query, type)
        }
    }

    private suspend fun search(query: String, type: String) {
        try {
            when (type) {
                "movies" -> {
                    val results = movieRepository.searchMovies(query)
                    _searchResults.value = SearchResult.Movies(results)
                }
                "tv_shows" -> {
                    val results = tvShowRepository.searchTvShows(query)
                    _searchResults.value = SearchResult.TvShows(results)
                }
                "people" -> {
                    val results = personRepository.searchPeople(query)
                    _searchResults.value = SearchResult.People(results)
                }
            }
        } catch (e: Exception) {
            _searchResults.value = SearchResult.Error(e.message ?: "Unknown error")
        } finally {
            _isLoading.value = false
        }
    }
}

sealed interface SearchResult {
    data object Empty : SearchResult
    data class Movies(val movies: List<Movie>) : SearchResult
    data class TvShows(val tvShows: List<TvShow>) : SearchResult
    data class People(val people: List<Person>) : SearchResult
    data class Error(val message: String) : SearchResult
}
