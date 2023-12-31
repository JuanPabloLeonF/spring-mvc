package com.platzi.jobsearch;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class CommanderFunction {
    public static <T> JCommander buiildCommanderWithName(String cliName, Supplier<T> argumentsSupplier) {
        JCommander jCommander = JCommander.newBuilder().addObject(argumentsSupplier.get())
                .build();

        jCommander.setProgramName(cliName);
        return jCommander;
    }

    public static Optional<List<Object>> parseArguments(JCommander jCommander, String[] arguments, Consumer<JCommander> jCommanderConsumer) {

        try {
            jCommander.parse(arguments);
            return Optional.of(jCommander.getObjects());
        } catch (ParameterException e) {
            //onError.accept(jCommander);
        }
        return Optional.empty();
    }
}
