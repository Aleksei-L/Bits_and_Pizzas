package com.example.bitsandpizzas.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bitsandpizzas.CaptionedImagesAdapter
import com.example.bitsandpizzas.R
import com.example.bitsandpizzas.activity.PastaDetailActivity
import com.example.bitsandpizzas.data.Pasta

class PastaFragment : Fragment() {
	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View {
		val pastaRecycler: RecyclerView =
			inflater.inflate(R.layout.fragment_pasta, container, false) as RecyclerView

		val pastaNames: Array<String?> = arrayOfNulls(Pasta.pastas.size)
		for (i in pastaNames.indices)
			pastaNames[i] = Pasta.pastas[i].getName()

		val pastaImages: Array<Int?> = arrayOfNulls(Pasta.pastas.size)
		for (i in pastaImages.indices)
			pastaImages[i] = Pasta.pastas[i].getImageResourceId()

		val adapter = CaptionedImagesAdapter(pastaNames, pastaImages)
		pastaRecycler.adapter = adapter

		val layoutManager = LinearLayoutManager(activity)
		pastaRecycler.layoutManager = layoutManager

		adapter.setListener(object : CaptionedImagesAdapter.Listener {
			override fun onClick(position: Int) {
				val intent = Intent(activity, PastaDetailActivity::class.java)
				intent.putExtra(PastaDetailActivity.EXTRA_PASTA_ID, position)
				activity!!.startActivity(intent)
			}
		})

		return pastaRecycler
	}
}
