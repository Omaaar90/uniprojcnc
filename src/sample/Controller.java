/*writeen by O.Asaad*/

package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.util.Callback;

import java.util.Map;
import java.util.TreeMap;

public class Controller {

        private Map commandMap = new TreeMap();

        @FXML
        private Button hello;

        @FXML

        private TableView<Map.Entry<String,String>> commandTable ;

        @FXML
        private TableColumn<Map.Entry<String, String>, String> positionColumn;

        @FXML
        private TableColumn<Map.Entry<String, String>, String> commandColumn;

        @FXML
        public void initialize() {
                /*
                commandMap.put("N01","G01");
                commandMap.put("N02","G02");
                 */
                positionColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Map.Entry<String, String>, String>, ObservableValue<String>>() {

                        @Override
                        public ObservableValue<String> call(TableColumn.CellDataFeatures<Map.Entry<String, String>, String> p) {
                                // this callback returns property for just one cell, you can't use a loop here
                                // for first column we use key
                                return new SimpleStringProperty(p.getValue().getKey());
                        }
                });

                commandColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Map.Entry<String, String>, String>, ObservableValue<String>>() {

                        @Override
                        public ObservableValue<String> call(TableColumn.CellDataFeatures<Map.Entry<String, String>, String> p) {
                                // for second column we use value
                                return new SimpleStringProperty(p.getValue().getValue());
                        }
                });

                ObservableList<Map.Entry<String, String>> items = FXCollections.observableArrayList(commandMap.entrySet());
                commandTable.setItems(items);
        }

        void hellothere(ActionEvent event) {
         Main.sayhello();
        }
    }

        @FXML
        private void handleEnterAction(ActionEvent event) {

        }


        @FXML
        private void handlePlayAction(ActionEvent event) {
                Main.sayhello();
        }

        @FXML
        private void handlePauseAction(ActionEvent event) {
                Main.sayhello();
        }

        @FXML
        private void handleStopAction(ActionEvent event) {
                Main.sayhello();
        }

        @FXML
        private void handleTextInput(KeyEvent ev) {

                if (ev.getCode().equals(KeyCode.ENTER)) {
                        Object source=ev.getSource();
                        if (source instanceof TextField) {
                                TextField textfield=(TextField)source;
                                addCommandToList(textfield.getText());
                                textfield.setText("");
                        }


                }
        }

        public Map getCommandMap() {
                return commandMap;
        }

        public void setCommandMap(Map commandMap) {
                this.commandMap = commandMap;
        }

        public void addCommandToList(String commandStr) {
                if (!(commandStr==null) && !"".equals(commandStr)) {
                        String[] splittedCommand = commandStr.split(" ", 2);
                        if (splittedCommand.length==2) {
                                commandMap.put(splittedCommand[0],splittedCommand[1]);
                                ObservableList<Map.Entry<String, String>> items = FXCollections.observableArrayList(commandMap.entrySet());
                                commandTable.setItems(items);
                        }
                }
        }
}

