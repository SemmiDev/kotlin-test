package com.sammidev.validation

import com.sammidev.entity.ProductType

class ProductValidation {
    fun productNameAndCustomerNameValidator(productName: String): Boolean {
        return productName.length < 30
    }
    fun productAmountValidator(productAmount: Int): Boolean {
        return productAmount < 40
    }
    fun productTypeValidator(productType: String): Boolean {
       if (productType == ProductType.BEAUTY.toString() ||
               productType == ProductType.AKSESORIS.toString() ||
               productType == ProductType.GADGET.toString() ||
               productType == ProductType.PERIPHERAL.toString()) {
           return true
       }
        return false
    }
}