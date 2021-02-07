package com.funcrib.practice

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class FragmentActivity : AppCompatActivity() {

    /**
    make variables global so it can be viewed outside the oncreate method
     **/

    val fragmentOne: Fragment = FirstFragment()
    val fragmentTwo: Fragment = SecondFragment()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)

/**
  make variables global so it can be viewed outside the oncreate method
  **/

//        val fragmentOne: Fragment = FirstFragment()
//        val fragmentTwo: Fragment = SecondFragment()
        val btFragmentOne: Button = findViewById(R.id.btFragmentOne)
        val btFragmentTwo: Button = findViewById(R.id.btFragmentTwo)

        
/**
  initialize default fragment
  **/
        initDefaultFragment()

//        Redundant
//        if (savedInstanceState == null) {
//      Get Intent
//            val fr = intent.getStringExtra("FR")?.toInt()

//            if (fr == 10) {
//                supportFragmentManager.beginTransaction().apply {
//                    add(R.id.fragmentContainer, fragmentOne)
//                    setReorderingAllowed(true)
//                    addToBackStack(null)
//                    commit()
//                }
//            } else if (fr == 20) {
//                supportFragmentManager.beginTransaction().apply {
//                    add(R.id.fragmentContainer, fragmentTwo)
//                    setReorderingAllowed(true)
//                    addToBackStack(null)
//                    commit()
//                }
//
//            }
//        }


        btFragmentOne.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                setReorderingAllowed(true)
                addToBackStack(null)
//                call setanimations before you replace fragment
                setCustomAnimations(
                    R.anim.enter_left_to_right,
                    R.anim.exit_to_right,
                    R.anim.enter_right_to_left,
                    R.anim.exit_to_left
                )
//                call setanimations before you replace fragment
                replace(R.id.fragmentContainer, fragmentOne)
                commit()
            }
        }
        btFragmentTwo.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                setReorderingAllowed(true)
                addToBackStack(null)
//               call setanimations before you replace fragment
                setCustomAnimations(
                    R.anim.enter_left_to_right,
                    R.anim.exit_to_right,
                    R.anim.enter_right_to_left,
                    R.anim.exit_to_left
                )
//              call setanimations before you replace fragment
                replace(R.id.fragmentContainer, fragmentTwo)
                commit()
            }
        }
    }

    private fun initDefaultFragment() {

        supportFragmentManager.beginTransaction().apply {
            setReorderingAllowed(true)
            addToBackStack(null)
//            call set_animations before you replace fragment
            setCustomAnimations(
                R.anim.enter_left_to_right,
                R.anim.exit_to_right,
                R.anim.enter_right_to_left,
                R.anim.exit_to_left
            )
//            call set_animations before you replace fragment
            replace(R.id.fragmentContainer, fragmentOne)
            commit()
        }

    }
}