/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkerboard;

import java.net.URL;
import java.util.ResourceBundle;
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

    private Scene scene;
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
        // TODO
    }

    public void start(Scene scene){
        this.scene = scene;
        checkerBoard = new grid.CheckerBoard(8, 8, scene.getWidth(), scene.getHeight() - menuBar.getHeight());
        vBox.getChildren().add(checkerBoard.getBoard());
        
    }
    
    @FXML
    private void handleSizeChange(ActionEvent event){
        MenuItem menuItem = (MenuItem) event.getSource();
        System.out.println(menuItem.getText());
        
    }
    
    @FXML
    private void handleColorChange(ActionEvent event){
        MenuItem menuItem = (MenuItem) event.getSource();
    }
    
    private void refresh() {
        checkerBoard.build(scene.getWidth(), scene.getHeight() - menuBar.getHeight());
    }
    
    
}
