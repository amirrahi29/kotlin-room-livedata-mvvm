package com.example.myapplication.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R
import com.example.myapplication.model.ProductModel
import com.example.myapplication.view_model.ProductViewModel
import kotlinx.android.synthetic.main.activity_add_edit.*

class AddEditActivity : AppCompatActivity() {

    lateinit var productViewModel: ProductViewModel
    var productId = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_edit)

        productViewModel = ViewModelProvider(this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(ProductViewModel::class.java)

        val type = intent.getStringExtra("type")
        if(type.equals("Edit"))
        {
            productId = intent.getIntExtra("productId",-1)
            val productName = intent.getStringExtra("productName")
            val productPrice = intent.getStringExtra("productPrice")

            editTextTextPersonName.setText(productName)
            editTextTextPersonName2.setText(productPrice)

            button.setText("Update product")

            button.setOnClickListener {

                val product = ProductModel(editTextTextPersonName.text.toString(),editTextTextPersonName2.text.toString())
                product.id = productId
                productViewModel.productUpdate(product)
                Toast.makeText(this,"Product updated successfully",Toast.LENGTH_LONG).show()
                finish()

            }
        }
        else
        {
            button.setText("Add product")
            button.setOnClickListener {
                productViewModel.productInsert(ProductModel(editTextTextPersonName.text.toString(),editTextTextPersonName2.text.toString()))
                Toast.makeText(this,"Product inserted successfully",Toast.LENGTH_LONG).show()
                finish()
            }
        }


    }
}