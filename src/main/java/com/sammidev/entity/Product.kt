package com.sammidev.entity

data class Product(
        val productID: Long,
        val customerID: Customer,
        val productName: String,
        val productType: ProductType,
        val productAmount: Int,
        val price: Long
)

enum class ProductType {
    AKSESORIS,GADGET, PERIPHERAL, BEAUTY;
}