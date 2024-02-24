package com.example.mexstylemx.ui.cart

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mexstylemx.MainActivity
import com.example.mexstylemx.R
import com.example.mexstylemx.adapters.CartProductAdapter
import com.example.mexstylemx.ui.payment.PaymentActivity

class CartFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cart, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //recycler
        val rvCart: RecyclerView = view.findViewById(R.id.rvCart)

        val adapter = CartProductAdapter(
            MainActivity.cartProducts
        )

        val linearLayoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        rvCart.layoutManager = linearLayoutManager
        rvCart.adapter = adapter

        val btnPayment: Button = view.findViewById(R.id.btnPaymentCart)
        btnPayment.setOnClickListener {
            val intent = Intent(requireContext(), PaymentActivity::class.java)
            startActivity(intent)
        }
    }
}