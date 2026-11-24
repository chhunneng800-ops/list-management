package com.example.reviewlistandadapter1

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

//        val tetxViewTitle = findViewById<TextView>(R.id.textViewTitle)
//        tetxViewTitle.text = getString(R.string.helloworld)


        val btnStd =findViewById<TextView>(R.id.btnStudentManagement)
        btnStd.setOnClickListener {
            val intent = Intent(this, SearchStudentActivity::class.java)
            this.startActivity(intent)
        }




    }
}

