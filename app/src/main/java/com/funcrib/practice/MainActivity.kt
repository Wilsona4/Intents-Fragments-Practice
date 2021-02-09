package com.funcrib.practice

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

const val SELECTED_CONTACT_ID = 1

class MainActivity : AppCompatActivity() {
    private var number: String? = null
    lateinit var enterNumber: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        enterNumber = findViewById(R.id.phone)
        val send: Button = findViewById(R.id.send)
        val getNumber: Button = findViewById(R.id.getNumber)
        val btFragmentOneHome: Button = findViewById(R.id.btFragmentOneHome)
        val btFragmentTwoHome: Button = findViewById(R.id.btFragmentTwoHome)



        send.setOnClickListener {
            number = enterNumber.text.toString()
            Toast.makeText(this, "Explicit Intent", Toast.LENGTH_SHORT).show()

            val intent: Intent =
                Intent(this, DialActivity::class.java).apply { putExtra("DIGITS", number) }
            startActivity(intent)
        }
        getNumber.setOnClickListener {
            Toast.makeText(this, "Implicit Intents", Toast.LENGTH_SHORT).show()
            val getIntent: Intent = Intent().apply {
                action = Intent.ACTION_PICK
                type = ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE
            }
            if (getIntent.resolveActivity(packageManager) != null) {
                startActivityForResult(getIntent, SELECTED_CONTACT_ID)
            }
        }
        btFragmentOneHome.setOnClickListener {
//            val fr = 10
            Toast.makeText(this, "Fragment One", Toast.LENGTH_SHORT).show()

            val frIntentOne: Intent = Intent(this, FragmentActivity::class.java).apply {
                putExtra("FR", 10)
            }
            startActivity(frIntentOne)
        }
        btFragmentTwoHome.setOnClickListener {

            Toast.makeText(this, "Dialog", Toast.LENGTH_SHORT).show()

            val effectsDialogFragment = EffectsDialogFragment()
            effectsDialogFragment.show(supportFragmentManager, "Effects Dialog")
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == SELECTED_CONTACT_ID && resultCode == Activity.RESULT_OK) {
//            Create a contact with data received
            val contactUri = data!!.data
            val projection: Array<String> = arrayOf(ContactsContract.CommonDataKinds.Phone.NUMBER)
            if (contactUri != null) {
                contentResolver.query(contactUri, projection, null, null, null).use { cursor ->
                    // If the cursor returned is valid, get the phone number
                    if (cursor != null) {
                        if (cursor.moveToFirst()) {
                            val numberIndex =
                                cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)
                            val phoneNumber: String = cursor.getString(numberIndex)
                            // Do something with the phone number
                            enterNumber.setText(phoneNumber)
//                            number = phoneNumber
                        }
                    }
                }
            }
        }
    }
}