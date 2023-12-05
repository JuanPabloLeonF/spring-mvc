package MathFunction;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

public class AgeUtil {

    public static void main(String[] args) {

        Function<Integer, String> addCero = (x) -> x < 10 ? "0" + x : String.valueOf(x);

        TriFunction<Integer,Integer,Integer, LocalDate> parseDate =
                (day, month, year) -> LocalDate.parse(year + "-" + addCero.apply(month) + "-" + addCero.apply(day));

        TriFunction<Integer, Integer, Integer, Integer> calculateAge =
                (day, month, year) -> Period.between(
                        parseDate.apply(day, month, year), LocalDate.now()
                ).getYears();

        System.out.println(calculateAge.apply(10, 10, 1992));
    }

    @FunctionalInterface
    interface  TriFunction<T, U, V, R> {
        R apply(T t, U u, V v);
    }
}
