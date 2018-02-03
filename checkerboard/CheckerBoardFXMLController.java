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
        lightColor = Color.RED;
        darkColor = Color.BLACK;
    }

    public void start(Stage stage){
        this.stage = stage;
        switchBoard();
        
        ChangeListener<Number> lambdaChangeListener = (ObservableValue<? extends Number> observable, Number oldValue, final Number newValue) -> {
            refresh();
        };
        
        this.stage.widthProperty().addListener(lambdaChangeListener);
        this.stage.heightProperty().addListener(lambdaChangeListener);
        
    }
    
    private void switchBoard(){
        if(checkerBoard != null){
            clear();
        }
        checkerBoard = new grid.CheckerBoard(numRows, numCols, stage.getWidth(), computeBoardHeight(), lightColor, darkColor);
        vBox.getChildren().add(checkerBoard.getBoard());
    }
    
    private double computeBoardHeight(){
        return stage.getScene().getHeight() - menuBar.getHeight();
    }
    
    @FXML
    private void switchToLargeBoard(ActionEvent event){
        numRows = 16;
        numCols = 16;
        switchBoard();
    }
    
    @FXML
    private void switchToMediumBoard(ActionEvent event){
        numRows = 10;
        numCols = 10;
        switchBoard();
    }
    
    @FXML
    private void switchToSmallBoard(ActionEvent event){
        numRows = 8;
        numCols = 8;
        switchBoard();
    }
    
    @FXML
    private void switchToTinyBoard(ActionEvent event){
        numRows = 3;
        numCols = 3;
        switchBoard();
    }
    
    @FXML
    private void switchToRed(ActionEvent event){
        lightColor = Color.RED;
        darkColor = Color.BLACK;
        switchBoard();
    }
    
    
    @FXML
    private void switchToBlue(ActionEvent event){
        lightColor = Color.SKYBLUE;
        darkColor = Color.DARKBLUE;
        switchBoard();
    }
    
     private void clear(){
        checkerBoard.clear();
    }
    
    private void refresh() {
        checkerBoard.build(stage.getWidth(), computeBoardHeight());
    }
    
    
}
