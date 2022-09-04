package com.hynekbraun.chesstimer.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hynekbraun.chesstimer.presentation.setings.SettingsScreen
import com.hynekbraun.chesstimer.presentation.setings.addtimer.AddTimerScreen
import com.hynekbraun.chesstimer.presentation.timer.TimerScreen
import java.sql.Time

@Composable
fun TimerNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = TimerNavDestinations.TIMER_ROUTE
    ) {
        composable(TimerNavDestinations.TIMER_ROUTE) {
            TimerScreen(viewModel = hiltViewModel(),
                onSettingsClicked = {
                    navController.navigate(TimerNavDestinations.SETTINGS_ROUTE)
                })
        }
        composable(TimerNavDestinations.SETTINGS_ROUTE) {
            SettingsScreen(viewModel = hiltViewModel(),
                addTimerClicked = {
                    navController.navigate(TimerNavDestinations.ADD_TIMER)
                },
                onNavigateBack = {
                    navController.navigate(TimerNavDestinations.TIMER_ROUTE) {
                        popUpTo(TimerNavDestinations.TIMER_ROUTE)
                    }
                })
        }
        composable(TimerNavDestinations.ADD_TIMER) {
            AddTimerScreen(
                viewModel = hiltViewModel(),
                onNavigateBack = {
                    navController.navigate(TimerNavDestinations.SETTINGS_ROUTE) {
                        popUpTo(TimerNavDestinations.SETTINGS_ROUTE)
                    }
                }
            )
        }
    }
}