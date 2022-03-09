package lecture.week01;

public class SimpleMain {

//    private String message;
//
//    public SimpleMain() {
//        message = "default message";
//    }

    // object related functions
    private String extractMessage() {
        return "this is an object function";
    }

    void printMessage() {
        System.out.println(extractMessage());
    }

    // static related functions
    static private String extractMessageStatically() {
        return "this is a static function";
    }

    static void printMessageStatically() {
        System.out.println(extractMessageStatically());
    }

    public static void main(String[] args) {
        System.out.println("Hello General Kenobi");

        SimpleMain object = new SimpleMain();
        object.printMessage();

        SimpleMain.printMessageStatically();

//        StringBuilder stringBuilder = new StringBuilder();
//        for (int i = 1; i <= 4; ++i) {
//            for (int j = 0; j < i; ++j) {
//                stringBuilder.append("* ");
//            }
//            stringBuilder.append("\n");
//        }
//
//        System.out.println(stringBuilder.toString());
    }
}
