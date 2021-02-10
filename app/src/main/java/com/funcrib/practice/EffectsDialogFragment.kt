package com.funcrib.practice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.DialogFragment

class EffectsDialogFragment : DialogFragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_dialog, container, false)

        val btnClose: ImageButton = view.findViewById(R.id.btn_close)
        val btnEffects: Button = view.findViewById(R.id.btn_effects)
        var tvEffects: TextView = view.findViewById(R.id.tv_effects)

        btnClose.setOnClickListener {
            dismiss()
        }
        btnEffects.setOnClickListener {
            dismiss()
        }
        return view
    }

}