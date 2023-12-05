package MathFunction;

import java.util.List;
import java.util.function.Function;

public class Inferencia {
    public static void main(String[] args) {
        Function<Integer, String> functionConvert = integer -> "Al doble: " + (integer * 2);

        List<String> listStudent = NameUtils.getList("Camilo", "Javier", "Leon");
        listStudent.forEach(System.out::println);
    }
}
