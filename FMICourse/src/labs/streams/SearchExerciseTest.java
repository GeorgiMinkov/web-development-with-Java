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
//        Order order1 = new Order(OrderStatus.ACTIVE);
//        Order order2 = new Order(OrderStatus.ACTIVE);
//        Order order3 = new Order(OrderStatus.DRAFT);
//        User user = new User(order1, order2, order3);
//        assertEquals(Arrays.asList(order1, order2), service.getActiveOrders(user));
    }

    @Test
    public void getOrderByIdTest() {

    }

    @Test
    public void getOrderByIdTest_When_id_not_found_Then_return_null() {

    }

    @Test
    public void hasActiveOrdersTest_true() {

    }

    @Test
    public void hasActiveOrdersTest_When_inactive_Then_return_false() {

    }

    @Test
    public void canBeReturnedTest_When_no_items_Then_return_true() {

    }

    @Test
    public void canBeReturnedTest_When_item_have_SO_Then_return_false() {

    }

    @Test
    public void getMaxPriceOrderTest() {

    }

    @Test
    public void getMaxPriceOrderTest_When_no_orders_Then_return_nothing() {

    }


}
