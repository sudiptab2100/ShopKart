package com.micro.kart

import io.micronaut.serde.annotation.Serdeable
import org.bson.codecs.pojo.annotations.BsonProperty
import java.math.BigDecimal
import javax.validation.constraints.NotBlank

@Serdeable
class ItemQuote(
    @field:BsonProperty("itemID") @param:BsonProperty("itemID") @field:NotBlank val itemID: Int,
    @field:BsonProperty("quantity") @param:BsonProperty("quantity") @field:NotBlank val quantity: Int) {

    override fun toString(): String {
        return  "\nItemQuote {" +
                "\n\titemID: $itemID," +
                "\n\tquantity: $quantity," +
                "\n}";
    }
}
