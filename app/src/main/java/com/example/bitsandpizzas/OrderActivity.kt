package com.example.bitsandpizzas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class OrderActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_order)
		setSupportActionBar(findViewById(R.id.toolbar))

		val myActionBar = supportActionBar
		myActionBar!!.setDisplayHomeAsUpEnabled(true)
	}
}
