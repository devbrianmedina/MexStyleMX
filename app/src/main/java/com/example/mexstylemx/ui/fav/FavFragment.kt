package com.example.mexstylemx.ui.fav

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mexstylemx.MainActivity
import com.example.mexstylemx.R
import com.example.mexstylemx.adapters.CartProductAdapter
import com.example.mexstylemx.adapters.ProductAdapter

class FavFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fav, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rvFav: RecyclerView = view.findViewById(R.id.rvFav)

        // Especifica el número de columnas que deseas en tu cuadrícula (en este caso, 2)
        val numberOfColumns = 2
        val gridLayoutManager = GridLayoutManager(requireContext(), numberOfColumns)

        val adapter = ProductAdapter(
            requireContext(),
            ArrayList(MainActivity.products.takeWhile { it.id in MainActivity.favProducts })
        )

        rvFav.layoutManager = gridLayoutManager
        rvFav.adapter = adapter

    }
}