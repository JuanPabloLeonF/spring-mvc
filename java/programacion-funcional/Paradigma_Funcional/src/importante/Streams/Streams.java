package importante.Streams;

import MathFunction.NameUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Streams {
    public static void main(String[] args) {
        List<String> curseList = NameUtils.getList("Java", "Frontend", "SQL");
        for (String element:curseList) {
            String newCourseName = element.toLowerCase().replace("!", "!!");
            System.out.println("element = " + newCourseName);
        }

        Stream<String> courseStream = Stream.of("Java", "Frontend", "SQL");
        Stream<Integer>lengthCourseList =  courseStream.map(course -> course.length());

        Optional<Integer> longest = lengthCourseList.max((x, y) -> y - x);

        Stream<String> emphasisCourses = curseList.stream()
                .map(course -> course + "!")
                .filter(course -> course.contains("Java"));
        emphasisCourses.forEach(System.out::println);

        System.out.println("#########################################3");
        Stream<String> courseStreamsNew = curseList.stream();
        addOperator(
            courseStreamsNew
                    .map(course -> course + "!!")
                    .filter(course -> course.contains("!"))
        ).forEach(System.out::println);

    }

    public static <T> Stream<T> addOperator(Stream<T> stream) {
        return stream.peek(data -> System.out.println("Dato: " + data));
    }
}
