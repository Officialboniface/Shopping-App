package com.example.shoppinglistapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_products_detail.view.*
import kotlinx.android.synthetic.main.layout_item_view.view.*

class ProductAdapter ( var  items: ArrayList<Products>, var clickListener: OnProductItemClickListener) : RecyclerView.Adapter<ProductViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        lateinit var  productViewHolder: ProductViewHolder

        productViewHolder = ProductViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_item_view, parent, false))
        return productViewHolder
    }

    override fun getItemCount(): Int {
       return items.size
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {

        holder.initialize(items.get(position), clickListener)

    }


}

class  ProductViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){

    var ProductName = itemView.Product_name
    var ProductPrice = itemView.Product_Price
    var ProductImage = itemView.Product_Image



    fun initialize (item: Products, action:OnProductItemClickListener){
    ProductName.text = item.Name
        ProductPrice.text = item.Price
        ProductImage.setImageResource(item.Image)



        itemView.setOnClickListener{
            action.onItemClick(item, adapterPosition)
        }

    }



}

interface OnProductItemClickListener{
    fun onItemClick(items: Products, position: Int)

}