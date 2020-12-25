package com.sammidev.repository

import com.sammidev.entity.Customer
import com.sammidev.entity.Product
import com.sammidev.payload.DetailsRequest
import com.sammidev.payload.DetailsResponse

interface ProductRepository {
    fun createProduct(detailsRequest: DetailsRequest)
    fun findAllProduct(): List<DetailsResponse>
    fun findProductById(id: Long): DetailsResponse
    fun updateProduct(id: Long, product: Product): DetailsResponse
    fun deleteProductById(id: Long): DetailsResponse
    fun deleteProduct(product: Product): DetailsResponse
}