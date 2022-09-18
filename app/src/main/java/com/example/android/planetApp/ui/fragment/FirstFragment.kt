package com.example.android.planetApp.ui.fragment

import android.os.Bundle
import android.text.Html
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.android.planetApp.R
import com.example.android.planetApp.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {

    private lateinit var fragmentFirstBinding: FragmentFirstBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentFirstBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_first, container, false)

        return fragmentFirstBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val text = "<font color=#ffffff>Let’s Explore the</font> <font color=#F9AD1A>Solar System\n</font><font color=#ffffff>with</font> <font color=#F9AD1A>Explorer</font> "
        fragmentFirstBinding.textView.setText(Html.fromHtml(text))
        fragmentFirstBinding.button.setOnClickListener {
            findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
        }

    }

}