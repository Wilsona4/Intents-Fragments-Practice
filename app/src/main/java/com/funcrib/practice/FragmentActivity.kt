package com.funcrib.practice

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class FragmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)

        val fragmentOne: Fragment = FirstFragment()
        val fragmentTwo: Fragment = SecondFragment()
        val btFragmentOne: Button = findViewById(R.id.btFragmentOne)
        val btFragmentTwo: Button = findViewById(R.id.btFragmentTwo)

//      Get Intent
        val fr = intent.getStringExtra("FR_ONE")?.toInt()

        if (fr == 10) {
            supportFragmentManager.beginTransaction().apply {
                add(R.id.fragmentContainer, fragmentOne)
                setReorderingAllowed(true)
                addToBackStack(null)
                commit()
            }
        } else if (fr == 20) {
            supportFragmentManager.beginTransaction().apply {
                add(R.id.fragmentContainer, fragmentTwo)
                setReorderingAllowed(true)
                addToBackStack(null)
                commit()
            }
        }

        btFragmentOne.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragmentContainer, fragmentOne)
                setReorderingAllowed(true)
                addToBackStack(null)
                commit()
            }
        }
        btFragmentTwo.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragmentContainer, fragmentTwo)
                setReorderingAllowed(true)
                addToBackStack(null)
                commit()
            }
        }
    }
}