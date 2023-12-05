package MathFunction;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class CLIArgumentsUtils {

    public static void showHelp(CLIArguments cliArguments) {
        Consumer<CLIArguments> consumerHelp = cliArguments1 -> {
            if (cliArguments1.getHelp());
            System.out.println("Manual ha sido solicitado");
        };

        consumerHelp.accept(cliArguments);
    }

    public static CLIArguments generateCLI() {
        Supplier<CLIArguments>  generator = () -> new CLIArguments();

        return generator.get();
    }
}
