package come.geekbrains.vitekm.weatherlessonan.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import come.geekbrains.vitekm.weatherlessonan.databinding.FragmentMainBinding
import come.geekbrains.vitekm.weatherlessonan.viewModel.AppState
import come.geekbrains.vitekm.weatherlessonan.viewModel.MainViewModel

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding: FragmentMainBinding
        get() {
            return _binding!!
        }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        _binding = FragmentMainBinding.inflate(inflater, container, false)

        //return inflater.inflate(R.layout.fragment_main, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        val observer = object: Observer<AppState>{
            override fun onChanged(data: AppState) {
                renderData(data)

            }
        }
        viewModel.getData().observe(viewLifecycleOwner, observer)

        viewModel.getWeather()
    }

    private fun renderData(data: AppState){

        when(data){
            is AppState.Error -> {

                binding.loadingLayout.visibility = View.GONE
                Snackbar.make(binding.mainView,"No Lucky! ${data.error}", Snackbar.LENGTH_LONG).show()

            }
            is AppState.Loading -> {
                binding.loadingLayout.visibility = View.VISIBLE

            }
            is AppState.Success -> {
                binding.loadingLayout.visibility = View.GONE
                binding.cityName.text = data.weatherData.city.name
                binding.temperatureValue.text = data.weatherData.temperature.toString()
                binding.feelsLikeValue.text = data.weatherData.feelsLike.toString()
                binding.cityCoordinates.text = "${data.weatherData.city.lat} ${data.weatherData.city.lon}"
                Snackbar.make(binding.mainView,"WORKING...", Snackbar.LENGTH_LONG).show()
                //Toast.makeText(requireContext(), "WORKE...", Toast.LENGTH_LONG).show()
            }
        }

    }

    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()
    }
}