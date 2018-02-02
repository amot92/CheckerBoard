/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkerboard;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author adammoakes
 */
public class CheckerBoardFXMLController implements Initializable {

    private Stage stage;
    private int numRows;
    private int numCols;
    private Color lightColor;
    private Color darkColor;
    private grid.CheckerBoard checkerBoard;
    
    
    @FXML
    private VBox vBox;
    
    @FXML
    private MenuBar menuBar;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        numRows = 8;
        numCols = 8;
    }

    public void start(Stage stage){
        this.stage = stage;
        
        checkerBoard = new grid.CheckerBoard(numRows, numCols, stage.getWidth(), stage.getHeight() - menuBar.getHeight());
        vBox.getChildren().add(checkerBoard.getBoard());
        
        ChangeListener<Number> lambdaChangeListener = (ObservableValue<? extends Number> observable, Number oldValue, final Number newValue) -> {
            refresh();
        };
        
        this.stage.widthProperty().addListener(lambdaChangeListener);
        this.stage.heightProperty().addListener(lambdaChangeListener);
        
        
        refresh();
        
    }
    
    @FXML
    private void handleSizeChange(ActionEvent event){
        MenuItem menuItem = (MenuItem) event.getSource();
        System.out.println(menuItem.getText());
        
    }
    
    @FXML
    private void switchToRed(ActionEvent event){
        clear(); //why is this necessary??
        checkerBoard = new grid.CheckerBoard(numRows, numCols, stage.getWidth(), stage.getHeight() - menuBar.getHeight());
        vBox.getChildren().add(checkerBoard.getBoard());
        refresh();
    }
    
    @FXML
    private void switchToBlue(ActionEvent event){
        clear();//why is this necessary??
        checkerBoard = new grid.CheckerBoard(numRows, numCols, stage.getWidth(), stage.getHeight() - menuBar.getHeight(), Color.SKYBLUE, Color.DARKBLUE);
        vBox.getChildren().add(checkerBoard.getBoard());
        refresh();
    }
    
    @FXML
    private void clear(ActionEvent event){
        checkerBoard.clear();
    }
    
     private void clear(){
        checkerBoard.clear();
    }
    
    private void refresh() {
        clear();
        checkerBoard.build(stage.getWidth(), stage.getHeight() - menuBar.getHeight());
    }
    
    
}
