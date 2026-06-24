package com.tech5.test.ui.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.tech5.test.movies.presentation.MovieDetailScreen
import com.tech5.test.movies.presentation.MoviesScreen
import com.tech5.test.people.presentation.PeopleScreen
import com.tech5.test.settings.presentation.SettingsScreen
import com.tech5.test.tvshows.presentation.TvShowDetailScreen
import com.tech5.test.tvshows.presentation.TvShowsScreen
import com.tech5.test.ui.navigation.Route
import com.tech5.test.ui.navigation.bottomNavItems

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val currentNavItem = bottomNavItems.find { item ->
        currentDestination?.hierarchy?.any { it.hasRoute(item.route::class) } == true
    }

    val isSettingsRoute =
        currentDestination?.hierarchy?.any { it.hasRoute(Route.Settings::class) } == true
    
    val isMovieDetailRoute =
        currentDestination?.hierarchy?.any { it.hasRoute(Route.MovieDetail::class) } == true

    val isTvShowDetailRoute =
        currentDestination?.hierarchy?.any { it.hasRoute(Route.TvShowDetail::class) } == true

    val hideBars = isSettingsRoute || isMovieDetailRoute || isTvShowDetailRoute

    var showMenu by remember { mutableStateOf(false) }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        contentWindowInsets = if (hideBars) WindowInsets(
            0,
            0,
            0,
            0
        ) else WindowInsets.safeDrawing,
        topBar = {
            if (!hideBars) {
                TopAppBar(
                    title = {
                        Text(text = currentNavItem?.label ?: "Tech5 Test")
                    },
                    actions = {
                        IconButton(onClick = { /* TODO: Implement search */ }) {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = "Search"
                            )
                        }
                        IconButton(onClick = { showMenu = true }) {
                            Icon(
                                imageVector = Icons.Default.MoreVert,
                                contentDescription = "More"
                            )
                        }
                        DropdownMenu(
                            expanded = showMenu,
                            onDismissRequest = { showMenu = false }
                        ) {
                            DropdownMenuItem(
                                text = { Text("Settings") },
                                onClick = {
                                    showMenu = false
                                    navController.navigate(Route.Settings)
                                }
                            )
                        }
                    }
                )
            }
        },
        bottomBar = {
            if (!hideBars) {
                NavigationBar {
                    bottomNavItems.forEach { item ->
                        NavigationBarItem(
                            icon = { Icon(item.icon, contentDescription = item.label) },
                            label = { Text(item.label) },
                            selected = currentDestination?.hierarchy?.any { it.hasRoute(item.route::class) } == true,
                            onClick = {
                                navController.navigate(item.route) {
                                    popUpTo(navController.graph.findStartDestination().id) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                        )
                    }
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Route.Movies,
            modifier = Modifier
                .fillMaxSize()
                .padding(if (hideBars) PaddingValues(0.dp) else innerPadding)
        ) {
            composable<Route.Movies> {
                MoviesScreen(
                    onMovieClick = { movieId ->
                        navController.navigate(Route.MovieDetail(movieId))
                    }
                )
            }
            composable<Route.TvShows> {
                TvShowsScreen(
                    onTvShowClick = { seriesId ->
                        navController.navigate(Route.TvShowDetail(seriesId))
                    }
                )
            }
            composable<Route.People> {
                PeopleScreen()
            }
            composable<Route.Settings> {
                SettingsScreen(onBackClick = { navController.popBackStack() })
            }
            composable<Route.MovieDetail> {
                MovieDetailScreen(onBackClick = { navController.popBackStack() })
            }
            composable<Route.TvShowDetail> {
                TvShowDetailScreen(onBackClick = { navController.popBackStack() })
            }
        }
    }
}
