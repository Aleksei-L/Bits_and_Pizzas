package com.example.bitsandpizzas.activity

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.ShareActionProvider
import androidx.core.view.MenuItemCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.bitsandpizzas.R
import com.example.bitsandpizzas.fragment.PastaFragment
import com.example.bitsandpizzas.fragment.PizzaFragment
import com.example.bitsandpizzas.fragment.StoresFragment
import com.example.bitsandpizzas.fragment.TopFragment
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
	private lateinit var shareActionProvider: ShareActionProvider

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		setSupportActionBar(findViewById(R.id.toolbar))

		val pagerAdapter = SectionsPagerAdapter(supportFragmentManager)
		val pager: ViewPager = findViewById(R.id.pager)
		pager.adapter = pagerAdapter

		val tabLayout: TabLayout = findViewById(R.id.tabs)
		tabLayout.setupWithViewPager(pager)
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

class SectionsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
	override fun getCount(): Int = 4

	override fun getItem(position: Int): Fragment {
		return when (position) {
			0 -> TopFragment()
			1 -> PizzaFragment()
			2 -> PastaFragment()
			else -> StoresFragment()
		}
	}

	override fun getPageTitle(position: Int): CharSequence? {
		return when (position) {
			0 -> "Home"
			1 -> "Pizzas"
			2 -> "Pasta"
			3 -> "Stores"
			else -> null
		}
	}
}
