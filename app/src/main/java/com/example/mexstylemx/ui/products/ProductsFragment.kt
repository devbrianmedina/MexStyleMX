package com.example.mexstylemx.ui.products

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mexstylemx.MainActivity
import com.example.mexstylemx.R
import com.example.mexstylemx.adapters.ProductAdapter

class ProductsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_products, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rvProducts: RecyclerView = view.findViewById(R.id.rvProducts)

        // Especifica el número de columnas que deseas en tu cuadrícula (en este caso, 2)
        val numberOfColumns = 2
        val gridLayoutManager = GridLayoutManager(requireContext(), numberOfColumns)

        val adapter = ProductAdapter(
            requireContext(),
            MainActivity.products
        )

        rvProducts.layoutManager = gridLayoutManager
        rvProducts.adapter = adapter
    }
}