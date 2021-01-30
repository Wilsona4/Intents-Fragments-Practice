package com.funcrib.practice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment


class SecondFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_second, container, false)
//      Do this if you want to perform operation on individual views
        val textView: TextView = view.findViewById(R.id.tvFragmentTwo)
        // Inflate the layout for this fragment
        return view
    }

}