package MathFunction;

public class Chaining {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("juan")
                .append("hola")
                .append("como le va")
                .append("genial");


        Chainer chainer = new Chainer();
        chainer.sayHi().sayBye();

        Chainer chainer2 = chainer.sayHi();
        Chainer chainer3 = chainer.sayBye();

    }

    public static class Chainer{
        public Chainer sayHi() {
            System.out.println("Hola");
            return this;
        }

        public Chainer sayBye() {
            System.out.println("Bye");
            return this;
        }
    }
}
