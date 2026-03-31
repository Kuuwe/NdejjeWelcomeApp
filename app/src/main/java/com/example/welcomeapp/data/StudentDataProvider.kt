// com/example/welcomeapp/data/StudentDataProvider.kt
package com.example.welcomeapp.data

import com.example.welcomeapp.R
import com.example.welcomeapp.model.Student

object StudentDataProvider {
    val students: List<Student> = listOf(
        Student(
            id = 1,
            name = "KUUWE EMMANUEL",
            regNo = "24/2/306/D/402",
            course = "BSc. Computer Science",
            photoRes = R.drawable.emma,
            isVerified = true
        ),
        Student(
            id = 2,
            name = "NABAYA NESTROY",
            regNo = "24/2/306/D/053",
            course = "BSc. Computer Science",
            photoRes = R.drawable.lot3,
            isVerified = false
        ),
        Student(
            id = 3,
            name = "MBOINEREKU CYRUS",
            regNo = "24/2/314/03",
            course = "BBA – Finance",
            photoRes = R.drawable.emma,
            isVerified = true
        ),
        Student(
            id = 4,
            name = "WANDERA EDWIS",
            regNo = "24/2/314/04",
            course = "BSc. Software Engineering",
            photoRes = R.drawable.emma,
            isVerified = true
        ),
        Student(
            id = 5,
            name = "KABBASIITA MASIKO VICTORIA",
            regNo = "24/2/314/05",
            course = "BSc. INFORMATION SYSTEMS",
            photoRes = R.drawable.emma,
            isVerified = false
        ),
        Student(
            id = 6,
            name = "Okello Daniel",
            regNo = "24/2/314/06",
            course = "BBA – Accounting",
            photoRes = R.drawable.emma,
            isVerified = true
        ),
        Student(
            id = 7,
            name = "Namutebi Grace",
            regNo = "24/2/314/07",
            course = "BSc. Information Technology",
            photoRes = R.drawable.emma
            ,
            isVerified = true
        ),
        Student(
            id = 8,
            name = "Mukasa Brian",
            regNo = "24/2/314/08",
            course = "BSc. Software Engineering",
            photoRes = R.drawable.emma,
            isVerified = false
        ),

    )
}