package week02.streams;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamsAPI {

  public static void main(String... args) {
    Stream<Integer> integers = Stream.of(1,2,3,4,5,6,7,8,9,10);

    integers.forEach(number -> System.out.println(number));

    List<Item> items = new ArrayList<>();
    items.add(new Item("Item1", new BigDecimal(10)));
    items.add(new Item("Item2", new BigDecimal(15)));
    Stream.of(items.toArray()).forEach(System.out::println);
    items.stream().forEach(System.out::println);


  }
}
