package com.example.welcomeapp.data

import com.example.welcomeapp.R
import com.example.welcomeapp.model.Student


object StudentDataProvider {

    val students: List<Student> = listOf(
        Student(1,  "Akello Stellamaris", "24/2/314/01", "BIT", R.drawable.emma,  2, true),
        Student(2,  "Kirya James",        "24/2/314/02", "BCS", R.drawable.emma,    2, false),
        Student(3,  "Mbabazi Joan",       "24/2/314/03", "BIT", R.drawable.emma,  2, true),
        Student(4,  "Kato Johnmary",      "24/2/314/04", "BSE", R.drawable.emma,    2, true),
        Student(5,  "Namukasa Ritah",     "24/2/314/05", "BIT", R.drawable.emma,  2, true),
        Student(6,  "Ssemakula Peter",    "24/2/314/06", "BCS", R.drawable.emma,    2, false),
        Student(7,  "Namutebi Grace",     "24/2/314/07", "BSE", R.drawable.emma,  2, true),
        Student(8,  "Lwanga Daniel",      "24/2/314/08", "BIT", R.drawable.emma,    2, false),
        Student(9,  "Atuhaire Brenda",    "24/2/314/09", "BCS", R.drawable.emma,  2, true),
        Student(10, "Mugisha Kevin",      "24/2/314/10", "BSE", R.drawable.emma,    2, true)
    )
}