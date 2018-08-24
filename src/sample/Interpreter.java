package sample;

import java.util.Arrays;
import java.util.List;

public abstract class Interpreter {
    final static List<String> validCommands = Arrays.asList("G00", "G01", "G02", "G03", "G28", "M00", "M02", "M03", "M04", "M05");

    static boolean isValidCommand(String command) {
        boolean isValid = validCommands.stream().anyMatch(command::equalsIgnoreCase);
        return isValid;
    }

}


