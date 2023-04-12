package com.example.validation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    private val message = "Invalid credentials"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val n1: EditText = findViewById(R.id.email)
        val n2: EditText = findViewById(R.id.pin)

        val b1: Button = findViewById(R.id.login)
        val b2: Button = findViewById(R.id.reset)

        b1.setOnClickListener {
            val vl1 = n1.text.toString()
            val vl2 = n2.text.toString()
            val check1 = "[a-zA-z]+".toRegex()
            val check2 = "\\d{4}".toRegex()
            if (check1.matches(vl1) && check2.matches((vl2))) {
                val intent = Intent(this, WelcomePage::class.java)
                    .putExtra("username", vl1)
                    .putExtra("password", vl2)

                startActivity(intent)
            } else {
                Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

            }
            b2.setOnClickListener{
                n1.setText("")
                n2.setText("")


            }
        }

    }
}