package MathFunction;

public class StringFunctionNew {

    public static void main(String[] args) {
        IStringOperation six = () -> 6;

        six.operate("Alumno");

        IDoOperation operationFive = text -> System.out.println(text);

        operationFive.execute(5, "andres");
    }

    @FunctionalInterface
    interface  IStringOperation {
        Integer getAmount();

        default void operate(String text) {
            Integer number = getAmount();

            while (number-- > 0) {
                System.out.println(text);
            }
        }
    }

    @FunctionalInterface
    interface IDoOperation {
        void take(String text);

        default  void execute(Integer x, String text) {

            while (x-- > 0) {
                take(text);
            }
        }
    }
}
