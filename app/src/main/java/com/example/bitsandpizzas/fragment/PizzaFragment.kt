package com.example.bitsandpizzas.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bitsandpizzas.CaptionedImagesAdapter
import com.example.bitsandpizzas.R
import com.example.bitsandpizzas.activity.PizzaDetailActivity
import com.example.bitsandpizzas.data.Pizza

class PizzaFragment : Fragment() {
	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View {
		val pizzaRecycler: RecyclerView =
			inflater.inflate(R.layout.fragment_pizza, container, false) as RecyclerView

		val pizzaNames: Array<String?> = arrayOfNulls(Pizza.pizzas.size)
		for (i in pizzaNames.indices)
			pizzaNames[i] = Pizza.pizzas[i].getName()

		val pizzaImages: Array<Int?> = arrayOfNulls(Pizza.pizzas.size)
		for (i in pizzaImages.indices)
			pizzaImages[i] = Pizza.pizzas[i].getImageResourceId()

		val adapter = CaptionedImagesAdapter(pizzaNames, pizzaImages)
		pizzaRecycler.adapter = adapter

		val layoutManager = GridLayoutManager(activity, 2)
		pizzaRecycler.layoutManager = layoutManager

		adapter.setListener(object : CaptionedImagesAdapter.Listener {
			override fun onClick(position: Int) {
				val intent = Intent(activity, PizzaDetailActivity::class.java)
				intent.putExtra(PizzaDetailActivity.EXTRA_PIZZA_ID, position)
				activity!!.startActivity(intent)
			}
		})

		return pizzaRecycler
	}
}
