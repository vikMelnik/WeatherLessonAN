package come.geekbrains.vitekm.weatherlessonan.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import come.geekbrains.vitekm.weatherlessonan.databinding.FragmentMainBinding
import come.geekbrains.vitekm.weatherlessonan.viewModel.MainViewModel

class MainFragment : Fragment() {

    lateinit var binding: FragmentMainBinding // утечка


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        binding = FragmentMainBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_main, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        val observer = object: Observer<Any>{
            override fun onChanged(data: Any) {
                renderData(data)

            }
        }
        viewModel.getData().observe(viewLifecycleOwner, observer)

        viewModel.getWeather()
    }

    private fun renderData(data: Any){
       Toast.makeText(requireContext(), "WORKE...", Toast.LENGTH_LONG).show()
    }

    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()
    }
}