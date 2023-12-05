package MathFunction;

import java.util.function.Function;
import java.util.function.Predicate;

public class MathFunction {
    public static void main(String[] args) {

        Function<Integer, Integer> squareFunction = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer x) {
                return x * x;
            }
        };

        System.out.println(squareFunction.apply(3));

        Function<Integer, Integer> squareFunctionShort = ( x -> x * x);
        Function<Integer, Boolean> isOdd = x -> x % 2 == 1;

        System.out.println(isOdd.apply(2));
        System.out.println(squareFunctionShort.apply(9));

        Predicate<Integer> isEven = ( x -> x % 2 == 0);
        System.out.println(isEven.test(5));

        Predicate<Student> isApproved = ( student -> student.getNote() > 6.0);

        Student juan = new Student(4.9);

        System.out.println(isApproved.test(juan));
    }

    private static class Student {
        private Double note;

        public Student(Double note) {
            this.note = note;
        }

        public Double getNote() {
            return note;
        }

        public void setNote(Double note) {
            this.note = note;
        }
    }
}
