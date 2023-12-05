package MathFunction;

import java.util.function.Function;

public class MathOperation2 {
    public static void main(String[] args) {
        Function<Integer, Integer> multiplyByThree = (number1) -> {
            System.out.println("Multiplicando: " + number1 + " por 3");
            return number1 * 3;
        };

        Function<Integer, Integer> addMultiplyByThree = multiplyByThree.compose(number -> {
            System.out.println("Le agregare 1 a : " + number);
            return number + 1;
        });

        Function<Integer, Integer> divideByTwo = addMultiplyByThree.andThen( number -> {
            System.out.println("Dividiendo: " + number + " entre 2");
            return number/2;
            }
        );

        System.out.println(divideByTwo.apply(5));
    }
}
