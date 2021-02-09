package com.funcrib.practice

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class FragmentActivity : AppCompatActivity() {
    val fragmentOne: Fragment = FirstFragment()
    val fragmentTwo: Fragment = SecondFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)

        val btFragmentOne: Button = findViewById(R.id.btFragmentOne)
        val btFragmentTwo: Button = findViewById(R.id.btFragmentTwo)

        initDefaultFragment()

        btFragmentOne.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                setReorderingAllowed(true)
                addToBackStack(null)
                setCustomAnimations(
                    R.anim.slide_in_left,
                    R.anim.slide_out_right,
                    R.anim.slide_in_right,
                    R.anim.slide_out_left
                )
                replace(R.id.fragmentContainer, fragmentOne)
                commit()
            }
        }
        btFragmentTwo.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                setReorderingAllowed(true)
                addToBackStack(null)
                setCustomAnimations(
                    R.anim.slide_in_left,
                    R.anim.slide_out_right,
                    R.anim.slide_in_right,
                    R.anim.slide_out_left
                )
                replace(R.id.fragmentContainer, fragmentTwo)
                commit()
            }
        }
    }

    private fun initDefaultFragment() {
        supportFragmentManager.beginTransaction().apply {
            setReorderingAllowed(true)
            addToBackStack(null)
            setCustomAnimations(
                R.anim.slide_in_left,
                R.anim.slide_out_right,
                R.anim.slide_in_right,
                R.anim.slide_out_left
            )
            replace(R.id.fragmentContainer, fragmentOne)
            commit()
        }
    }
}