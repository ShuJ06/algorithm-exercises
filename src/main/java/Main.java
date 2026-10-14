import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            final int threshold = i;
            IntPredicate greaterThanThreshold = (x) -> x > threshold;
            boolean result = IntStream.of(1, 2, 3).anyMatch(greaterThanThreshold);
            System.out.println("Greater than" + threshold + ": " + result);
        }
    }
}
