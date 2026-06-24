package com.tech5.test.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Movie
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Tv
import androidx.compose.ui.graphics.vector.ImageVector
import kotlinx.serialization.Serializable

import com.tech5.test.R

sealed interface Route {
    @Serializable
    data object Movies : Route

    @Serializable
    data object TvShows : Route

    @Serializable
    data object People : Route

    @Serializable
    data object Settings : Route

    @Serializable
    data class MovieDetail(val movieId: Int) : Route

    @Serializable
    data class TvShowDetail(val seriesId: Int) : Route

    @Serializable
    data class PersonDetail(val personJson: String) : Route
}

data class BottomNavItem(
    val route: Any,
    val labelRes: Int,
    val icon: ImageVector
)

val bottomNavItems = listOf(
    BottomNavItem(Route.Movies, R.string.movies, Icons.Default.Movie),
    BottomNavItem(Route.TvShows, R.string.tv_shows, Icons.Default.Tv),
    BottomNavItem(Route.People, R.string.people, Icons.Default.Person)
)


