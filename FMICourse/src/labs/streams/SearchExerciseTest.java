package labs.streams;

import labs.entity.Order;
import labs.entity.OrderLine;
import labs.entity.User;
import labs.vo.OrderStatus;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static java.time.LocalDate.now;
import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;

public class SearchExerciseTest {

    private SearchExercise service = new SearchExercise();

    @Test
    public void getActiveOrdersTest() {
        Order order1 = new Order(OrderStatus.ACTIVE);
        Order order2 = new Order(OrderStatus.ACTIVE);
        Order order3 = new Order(OrderStatus.DRAFT);
        User user = new User(order1, order2, order3);
        assertEquals(Arrays.asList(order1, order2), service.getActiveOrders(user));
    }

    @Test
    public void getOrderByIdTest() {
        List<Order> orders = Arrays.asList(new Order(1L), new Order(2L), new Order(3L));
        assertEquals(2L, (long) service.getOrderById(orders, 2L).getId());
    }

    @Test
    public void getOrderByIdTest_When_id_not_found_Then_return_null() {
        List<Order> orders = Arrays.asList(new Order(1L));
        assertEquals(null, service.getOrderById(orders, 1000L));
    }

    @Test
    public void hasActiveOrdersTest_true() {
        User user = new User(new Order(OrderStatus.INACTIVE), new Order(OrderStatus.ACTIVE));
        assertTrue(service.hasActiveOrders(user));
    }

    @Test
    public void hasActiveOrdersTest_When_inactive_Then_return_false() {
        User user = new User(new Order(OrderStatus.INACTIVE));
        assertFalse(service.hasActiveOrders(user));
    }

    @Test
    public void canBeReturnedTest_When_no_items_Then_return_true() {
        Order order = new Order(new OrderLine());
        assertTrue(service.canBeReturned(order));
    }

    @Test
    public void canBeReturnedTest_When_item_have_SO_Then_return_false() {
        OrderLine specialOffer = new OrderLine().setSpecialOffer(true);
        Order order = new Order(specialOffer, new OrderLine());
        assertFalse(service.canBeReturned(order));
    }

    @Test
    public void getMaxPriceOrderTest() {
        LocalDate yesterday = now().minusDays(1);
        Order order1 = new Order().setTotalPrice(BigDecimal.ONE).setCreationDate(now());
        Order order2 = new Order().setTotalPrice(BigDecimal.TEN).setCreationDate(yesterday);
        assertEquals(order2, service.getMaxPriceOrder(new User(order1, order2)).get());
    }

    @Test
    public void getMaxPriceOrderTest_When_no_orders_Then_return_nothing() {
        assertFalse(service.getMaxPriceOrder(new User()).isPresent());
    }


}
