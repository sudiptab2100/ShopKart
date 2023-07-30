package com.micro.shop

import io.micronaut.configuration.kafka.annotation.KafkaListener
import io.micronaut.configuration.kafka.annotation.Topic
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@KafkaListener(
    clientId = "shopkart-order-consumer",
    groupId = "order-consumer",
    batch = true
)
class OrderConsumer {

    private val logger: Logger = LoggerFactory.getLogger(OrderConsumer::class.java)
    @Topic("order-producer")
    fun receive(itemQuotes: List<ItemQuote>) {
        logger.debug("Consuming Orders {}", itemQuotes.toString())
    }
}