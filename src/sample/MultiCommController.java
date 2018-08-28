package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.*;

// TODO limit the lines count in the batch processing mode
public class MultiCommController {

    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Button add;
    @FXML
    private Button close;
    @FXML
    private TextArea multiCommand;
    private Stage stage;

    private Commands commands;


    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void handleAddMultiCommAction(ActionEvent event) {
        String batchCommands = multiCommand.getText();
        stage.close();
        batchCommands = batchCommands.replaceAll("[\r\n]+", "\n");
        String lines[] = batchCommands.split("\n");
        List<String> lineslist = Arrays.asList(lines);
        lineslist.sort(String.CASE_INSENSITIVE_ORDER);
        Iterator<String> iter=lineslist.iterator();
        while (iter.hasNext()) {
           commands.addCommandToList(iter.next());
        }

    }

    public void handleCloseMultiCommAction(ActionEvent event) {
        stage.close();

    }

    public void initialize() {
    }

    public Commands getCommands() {
        return commands;
    }

    public void setCommands(Commands commands) {
        this.commands = commands;
    }
}
