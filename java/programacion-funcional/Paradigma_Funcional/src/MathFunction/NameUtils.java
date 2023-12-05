package MathFunction;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class NameUtils {

    public static void main(String[] args) {
        List<String> nameList = getList("juan", "nicolas", "ramiro", "felipe");

        Consumer<String> printer = text -> System.out.println(text);
        nameList.forEach(printer);
        System.out.println("#################################3");
        nameList.forEach(System.out::println);
    }

    public static <T> List<T> getList(T... elements) {
        return Arrays.asList(elements);
    }
}
