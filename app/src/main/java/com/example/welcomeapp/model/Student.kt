// com/example/welcomeapp/model/Student.kt
package com.example.welcomeapp.model

data class Student(
    val id: Int,
    val name: String,
    val regNo: String,
    val course: String,
    val photoRes: Int,
    val isVerified: Boolean = true
)