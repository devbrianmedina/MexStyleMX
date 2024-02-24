package com.example.mexstylemx.adapters

import android.content.Context
import android.content.Intent
import android.graphics.Color
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
import com.example.mexstylemx.ui.productdetails.ProductDetailsActivity

class ProductAdapter(private val context: Context, private val productList: ArrayList<Product>) :
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.card_product, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productList[position]

        // Configura los elementos de la tarjeta con los datos del producto
        holder.productImageView.setImageResource(product.imageResId)
        holder.skuTextView.text = context.getString(R.string.sku_format, product.sku)
        holder.productNameTextView.text = product.name
        if(product.id in MainActivity.favProducts) {
            holder.favoriteIcon.setColorFilter(Color.RED)
        } else {
            holder.favoriteIcon.setColorFilter(Color.BLACK)
        }

        holder.favoriteIcon.setOnClickListener {
            if(product.id in MainActivity.favProducts) {
                holder.favoriteIcon.setColorFilter(Color.BLACK)
                MainActivity.favProducts.remove(product.id)
                productList.remove(product)
            } else {
                holder.favoriteIcon.setColorFilter(Color.RED)
                MainActivity.favProducts.add(product.id)
                if(!productList.contains(product)) {
                    productList.add(product)
                }
            }
            notifyDataSetChanged()
        }

        holder.shoppingCartIcon.setOnClickListener {
            if(MainActivity.cartProducts.map { it.idProduct }.toList().contains(product.id)) {
                MainActivity.cartProducts.first { it.idProduct == product.id }.quantity++
            } else {
                MainActivity.cartProducts.add(
                    CartProduct(
                        product.id,
                        1,
                        hashMapOf()
                    )
                )
            }
        }

        // Escucha de eventos, por ejemplo, clics en la tarjeta
        holder.itemView.setOnClickListener {
            // Aquí puedes manejar el evento de clic en la tarjeta
            val intent = Intent(context, ProductDetailsActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    // ViewHolder para mantener las vistas de la tarjeta
    inner class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val productImageView: ImageView = itemView.findViewById(R.id.productImage)
        val skuTextView: TextView = itemView.findViewById(R.id.skuTextView)
        val productNameTextView: TextView = itemView.findViewById(R.id.productNameTextView)
        val shoppingCartIcon: ImageView = itemView.findViewById(R.id.shoppingCartIcon)
        val favoriteIcon: ImageView = itemView.findViewById(R.id.favoriteIcon)
        // Agrega más vistas según sea necesario
    }
}