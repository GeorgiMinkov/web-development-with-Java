package labs.entity;

import labs.vo.OrderStatus;
import labs.vo.PaymentMethod;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.joining;

/** Create class Order that implements
 * id, status:OrderStatus, creationDate, totalPrice, paymentMethod,
 * deliveryDueDate, user
 *
 * Implements constructors: default by status, by id, by array of lines (use ...)
 * getters, setters, toString, isActive
 */
public class Order {
    private Long id;
    private OrderStatus status;
    private List<OrderLine> orderLines;
    private LocalDate creationDate;
    private BigDecimal totalPrice;
    private PaymentMethod paymentMethod;

    private LocalDate deliveryDueDate;
    private User user;

    public Order() {
    }

    public Order(OrderStatus status) {
        this.status = status;
    }

    public Order(Long id) {
        this.id = id;
    }

    public Order(OrderLine... lines) {
        this.orderLines = Arrays.asList(lines);
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

    public boolean isActive() {
        return status == OrderStatus.ACTIVE;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public Order setStatus(OrderStatus status) {
        this.status = status;
        return this;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public Order setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public Order setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
        return this;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public Order setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
        return this;
    }

    public LocalDate getDeliveryDueDate() {
        return deliveryDueDate;
    }

    public Order setDeliveryDueDate(LocalDate deliveryDueDate) {
        this.deliveryDueDate = deliveryDueDate;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Order setCustomer(User user) {
        this.user = user;
        return this;
    }

    public String toString() {
        List<String> details = new ArrayList<>();
        details.add("user=" + user.toString());

        if (creationDate != null) {
            details.add("created="+creationDate);
        }

        String detailsStr = details.stream().collect(joining(", "));
        return "Order { " + detailsStr + " }";
    }
}
