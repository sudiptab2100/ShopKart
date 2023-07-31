package com.micro.shop

import com.google.gson.Gson
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.File

@Controller("/api")
open class OrderController(private val orderProducer: OrderProducer) {

    private val logger: Logger = LoggerFactory.getLogger(OrderController::class.java)

    @Get("/products")
    fun getAllProducts(): List<ProductClass> {
        val path = "shop/products.json"
        val gson = Gson()
        val jsonFile = File(path)
        val jsonStr = jsonFile.readText()

        return gson.fromJson(jsonStr, Array<ProductClass>::class.java).toList()
    }

    @Post("/order")
    fun produce(itemQuote: ItemQuote) {
        logger.debug("Event Received {}", itemQuote.toString())
        orderProducer.send(itemQuote.itemID, itemQuote)
    }
}