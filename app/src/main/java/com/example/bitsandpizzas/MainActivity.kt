package com.example.bitsandpizzas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.ShareActionProvider
import androidx.core.view.MenuItemCompat

class MainActivity : AppCompatActivity() {
	private lateinit var shareActionProvider: ShareActionProvider

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		setSupportActionBar(findViewById(R.id.toolbar))
	}

	override fun onCreateOptionsMenu(menu: Menu?): Boolean {
		menuInflater.inflate(R.menu.menu_main, menu)

		val menuItem = menu!!.findItem(R.id.action_share)
		shareActionProvider = MenuItemCompat.getActionProvider(menuItem) as ShareActionProvider
		setShareActionIntent("Want to join me for pizza?")

		return super.onCreateOptionsMenu(menu)
	}

	override fun onOptionsItemSelected(item: MenuItem): Boolean {
		if (item.itemId == R.id.action_create_order) {
			val intent = Intent(this, OrderActivity::class.java)
			startActivity(intent)
		}
		return super.onOptionsItemSelected(item)
	}

	private fun setShareActionIntent(text: String) {
		val myIntent = Intent(Intent.ACTION_SEND)
		myIntent.type = "text/plain"
		intent.putExtra(Intent.EXTRA_TEXT, text)
		shareActionProvider.setShareIntent(intent)
	}
}
