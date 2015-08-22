import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by vm033450 on 8/20/15.
 */
public class LamdaTest {

public static void main(String[] args) {

    //Using Arrays
    Cousin[] cousinsArray = new Cousin[]{new Cousin(8, "Manav"),
            new Cousin(15, "Milind"),
            new Cousin(20, "Nikhil"),
            new Cousin(25, "Gopi"),
            new Cousin(29, "Vinod")};

    Arrays.sort(cousinsArray, (c1, c2) -> c2.age - c1.age);
    System.out.println("From array");
    for (int i = 0; i < cousinsArray.length; i++) {
        System.out.println(cousinsArray[i]);
    }

    //Using List
    List<Cousin> cousinsList = Arrays.asList(cousinsArray);
    Collections.sort(cousinsList, (c1, c2) -> c2.age - c1.age);
    cousinsList.stream().forEach(System.out::println);
}

public static class Cousin {
    int age;
    String name;

    public Cousin(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Name = " + name + "  Age = " + age;
    }
}
}
