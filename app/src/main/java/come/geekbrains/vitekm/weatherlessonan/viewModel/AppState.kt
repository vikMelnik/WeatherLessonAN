package come.geekbrains.vitekm.weatherlessonan.viewModel

import come.geekbrains.vitekm.weatherlessonan.repository.Weather

sealed class AppState {
    object Loading: AppState()
    data class Success(val weatherData: Weather): AppState()
    data class Error(val error: Throwable): AppState()
}