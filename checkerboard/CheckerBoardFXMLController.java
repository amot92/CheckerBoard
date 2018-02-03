/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkerboard;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.StringTokenizer;
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
        createBoard();
        
        ChangeListener<Number> lambdaChangeListener = (ObservableValue<? extends Number> observable, Number oldValue, final Number newValue) -> {
            refreshBoard();
        };
        
        this.stage.widthProperty().addListener(lambdaChangeListener);
        this.stage.heightProperty().addListener(lambdaChangeListener);
        
    }
    
    private void createBoard(){
        if(checkerBoard != null){
            checkerBoard.clear();
        }
        checkerBoard = new grid.CheckerBoard(numRows, numCols, stage.getWidth(), computeBoardHeight(), lightColor, darkColor);
        vBox.getChildren().add(checkerBoard.getBoard());
    }
    
    private void refreshBoard() {
        checkerBoard.build(stage.getWidth(), computeBoardHeight());
    }
    
    private double computeBoardHeight(){
        return stage.getHeight() - menuBar.getHeight();
    }
    
    @FXML
    private void handleSizeChange(ActionEvent event){
        MenuItem menuItem = (MenuItem) event.getSource();
         
        StringTokenizer st = new StringTokenizer(menuItem.getText().toString());
        int result = Integer.parseInt(st.nextToken());
         
        numRows = result;
        numCols = result;
        createBoard();
    }
            
    @FXML
    private void handleColorChange(ActionEvent event){
        MenuItem menuItem = (MenuItem) event.getSource();
        if(menuItem.getText().toString().equals("Default")){
           lightColor = Color.RED;
           darkColor = Color.BLACK;
        }else{
            lightColor = Color.SKYBLUE;
            darkColor = Color.DARKBLUE;
        }
        createBoard();

    }
    
    
    
    
}
