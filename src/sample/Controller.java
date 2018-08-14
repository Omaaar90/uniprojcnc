package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;

public class Controller {


        @FXML
        private Button hello;

        @FXML
        void hellothere(ActionEvent event) {
         Main.sayhello();
        }
    }


