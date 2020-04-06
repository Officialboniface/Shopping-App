package com.example.shoppinglistapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shoppinglistapp.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_products_detail.*

class MainActivity : AppCompatActivity(), OnProductItemClickListener {

    lateinit var binding: ActivityMainBinding

    lateinit var productList: ArrayList<Products>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        productList = ArrayList()
        Addproducts()

        Recyclerview_ID.layoutManager = LinearLayoutManager(this)
        Recyclerview_ID.addItemDecoration(DividerItemDecoration(this, 1))
        Recyclerview_ID.adapter = ProductAdapter(productList, this)
    }

    fun Addproducts() {
        productList.add(Products("Chinese Shrimp", "$40",  Image = R.drawable.chinese_shrimp))
        productList.add(Products("English Hamburger", "$20",  Image = R.drawable.english_hamburger))
        productList.add(Products("Spanish Hamburger", "$35",  Image = R.drawable.spanish_hamburger))

        productList.add(
            Products(
                "Chicken Cherries",
                "$45",
                Image = R.drawable.bowl_cherries_chicken
            )
        )
        productList.add(Products("German Rice",  "$50",  Image = R.drawable.cooked))
        productList.add(Products("Salad", "$60",  Image = R.drawable.salad))
        productList.add(Products("Salmon", "$40",  Image = R.drawable.salmon))
        productList.add(Products("Sea Food", "$75",  Image = R.drawable.sea_food))
        productList.add(Products("Snow Crab", "$65",  Image = R.drawable.snow_crab))

    }

    override fun onItemClick(items: Products, position: Int) {
        val intent = Intent(this, ProductsDetailActivity::class.java)
        intent.putExtra("PRODUCTNAME", items.Name)

        intent.putExtra("PRODUCTIMAGE", items.Image.toString())

        startActivity(intent)
    }
}
