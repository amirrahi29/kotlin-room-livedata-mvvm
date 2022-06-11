package com.example.myapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.model.ProductModel
import kotlinx.android.synthetic.main.product_list.view.*

class ProductAdapter(context: Context, val countInterface:CountInterface,
val clickInterface:ClickInterface,val deleteInterface:DeleteInterface) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    val productList = ArrayList<ProductModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_list,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.productName.setText(productList.get(position).productName)
        holder.productPrice.setText(productList.get(position).productPrice)

        holder.deleteBtn.setOnClickListener {
            deleteInterface.onDelete(productList.get(position))
        }

        holder.itemView.setOnClickListener {
            clickInterface.onClick(productList.get(position))
        }

        //getcount
        countInterface.onCount(productList.size)
    }

    override fun getItemCount(): Int {
       return productList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        val productName = itemView.textView
        val productPrice = itemView.textView2
        val deleteBtn = itemView.imageView
    }

    fun updateList(myList: List<ProductModel>)
    {
        productList.clear()
        productList.addAll(myList)
        notifyDataSetChanged()
    }
}

interface CountInterface{
    fun onCount(count:Int)
}
interface ClickInterface{
    fun onClick(productModel: ProductModel)
}
interface DeleteInterface{
    fun onDelete(productModel: ProductModel)
}
