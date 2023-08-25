package com.example.bitsandpizzas.activity

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.bitsandpizzas.R
import com.example.bitsandpizzas.data.Pasta

class PastaDetailActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_pasta_detail)

		setSupportActionBar(findViewById(R.id.toolbar))
		val actionBar: ActionBar? = supportActionBar
		actionBar?.setDisplayHomeAsUpEnabled(true)

		val pastaId = intent.getIntExtra(EXTRA_PASTA_ID, 0)
		val pastaName = Pasta.pastas[pastaId].getName()
		val pastaImage = Pasta.pastas[pastaId].getImageResourceId()
		val textView: TextView = findViewById(R.id.pasta_text)
		val imageView: ImageView = findViewById(R.id.pasta_image)

		textView.text = pastaName
		imageView.setImageDrawable(ContextCompat.getDrawable(this, pastaImage))
		imageView.contentDescription = pastaName
	}

	companion object {
		const val EXTRA_PASTA_ID = "pasta_id"
	}
}
