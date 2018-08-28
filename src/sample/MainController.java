/* O.Asaad */

package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.util.Callback;
import javafx.concurrent.Task;


import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TreeMap;


public class MainController {
    Thread draw;
    boolean stop = false;
    @FXML
    Canvas canvas;
    @FXML
    Stage stage;
    private GraphicsContext graphicsContext;
    private Map commandMap = new TreeMap();
    private Interpreter interpreter = Interpreter.getInstance();
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Button hello;
    @FXML
    private Button btn1;

    @FXML
    private Button btn2;

    @FXML
    private TableView<Map.Entry<String, String>> commandTable;

    @FXML
    private TableColumn<Map.Entry<String, String>, String> positionColumn;

    @FXML
    private TableColumn<Map.Entry<String, String>, String> commandColumn;


    @FXML
    public void initialize() {
        graphicsContext = canvas.getGraphicsContext2D();
        interpreter.setGraphicsContext(graphicsContext);
        graphicsContext.setFill(Color.GRAY);
        graphicsContext.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        graphicsContext.setStroke(Color.BLACK);
        graphicsContext.setLineWidth(2);
        System.out.println(interpreter.isValidCommand("M00"));
        positionColumn.setCellValueFactory(p -> {
            // this callback returns property for just one cell, you can't use a loop here
            // for first column we use key
            return new SimpleStringProperty(p.getValue().getKey());

        });


        commandColumn.setCellValueFactory(p -> {
            // for second column we use value
            return new SimpleStringProperty(p.getValue().getValue());
        });
        ObservableList items = FXCollections.observableArrayList(commandMap.entrySet());
        commandTable.setItems(items);
    }


    @FXML
    private void handleMultiCommandAction(ActionEvent event) throws IOException {
/*

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("multiComm.fxml"));
        Parent root1 = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.show();
*/


        Parent root;
        if (event.getSource() == btn1) {
            stage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("MultiComm.fxml"));
            root = loader.load();
            MultiCommController multiCommController = loader.getController();
            multiCommController.setStage(stage);
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initOwner(btn1.getScene().getWindow());
            stage.showAndWait();
        } else {

        }
    }


    @FXML
    private void handlePlayAction(ActionEvent event) throws InterruptedException {
interpreter.translateCommand("G01 X10 Y10");
       /* Task draw = new Task<Void>() {
            @Override
            public Void call() throws InterruptedException {
                graphicsContext.beginPath();
                graphicsContext.lineTo(50, 70);
                Thread.sleep(100);
                graphicsContext.lineTo(150, 90);
                graphicsContext.stroke();
                return null;


            }
        };
        new Thread(draw).start();*/

    }

    @FXML
    private void handlePauseAction(ActionEvent event) {
//        System.out.println(Interpreter.isValidCommand("g01"));

    }

    @FXML
    private void handleStopAction(ActionEvent event) {
        stop = true;
    }


    @FXML
    void handleAddMultiCommAction(ActionEvent event) {

    }

    @FXML
    void handleCloseMultiCommAction(ActionEvent event) {
        //stage=(Stage)btn2.getScene().getWindow();


    }


    @FXML
    private void handleTextInput(KeyEvent ev) {

        if (ev.getCode().equals(KeyCode.ENTER)) {
            Object source = ev.getSource();
            if (source instanceof TextField) {
                TextField textfield = (TextField) source;
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
        if (!(commandStr == null) && !"".equals(commandStr)) {
            String[] splittedCommand = commandStr.split(" ", 2);
            if (splittedCommand.length == 2) {
                commandMap.put(splittedCommand[0], splittedCommand[1]);
                ObservableList<Map.Entry<String, String>> items = FXCollections.observableArrayList(commandMap.entrySet());
                commandTable.setItems(items);
            }
        }
    }

}


