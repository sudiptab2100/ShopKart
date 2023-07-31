package com.micro.shop

import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class ProductClass(val itemID: Int, val itemName: String, val price: Int, val count: Int)
