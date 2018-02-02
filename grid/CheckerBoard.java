/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grid;

import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

/**
 *
 * @author adammoakes
 */
public class CheckerBoard {
    private int numRows;
    private int numCols;
    private double boardWidth;
    private double boardHeight;
    private Color lightColor;
    private Color darkColor;
    private double rectangleWidth;
    private double rectangleHeight;
    
    private AnchorPane anchorPane;
    
    private Color[] colors = {Color.BLACK, Color.RED, Color.DARKBLUE, Color.SKYBLUE};
    
    public CheckerBoard(int numRows, int numCols, double boardWidth, double boardHeight){
        this(numRows, numCols, boardWidth, boardHeight, Color.RED, Color.BLACK);
    }
    
    public CheckerBoard(int numRows, int numCols, double boardWidth, double boardHeight, Color lightColor, Color darkColor){
        this.numRows = numRows;
        this.numCols = numCols;
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        this.lightColor = lightColor;
        this.darkColor = darkColor;
    }
    
    public AnchorPane build(double width, double height){
        
        return anchorPane;
    }
    
      public void clear() {
        anchorPane.getChildren().clear();
    }
    
    public AnchorPane getBoard() {
        return anchorPane;
    }
    
    public int getNumRows() {
        return numRows;
    }
    
    public int getNumCols() {
        return numCols;
    }
    
    public double getWidth() {
        return boardWidth;
    }
    
    public double getHeight() {
        return boardHeight;
    }
    
    public double getRectangleWidth() {
        return rectangleWidth;
    }
    
    public double getRectangleHeight() {
        return rectangleHeight;
    }
    
    public Color getDarkColor() {
        return darkColor;
    }
    
    public Color getLightColor() {
        return lightColor;
    }

    private CheckerBoard(int numRows, int numCols, double boardWidth, double boardHeight, Color RED, Color BLACK) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private CheckerBoard(int numRows, int numCols, double boardWidth, double boardHeight, Color RED, Color BLACK) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
