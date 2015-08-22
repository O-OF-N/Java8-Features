import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by vm033450 on 8/21/15.
 */
public class PredicateTest {
//Takes any type as input. However returns only boolean as output.
private static <T> T findMatch(List<T> list, Predicate<T> matchFunction) {
    for (T l : list) {
        if (matchFunction.test(l)) {
            return l;
        }
    }
    return null;
}

public static void main(String[] args) {

    System.out.println("args = " + findMatch(Arrays.asList(new Integer[]{1,
            2, 3, 4}), (i) -> i > 2));

}
}
