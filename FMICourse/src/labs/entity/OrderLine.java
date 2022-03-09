package labs.entity;

import labs.vo.OrderLineStatus;

/**
 * Create OrderLine which holds information for:
 * Product, enum for status, boolean specialOffer and count
 * Implement setters/getters/constructor
 */
public class OrderLine {

    private Item item;
    private int count;
    private boolean specialOffer;
    private OrderLineStatus status;

    public OrderLine() {
    }

    public OrderLine(Item item, int count) {
        this.item = item;
        this.count = count;
    }

    public OrderLine(OrderLineStatus status) {
        this.status = status;
    }

    public boolean isSpecialOffer() {
        return specialOffer;
    }

    public OrderLine setSpecialOffer(boolean specialOffer) {
        this.specialOffer = specialOffer;
        return this;
    }

    public Item getItem() {
        return item;
    }

    public void setProduct(Item item) {
        this.item = item;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public OrderLineStatus getStatus() {
        return status;
    }

    public void setStatus(OrderLineStatus status) {
        this.status = status;
    }

    public boolean wasDelivered() {
        return true;
    }
}
