package com.example.mexstylemx.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mexstylemx.MainActivity
import com.example.mexstylemx.R
import com.example.mexstylemx.models.CartProduct
import com.example.mexstylemx.models.Product

class CartProductAdapter(private val cartProducts: ArrayList<CartProduct>) :
    RecyclerView.Adapter<CartProductAdapter.CartProductViewHolder>() {

    inner class CartProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val productImageView: ImageView = itemView.findViewById(R.id.productImageView)
        val productNameTextView: TextView = itemView.findViewById(R.id.productNameTextView)
        val optionsTextView: TextView = itemView.findViewById(R.id.optionsTextViews)
        val priceTextView: TextView = itemView.findViewById(R.id.priceTextView)
        val quantityTextView: TextView = itemView.findViewById(R.id.quantityTextView)
        val totalTextView: TextView = itemView.findViewById(R.id.totalTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_cart_item, parent, false)
        return CartProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: CartProductViewHolder, position: Int) {
        val cartProduct = cartProducts[position]
        val product: Product = MainActivity.products.first { cartProduct.idProduct == it.id }

        holder.productImageView.setImageResource(product.imageResId)
        holder.productNameTextView.text = product.name
        holder.optionsTextView.text = "Opciones: ${formatOptions(cartProduct.options)}"
        holder.priceTextView.text = "Precio: $${product.price}"
        holder.quantityTextView.text = "Cantidad: ${cartProduct.quantity}"
        holder.totalTextView.text = "Total: $${product.price * cartProduct.quantity}"
    }

    override fun getItemCount(): Int {
        return cartProducts.size
    }

    private fun formatOptions(options: HashMap<String, String>): String {
        val formattedOptions = StringBuilder()
        for ((key, values) in options) {
            formattedOptions.append("$key: $values - ")
        }
        return formattedOptions.toString().trim()
    }
}
