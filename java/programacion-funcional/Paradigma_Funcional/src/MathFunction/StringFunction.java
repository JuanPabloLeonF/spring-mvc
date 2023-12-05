package MathFunction;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class StringFunction {

    public static void main(String[] args) {
        UnaryOperator<String> quote = text -> "'" + text + "'";
        UnaryOperator<String> addMark = text -> text + "!";

        System.out.println(quote.apply("Hola"));
        System.out.println(addMark.apply(quote.apply("Hola men")));

        BiFunction<Integer, Integer, Integer> multiplication = (x, y) -> x * y;

        System.out.println(multiplication.apply(3, 6));

        BinaryOperator<Integer> multiplicationBinaryOperator = (x, y) -> x * y;

        BiFunction<String, Integer, String> leftPad = (text, x) -> String.format("%" + x  +"s", text);

        System.out.println(leftPad.apply("Java", 20));

        List<BiFunction<String, Integer, String>> formateator;
    }
}
