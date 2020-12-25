package com.sammidev.service

import com.sammidev.entity.Product
import com.sammidev.payload.DetailsRequest
import com.sammidev.payload.DetailsResponse
import com.sammidev.repository.ProductRepository
import com.sammidev.validation.ProductValidation

class ProductService : ProductRepository {

    var cartDetails = mutableListOf<DetailsResponse>()

    override fun createProduct(detailsRequest: DetailsRequest) {

        require(ProductValidation().productNameAndCustomerNameValidator(detailsRequest.productName))
        require(ProductValidation().productTypeValidator(detailsRequest.productType.toString()))
        require(ProductValidation().productAmountValidator(detailsRequest.productAmount))

        val resp = DetailsResponse(
                detailsRequest.productID,
                detailsRequest.customerID,
                detailsRequest.productName,
                detailsRequest.productType,
                detailsRequest.productAmount,
                detailsRequest.price,
                detailsRequest.price * detailsRequest.productAmount
        )

        this.cartDetails.add(detailsRequest.productID.toInt(), resp)
    }

    override fun findAllProduct(): List<DetailsResponse> {
        return this.cartDetails
    }

    override fun findProductById(id: Long): DetailsResponse {
        TODO()
    }

    override fun updateProduct(id: Long, product: Product): DetailsResponse {
        TODO()
    }

    override fun deleteProductById(id: Long): DetailsResponse {
        TODO()
    }

    override fun deleteProduct(product: Product): DetailsResponse {
        TODO()
    }

}