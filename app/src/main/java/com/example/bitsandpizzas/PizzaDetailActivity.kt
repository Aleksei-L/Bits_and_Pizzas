package com.example.bitsandpizzas

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.bitsandpizzas.data.Pizza

class PizzaDetailActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_pizza_detail)

		setSupportActionBar(findViewById(R.id.toolbar))
		val actionBar: ActionBar? = supportActionBar
		actionBar?.setDisplayHomeAsUpEnabled(true)

		val pizzaId = intent.getIntExtra(EXTRA_PIZZA_ID, 0)
		val pizzaName = Pizza.pizzas[pizzaId].getName()
		val pizzaImage = Pizza.pizzas[pizzaId].getImageResourceId()
		val textView: TextView = findViewById(R.id.pizza_text)
		val imageView: ImageView = findViewById(R.id.pizza_image)

		textView.text = pizzaName
		imageView.setImageDrawable(ContextCompat.getDrawable(this, pizzaImage))
		imageView.contentDescription = pizzaName
	}

	companion object {
		const val EXTRA_PIZZA_ID = "pizza_id"
	}
}
