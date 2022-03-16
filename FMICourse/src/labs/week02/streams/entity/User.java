package labs.week02.streams.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Create a class User with list of orders
 */
public class User {
    private List<Order> orders;

    public User() {
        this.orders = new ArrayList<>();
    }

    public User(Order... orders) {
        this.orders = Arrays.asList(orders);
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

}
