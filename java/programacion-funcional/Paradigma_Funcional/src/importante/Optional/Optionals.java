package importante.Optional;

import java.util.*;

public class Optionals {
    public static void main(String[] args) {
        List<String> names = getNames();
        if (!names.isEmpty()) {
        }

        Optional<List<String>> getListNameOptional = getOptionalListNames();
        if (getListNameOptional.isPresent()) {

        }

        getListNameOptional.ifPresent(namesValue -> namesValue.forEach(System.out::println));

        Optional<String> valueGetString = getOptionalString();

        String valueStringNew = valueGetString.orElseGet(() -> "No dato");

    }

    public static List<String> getNames() {
        List<String> listName = new ArrayList<>();
        return Collections.emptyList();
    }

    public static String showOneString() {
        return null;
    }

    public static Integer getInteger() {
        return null;
    }

    public static Optional<List<String>> getOptionalListNames() {
        List<String> namesList = new LinkedList<>();
        return Optional.of(namesList);
    }

    public static Optional<String> getOptionalString() {
        //return Optional.ofNullable();
        try {
            return Optional.of("Juan");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }
}
