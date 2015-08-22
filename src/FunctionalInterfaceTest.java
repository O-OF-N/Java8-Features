import java.util.function.BiFunction;

/**
 * Created by vm033450 on 8/21/15.
 */
public class FunctionalInterfaceTest {

public static int add(int i, int j) {
    return i + j;
}

public static void main(String[] args) {
    sum((i, j) -> i + j, 5, 6);
    sumUsingFunction((i, j) -> i + j, 6, 7);
    sum(FunctionalInterfaceTest::add, 7, 8);
    sumUsingFunction(FunctionalInterfaceTest::add, 9, 10);
}

public static void sumUsingFunction(BiFunction<Integer, Integer, Integer> func,
                                    int i, int j) {
    System.out.println(func.apply(i, j));
}

public static void sum(FuncInt add, int i, int j) {
    System.out.println(add.add(i, j));
}

@FunctionalInterface
public interface FuncInt {
    int add(int a, int b);
}
}
