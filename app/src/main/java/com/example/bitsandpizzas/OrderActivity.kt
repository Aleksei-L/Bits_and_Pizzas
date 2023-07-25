package com.example.bitsandpizzas

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class OrderActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_order)
		setSupportActionBar(findViewById(R.id.toolbar))

		val myActionBar = supportActionBar
		myActionBar!!.setDisplayHomeAsUpEnabled(true)

		val fab: FloatingActionButton = findViewById(R.id.fab)
		fab.setOnClickListener { onClickFab() }
	}

	private fun onClickFab() {
		val snack = Snackbar.make(findViewById<CoordinatorLayout>(R.id.coordinator), "Your order has been updated", Snackbar.LENGTH_SHORT)
		snack.setAction("Undo") { Toast.makeText(this, "Undone!", Toast.LENGTH_SHORT).show() }
		snack.show()
	}
}
