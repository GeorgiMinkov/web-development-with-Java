package lecture.week01.string;

public class StringExample {

    public static void main(String[] args) {
//        String first = new String("java");
//        String second = "Java";
//
//        System.out.println("Java" == second);
//        System.out.println(first.equalsIgnoreCase(second));
//        System.out.println("adsasd".equals(first));

        //        stringExamples();
        stringBuilderExamples();
    }

    static void stringExamples() {
        // create first string
        String first = "Java ";
        String ref = new String("asd");

        System.out.println("First String: " + first);

        String second = new String("Programming");
        System.out.println("Second String: " + second);

        // join two strings
        String joinedString = first.concat(second);
        System.out.println("Joined String version 1: " + joinedString);

        joinedString.concat(second);

        joinedString = joinedString + " " + second;
        System.out.println("Joined String version 2: " + joinedString);

        System.out.println(first + second);


        // --------------------
        first = "java programming";
        second = "java programming";
        String third = "python programming";

        // compare first and second strings

        boolean result1 = first.equals(second);
        System.out.println("Strings first and second are equal: " + result1);

        // compare first and third strings
        boolean result2 = first.equals(third);
        System.out.println("Strings first and third are equal: " + result2);

    }

    static void stringBuilderExamples() {
        StringBuilder stringBuilder = new StringBuilder("Test string");

        System.out.println("String = " + stringBuilder.toString());

        // reverse the string
        StringBuilder reverseStr = stringBuilder.reverse();

        // print string
        System.out.println("Reverse String = " + reverseStr.toString());
        System.out.println(reverseStr.equals(stringBuilder));

        stringBuilder.append(" some string");
        System.out.println("Modified StringBuilder = " + stringBuilder);

        // get capacity
        int capacity = stringBuilder.capacity();

        // print the result
        System.out.println("StringBuilder = " + stringBuilder);
        System.out.println("Capacity of StringBuilder = "
                + capacity);
    }
}
