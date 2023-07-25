package com.example.bitsandpizzas.data

import com.example.bitsandpizzas.R

class Pizza(private val name: String, private val imageResourceId: Int) {
	fun getName(): String = name
	fun getImageResourceId(): Int = imageResourceId

	companion object {
		val pizzas = arrayOf<Pizza>(
			Pizza("Diavolo", R.drawable.diavolo),
			Pizza("Funghi", R.drawable.funghi)
		)
	}
}
