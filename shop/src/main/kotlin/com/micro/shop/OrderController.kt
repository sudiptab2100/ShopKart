package com.micro.shop

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@Controller("/api")
open class OrderController(private val orderProducer: OrderProducer) {

    private val logger: Logger = LoggerFactory.getLogger(OrderController::class.java)

    @Post("/order")
    fun produce(itemQuote: ItemQuote) {
        logger.debug("Event Received {}", itemQuote.toString())
        orderProducer.send(itemQuote.itemID, itemQuote)
    }
}