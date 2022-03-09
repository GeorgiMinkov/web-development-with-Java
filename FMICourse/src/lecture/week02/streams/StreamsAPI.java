package lecture.week02.streams;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsAPI {

  public static void main(String... args) {
//    Stream<Integer> integers = Stream.of(1,2,3,4,5,6,7,8,9,10);
//
//    integers.forEach(number -> System.out.println(number));


    List<Item> items = new ArrayList<>();
    items.add(new Item("Item1", new BigDecimal(10)));
    items.add(new Item("Item2", new BigDecimal(15)));
    items.add(new Item("Testitem", new BigDecimal(20)));
    items.add(new Item("Testitem4", new BigDecimal(25)));
    items.add(new Item("FMI", new BigDecimal(20)));
    Stream.of(items.toArray()).forEach(System.out::println);
//    print all items
    items.stream().forEach(System.out::println);

//    print all items which have price >= 20
    items.stream()
        .filter(item -> item.getPrice().compareTo(new BigDecimal(20)) >= 0)
        .forEach(System.out::println);

    List<Item> collectItems = items.stream()
        .filter(item -> item.getPrice().compareTo(new BigDecimal(20)) >= 0)
        .collect(Collectors.toList());
//    find first and skip
    Optional<Item> first = items.stream().skip(2).findFirst();
    System.out.println(first.get());

    //find any
    Optional<Item> any = items.stream().findAny();
    System.out.println(any.get());


    //count
    long count = items.stream().skip(3).count();
    System.out.println(count);

    //map
    BigDecimal reduce = items.stream()
        .map(item -> item.getPrice()) // bigdecimal
        .reduce(new BigDecimal(0), (subtotal, element) -> subtotal.add(element));
    System.out.println(reduce);

    List<Item> collectItems2 = items.stream()
        .filter(item -> item.getPrice().compareTo(new BigDecimal(20)) >= 0)
        .collect(Collectors.toList());
    System.out.println(collectItems2);
    // reduce
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
    int result = numbers
        .stream()
        .reduce(0, (subtotal, element) -> subtotal + element);
    System.out.println(result);
  }
}
