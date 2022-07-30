package come.geekbrains.vitekm.weatherlessonan.repository

interface Repository {
    fun getWeatherFromServer():Weather
    fun getWorldWeatherFromLocalStorage():Weather
    fun getRussianWeatherFromLocalStorage():Weather
}