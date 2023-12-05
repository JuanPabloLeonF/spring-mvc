package importante.lambdan;

import MathFunction.NameUtils;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class Sintaxis {
    public static void main(String[] args) {
        List<String> curses = NameUtils.getList("Java", "Functionality");

        curses.forEach(curse -> System.out.println(curse));

        BiFunction<Integer, Integer, Integer> biFunction = (number1, number2) -> number1 * number2;

        userZero(() -> 2);

        userPredicate(text -> text.isEmpty());

        userBiFunction((integer, integer2) -> integer * integer2);

        userBiFunction((integer, integer2) -> {
            System.out.println("numero 1: " + integer + " numero 2: " + integer2 );
            return integer - integer2;
        });

        userNever(() -> {
            System.out.println("Hola alumno");
        });

        userBiFunction((Integer integer, Integer integer2) -> integer * integer2);
    }

    public static void userPredicate(Predicate<String> predicate) {

    }

    public static void userZero(IZeroArguments iZeroArguments) {

    }

    public static void userBiFunction(BiFunction<Integer, Integer, Integer> biFunction) {

    }

    public static void userNever(IOperationNever iOperationNever) {

    }

    @FunctionalInterface
    interface IZeroArguments {
        Integer get();
    }

    @FunctionalInterface
    interface  IOperationNever {
        void never();
    }
}
