package com.example.simplerecylerview

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.details_activity.*

class DetailsActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.details_activity)

        val intent = getIntent()
        val name = intent.getStringExtra("nameOfAnimal")
        nameOfAnimal.text = name
    }
}