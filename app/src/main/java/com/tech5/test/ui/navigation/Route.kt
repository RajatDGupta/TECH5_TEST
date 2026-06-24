package com.tech5.test.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Movie
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Tv
import androidx.compose.ui.graphics.vector.ImageVector
import kotlinx.serialization.Serializable

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
}

data class BottomNavItem(
    val route: Any,
    val label: String,
    val icon: ImageVector
)

val bottomNavItems = listOf(
    BottomNavItem(Route.Movies, "Movies", Icons.Default.Movie),
    BottomNavItem(Route.TvShows, "TV Shows", Icons.Default.Tv),
    BottomNavItem(Route.People, "People", Icons.Default.Person)
)
