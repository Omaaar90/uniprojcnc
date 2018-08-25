package sample;

import java.util.Arrays;
import java.util.List;

public class Interpreter {
    private static Interpreter instance = null;
    private Interpreter() {
    }
    public static Interpreter getInstance() {
        if(instance == null) {
            instance = new Interpreter();
        }
        return instance;
    }
    final List<String> validCommands = Arrays.asList("G00", "G01", "G02", "G03", "G28", "M00", "M02", "M03", "M04", "M05");

     boolean isValidCommand(String command) {
        boolean isValid = validCommands.stream().anyMatch(command::equalsIgnoreCase);
        return isValid;
    }

    void translateCommand(String line){

    }

}


