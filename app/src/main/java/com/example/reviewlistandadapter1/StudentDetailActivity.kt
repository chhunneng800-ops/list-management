package com.example.reviewlistandadapter1

import android.media.Image
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.core.content.IntentCompat
import com.google.android.material.imageview.ShapeableImageView

class StudentDetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_detail)

        val user = IntentCompat.getSerializableExtra(intent, "User", Student::class.java)

         val id = findViewById<TextView>(R.id.id)
         val name = findViewById<TextView>(R.id.name)
         val image = findViewById<ShapeableImageView>(R.id.studentImageDetail)
         val stdClass = findViewById<TextView>(R.id.classStd)
         val age = findViewById<TextView>(R.id.age)
         val score = findViewById<TextView>(R.id.score)

         id.text = "ID Student : ${user?.id}"
         name.text = "Student Nanem : ${user?.name}"
         image.setImageResource(user?.image ?: R.drawable.pic1)
         stdClass.text = "Student Class : ${user?.stdClass}"
         age.text = "Stundent Age ; ${user?.age}"
         score.text = "Studemt Score : ${user?.score}"




    }
}