package com.example.welcomeapp.model

data class Student(
    val id: Int,
    val name: String,
    val regNo: String,
    val programme: String,
    val photoRes: Int,          // R.drawable integer ID
    val yearOfStudy: Int,       // NEW: shows year on card
    val isVerified: Boolean = false
)