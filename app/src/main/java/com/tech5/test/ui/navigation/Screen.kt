package com.tech5.test.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Movie
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Tv
import androidx.compose.ui.graphics.vector.ImageVector
import kotlinx.serialization.Serializable

sealed interface Screen {
    @Serializable
    data object Movies : Screen
    @Serializable
    data object TvShows : Screen
    @Serializable
    data object People : Screen
}

data class BottomNavItem(
    val route: Any,
    val label: String,
    val icon: ImageVector
)

val bottomNavItems = listOf(
    BottomNavItem(Screen.Movies, "Movies", Icons.Default.Movie),
    BottomNavItem(Screen.TvShows, "TV Shows", Icons.Default.Tv),
    BottomNavItem(Screen.People, "People", Icons.Default.Person)
)
