package com.example.android.planetApp.ui.fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.android.planetApp.R
import com.example.android.planetApp.databinding.FragmentSecondBinding
import com.example.android.planetApp.service.MarsApiFilter
import com.example.android.planetApp.ui.OverviewViewModel
import com.example.android.planetApp.ui.adapter.PlanetAdapter


class SecondFragment : Fragment() {

    private val viewModel: OverviewViewModel by lazy {
        ViewModelProvider(this).get(OverviewViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = FragmentSecondBinding.inflate(inflater)

        binding.lifecycleOwner = this

        binding.viewModel = viewModel

        binding.photosPlanet.adapter = PlanetAdapter(PlanetAdapter.OnClickListener {
            viewModel.displayPropertyDetails(it)
        })

        viewModel.navigateToSelectedProperty.observe(viewLifecycleOwner, Observer {
            if ( null != it ) {
                this.findNavController().navigate(
                    com.example.android.planetApp.ui.fragment.SecondFragmentDirections.actionShowDetail(it)
                )
                viewModel.displayPropertyDetailsComplete()
            }
        })

        setHasOptionsMenu(true)
        return binding.root
    }

}
