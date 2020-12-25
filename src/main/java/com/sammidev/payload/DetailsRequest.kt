package com.sammidev.payload

import com.sammidev.entity.ProductType

data class DetailsRequest (
        val productID: Long,
        val customerID: Long,
        val productName: String,
        val productType: ProductType,
        val productAmount: Int,
        val price: Long,
)