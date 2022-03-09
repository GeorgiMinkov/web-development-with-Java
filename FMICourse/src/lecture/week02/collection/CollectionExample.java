package lecture.week02.collection;

import lecture.week02.inheritance.Cat;

import java.util.*;

public class CollectionExample {

    private void defineListCollection() {
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        printCollection(list);


        list = Arrays.asList("four", "five", "six");
        printCollection(list);

        list = new LinkedList<>();
        list.add("seven");
        list.add("eight");
        list.add("nine");
        printCollection(list);

        List<Integer> integerList = Arrays.asList(156, 256, 356);
        printCollection(integerList);

        Set<String> set = new HashSet<>();
        set.add("asd");

    }

    private <T> void printCollection(final Collection<T> collection) {
        for (T element : collection) {
            System.out.println(element);
        }

        System.out.println("----------with explicit iterator-------------");
        Iterator<T> iterator = collection.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }


        System.out.println("-----------------------");


//        collection = new ArrayList<>(); //you cannot do this when final keyword is present
    }

    private void defineMapCollection() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "one");
        map.put(Integer.valueOf(2), "two");
        map.put(3, "three");
        printMap(map);

        if (map.containsKey(Integer.valueOf("2"))) {
            System.out.println("there is a key with value 2");
        }

        String value = map.get(Integer.valueOf(2));
        System.out.println("value of 2 -> " + value);

        value = map.get(4);
        System.out.println("value of 2 -> " + value);
    }

    private void printMap(final Map<Integer, String> map) {
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(String.format("%d - %s", entry.getKey(), entry.getValue()));
        }

//        map.entrySet().stream().forEach(System.out::println);
    }

    private void hashCodeExample() {
        Cat cat = new Cat();
        Cat cat1 = new Cat();

        Map<Cat, String> catStringMap = new HashMap<>();
        catStringMap.put(cat, "tabby");

        System.out.println(cat.hashCode());
        System.out.println(cat1.hashCode());

        catStringMap.put(cat1, "asd");

        catStringMap.entrySet().stream().forEach(System.out::println);
    }

    public static void main(String[] args) {
        CollectionExample collectionExample = new CollectionExample();
//        collectionExample.defineListCollection();

//        collectionExample.defineMapCollection();
//
        collectionExample.hashCodeExample();
    }
}
