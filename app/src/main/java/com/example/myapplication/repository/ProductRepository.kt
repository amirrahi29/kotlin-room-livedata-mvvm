package com.example.myapplication.repository

import androidx.lifecycle.LiveData
import com.example.myapplication.db.ProductDao
import com.example.myapplication.model.ProductModel

class ProductRepository(private val productDao: ProductDao) {

    val getAllProduct:LiveData<List<ProductModel>> = productDao.getAllProducts()

    suspend fun insert(productModel: ProductModel){
        productDao.insert(productModel)
    }

    suspend fun update(productModel: ProductModel){
        productDao.update(productModel)
    }

    suspend fun delete(productModel: ProductModel){
        productDao.delete(productModel)
    }

}