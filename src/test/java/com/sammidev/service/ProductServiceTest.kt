package com.sammidev.service

import com.sammidev.entity.Product
import com.sammidev.entity.ProductType
import com.sammidev.entity.Student
import com.sammidev.payload.DetailsRequest
import com.sammidev.payload.DetailsResponse
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import kotlin.test.assertEquals

@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)
class ProductServiceTest {

    var productService = ProductService()

    @BeforeAll
    fun setUp() {
        val products = listOf<DetailsRequest>(
            DetailsRequest(0,0,"laptop",ProductType.GADGET,12,200000),
            DetailsRequest(1,1,"hp",ProductType.GADGET,12,200000),
            DetailsRequest(2,2,"mouse",ProductType.PERIPHERAL,12,200000),
            DetailsRequest(3,3,"mouse",ProductType.PERIPHERAL,12,200000),
            DetailsRequest(4,4,"proci i9",ProductType.GADGET,12,200000)
        )

        for (i in products.indices) {
            productService.createProduct(products[i])
        }
    }


    @Test
    fun testGetProductByProductID2() {
        val listOfProduct = this.productService.findAllProduct()
        val expected =  DetailsResponse(1,1,"hp",ProductType.GADGET,12,200000,(12 * 200000))
        assertEquals(expected, listOfProduct[1])
    }


}