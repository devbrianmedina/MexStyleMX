package com.example.mexstylemx

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.forEach
import androidx.core.view.forEachIndexed
import com.example.mexstylemx.databinding.ActivityMainBinding
import com.example.mexstylemx.models.CartProduct
import com.example.mexstylemx.models.Product
import com.example.mexstylemx.ui.about.AboutActivity
import com.example.mexstylemx.ui.settings.SettingsActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)

        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navViewBottom: BottomNavigationView = binding.navViewBottom
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_user, R.id.nav_fav, R.id.nav_cart, R.id.nav_products, R.id.nav_categories, R.id.nav_contact
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        navViewBottom.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_home, R.id.nav_user, R.id.nav_fav, R.id.nav_cart -> {
                    navController.popBackStack()
                    navController.navigate(menuItem.itemId)
                    true
                }
                else -> false
            }
        }


        products.add(
            Product(
                1,
                R.drawable.product_1,
                "Nombre 1",
                "Descripcion 1",
                "894567",
                50.99,
                hashMapOf(
                    "Talla" to listOf("S", "M", "G"),
                    "Color" to listOf("Blanco", "Negro"),
                )
            )
        )
        products.add(
            Product(
                2,
                R.drawable.product_2,
                "Nombre 2",
                "Descripcion 2",
                "1489734",
                50.99,
                hashMapOf(
                    "Talla" to listOf("S", "M", "G"),
                    "Color" to listOf("Blanco", "Negro"),
                )
            )
        )
        products.add(
            Product(
                3,
                R.drawable.product_3,
                "Nombre 3",
                "Descripcion 3",
                "1489734",
                50.99,
                hashMapOf(
                    "Talla" to listOf("S", "M", "G"),
                    "Color" to listOf("Blanco", "Negro"),
                )
            )
        )
        cartProducts.add(
            CartProduct(
                1,
                2,
                hashMapOf(
                    "Talla" to "S",
                    "Color" to "Blanco",
                )
            )
        )
        cartProducts.add(
            CartProduct(
                2,
                3,
                hashMapOf(
                    "Talla" to "M",
                    "Color" to "Blanco",
                )
            )
        )
        favProducts.add(1)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.action_settings -> {
                val intent = Intent(this, SettingsActivity::class.java)
                startActivity(intent)
            }
            R.id.action_about -> {
                val intent = Intent(this, AboutActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    companion object {
        val products = ArrayList<Product>()
        val cartProducts = ArrayList<CartProduct>()
        val favProducts = ArrayList<Int>()
    }
}