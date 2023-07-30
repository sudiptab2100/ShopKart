package com.micro.shop

import io.micronaut.configuration.kafka.annotation.KafkaClient
import io.micronaut.configuration.kafka.annotation.KafkaKey
import io.micronaut.configuration.kafka.annotation.Topic
import java.math.BigDecimal

@KafkaClient
interface OrderProducer {

    @Topic("order-producer")
    fun send(@KafkaKey itemID: Int, itemQuote: ItemQuote)
}