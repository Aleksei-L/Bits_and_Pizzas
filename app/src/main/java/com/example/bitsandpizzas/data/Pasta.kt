package com.example.bitsandpizzas.data

import com.example.bitsandpizzas.R

class Pasta(private val name: String, private val imageResourceId: Int) {
	fun getName(): String = name
	fun getImageResourceId(): Int = imageResourceId

	companion object {
		val pastas = arrayOf<Pasta>(
			Pasta("Spaghetti Bolognese", R.drawable.bolognese),
			Pasta("Lasagne", R.drawable.lasagna)
		)
	}
}
