package com.route.e_commercec40gsunwed.splash

import com.route.e_commercec40gsunwed.model.Category


enum class WeekDays(val order: Int) {
    SAT(1),
    SUN(2),
    MON(3),
    TUE(4),
    WED(5),
    THU(6),
    FRI(7)
}

//enum class SplashNavigation() {
//    NavigateToHome,
//    NavigateToLogin
//}
sealed interface SplashNavigation {
    data object Login : SplashNavigation
    data class Home(val accessToken: String) : SplashNavigation
}

// Flows & MVI UI Architecture

// function   -> executeAPI(){
//
// }


fun test(weekDays: WeekDays) {
    val sun = WeekDays.SUN

    when (weekDays) {
        WeekDays.SAT -> {}
        WeekDays.SUN -> {}
        WeekDays.MON -> {}
        WeekDays.TUE -> {}
        WeekDays.WED -> {}
        WeekDays.THU -> {}
        WeekDays.FRI -> {}
    }
}


sealed interface SplashDestination {
    data object Idle : SplashDestination

    // Login
    data object Login : SplashDestination

    // Home
    data object Home : SplashDestination
}