package come.geekbrains.vitekm.weatherlessonan.repository

class RepositoryImpl: Repository {
    override fun getWeatherFromServer(): Weather {
        Thread.sleep(2000L)
       return Weather()
    }

    override fun getWorldWeatherFromLocalStorage():Weather {
        Thread.sleep(20L)
        return Weather()
    }

    override fun getRussianWeatherFromLocalStorage(): Weather {
        return Weather()
    }
}