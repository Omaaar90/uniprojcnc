package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MultiCommController {
    public AnchorPane anchorPane;
    public Button add;
    public Button close;

    @FXML
    public void handleAddMultiCommAction(ActionEvent event) {
    }

    public void handleCloseMultiCommAction(ActionEvent event) {
        // get a handle to the stage
        Stage stage = (Stage) close.getScene().getWindow();
        // do what you have to do

        stage.close();

    }

    public void initialize() {
    }
}
