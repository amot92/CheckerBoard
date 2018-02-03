/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grid;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

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
    private GridPane gridPane;
    
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
        
        anchorPane = new AnchorPane();
        gridPane = new GridPane();
        
        build(boardWidth, boardHeight);
        
    }
    
    public AnchorPane build(double boardWidth, double boardHeight){
        clear();
        this.boardHeight = boardHeight;
        this.boardWidth = boardWidth;
        rectangleWidth = Math.ceil(boardWidth / (double)numCols);
        rectangleHeight = Math.ceil(boardHeight / (double)numRows);
        anchorPane.setPrefWidth(boardWidth);
        anchorPane.setPrefHeight(boardHeight);
        
        Color color;
        for (int row = 0; row < numRows; row++){
            for (int col = 0; col < numCols; col++){
                if(row%2 == col%2){
                    color = lightColor;
                }else{
                    color = darkColor;
                }
                
                Rectangle rect = new Rectangle(rectangleWidth, rectangleHeight, color);
                gridPane.add(rect, row, col);
                
            }
        }
        anchorPane.getChildren().add(gridPane);
        System.out.println(rectangleWidth);
        return anchorPane;
    }
    
     public void clear() {
        anchorPane.getChildren().clear();
        gridPane.getChildren().clear();
    }
    
    public AnchorPane getBoard() {
        if(anchorPane != null){
            return anchorPane;
        }else{
            return null;
        }
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

}