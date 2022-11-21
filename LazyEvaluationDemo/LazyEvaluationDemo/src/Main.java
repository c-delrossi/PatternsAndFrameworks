import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        var start = System.currentTimeMillis();
        var filtered = filter();
        var end = System.currentTimeMillis();

        System.out.println("Result: " + Arrays.toString(filtered) + ", Time: " + (end - start) + "ms");
    }

    public static int[] filter() {
        var stream = IntStream.range(0, 10);
        return stream.filter(Main::filterFunction).limit(3).toArray();
    }

    public static boolean filterFunction(int number) {
        try {
            Thread.sleep(1000);
            return number % 2 == 0;
        } catch (InterruptedException ex) {
            return false;
        }
    }
}