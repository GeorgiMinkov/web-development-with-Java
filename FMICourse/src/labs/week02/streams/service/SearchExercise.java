package labs.week02.streams.service;

import labs.week02.streams.entity.Order;
import labs.week02.streams.entity.OrderLine;
import labs.week02.streams.entity.User;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

public class SearchExercise {

    /**
     * extract all active orders
     * @param user
     * @return List<Order>
     */
    public List<Order> getActiveOrders(User user) {
        return user.getOrders().stream()
                .filter(Order::isActive)
                .collect(toList());
    }

    public List<Order> getActiveOrdersByIteration(User user) {
        List<Order> orderList = new ArrayList<>();
        for (Order order : user.getOrders()) {
            if (order.isActive()) {
                orderList.add(order);
            }
        }
        return orderList;
    }

    /**
     * Return order by a specific id
     * @param orders
     * @param orderId
     * @return Order
     */
    public Order getOrderById(List<Order> orders, long orderId) {
        return orders.stream()
                .filter(order -> order.getId() == orderId)
                .findFirst()
                .orElse(null);
        // if you want to throw exception:
        // .orElseThrow(() -> new MyException(MYErrorCode.NO_ORDER, orderId));
    }

    public Order getOrderByIdIteration(List<Order> orders, long orderId) {
        for (Order order : orders) {
            if (order.getId() == orderId) {
                return order;
            }
        }
        return null;
    }

    /**
     * Return orders that have specific description for item
     * @param user
     * @param description
     * @return List<Order>
     */
    public List<Order> getOrdersThatHaveItemDescription(User user, String description) {
        return user.getOrders().stream()
                .filter(el -> !el.getOrderLines()
                        .stream()
                        .filter(orderLine -> description.equals(orderLine.getItem().getDescription()))
                        .findAny().isEmpty()
                )
                .collect(toList());
    }

    /**
     * @return true if customer has at least one order with status ACTIVE
     */
    public boolean hasActiveOrders(User user) {
        return user.getOrders().stream()
                .anyMatch(Order::isActive);
    }

    /**
     * Return true if inside the Order we don't have OrderLine with special offer
     */
    public boolean canBeReturned(Order order) {
        return order.getOrderLines().stream()
                .noneMatch(OrderLine::isSpecialOffer);
    }

    /**
     * Return the order with maximum total price
     * @param user
     * @return
     */
    public Optional<Order> getMaxPriceOrder(User user) {
        return user.getOrders().stream()
                .max(Comparator.comparing(Order::getTotalPrice));
    }
}
