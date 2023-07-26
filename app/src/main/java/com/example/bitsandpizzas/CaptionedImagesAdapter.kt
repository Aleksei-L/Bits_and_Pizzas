package com.example.bitsandpizzas

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView


class CaptionedImagesAdapter(private val captions: Array<String?>, private val imageIds: Array<Int?>) :
	RecyclerView.Adapter<CaptionedImagesAdapter.ViewHolder>() {
	private lateinit var listener: Listener

	interface Listener {
		fun onClick(position: Int)
	}

	fun setListener(listen: Listener) {
		listener = listen
	}

	class ViewHolder(val cardView: CardView) : RecyclerView.ViewHolder(cardView)

	override fun getItemCount(): Int = captions.size

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
		val cv: CardView = LayoutInflater.from(parent.context).inflate(R.layout.card_captioned_image, parent, false) as CardView
		return ViewHolder(cv)
	}

	override fun onBindViewHolder(holder: ViewHolder, position: Int) {
		val cardView: CardView = holder.cardView
		val imageView: ImageView = cardView.findViewById(R.id.info_image)
		val textView: TextView = cardView.findViewById(R.id.info_text)
		val drawable: Drawable? = ContextCompat.getDrawable(cardView.context, imageIds[position]!!)

		imageView.setImageDrawable(drawable)
		imageView.contentDescription = captions[position]
		textView.text = captions[position]

		cardView.setOnClickListener {
			listener.onClick(position)
		}
	}
}
