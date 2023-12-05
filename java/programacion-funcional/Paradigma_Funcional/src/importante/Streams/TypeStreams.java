package importante.Streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TypeStreams {
    public static void main(String[] args) {
        IntStream infiniteStream = IntStream.iterate(1, number -> number + 1);
        List<Integer> listInteger =  infiniteStream
                .limit(100)
                .filter(number -> number % 2 == 0)
                .boxed()
                .collect(Collectors.toList());

        listInteger.stream().forEach(System.out::println);
    }
}
