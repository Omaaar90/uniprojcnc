/* O.Asaad */

package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Controller  {

        private Map commandMap = new TreeMap();

        @FXML
        private Button hello;

        @FXML
        private Button btn1;

        @FXML
        private Button btn2;

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


        @FXML
        private void handlePlayAction(ActionEvent event) {
                Main.sayhello();
        }


        @FXML
        private void handleMultiCommandAction(ActionEvent event) throws IOException{

         /*       Stage stage;
                Parent root;

                if(event.getSource()==btn1)
                {
                        stage = new Stage();
                        root = FXMLLoader.load(getClass().getResource("MultiComm.fxml"));
                        stage.setScene(new Scene(root));
                        stage.initModality(Modality.APPLICATION_MODAL);
                        stage.initOwner(btn1.getScene().getWindow());
                        stage.showAndWait();
                }
                else
                {
                        stage=(Stage)btn2.getScene().getWindow();
                        stage.close();
                }

        }

           /*
               try {
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MultiComm.fxml"));
                        Parent root = fxmlLoader.load();
                        Stage stage = new Stage();
                        stage.setScene(new Scene(root));
                        stage.show();
                }
                catch (Exception e) {
                        System.err.println(e.getMessage());

                }
*/
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
        void handleAddMultiCommAction(ActionEvent event) {

        }

        @FXML
        void handleCloseMultiCommAction(ActionEvent event) {

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

