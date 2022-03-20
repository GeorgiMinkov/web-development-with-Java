package labs.week02.streams.entity;

import java.math.BigDecimal;

/**
 * Implement Item with description:String and price:BigDecimal
 */

public class Item {

    private final String description;
    private final BigDecimal price;

    public Item(String description, BigDecimal price) {
        this.description = description;
        this.price = price;
    }

    public final String getDescription() {
        return description;
    }

    public final BigDecimal getPrice() {
        return price;
    }
}
