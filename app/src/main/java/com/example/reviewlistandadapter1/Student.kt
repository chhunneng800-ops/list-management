package com.example.reviewlistandadapter1
import java.io.Serializable


data class Student(
    val id: Int,
    val image: Int,
    val stdClass: String,
    val name: String,
    val age: Int,
    val gender: String,
    val score: Double
) : Serializable
