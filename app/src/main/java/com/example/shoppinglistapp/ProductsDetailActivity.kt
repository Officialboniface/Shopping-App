package com.example.shoppinglistapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.shoppinglistapp.databinding.ActivityProductsDetailBinding
import kotlinx.android.synthetic.main.activity_products_detail.*

class ProductsDetailActivity : AppCompatActivity() {
    lateinit var binding: ActivityProductsDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_products_detail)

        Detail_Name.text = getIntent().getStringExtra("PRODUCTNAME")
        Detail_Image.setImageResource(getIntent().getStringExtra("PRODUCTIMAGE").toInt())








    }




}
