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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author danielking
 */
public class CheckerFXMLController implements Initializable, Startable {
    private Stage stage;
    private int numRows;
    private int numCols;
    private double boardWidth;
    private double boardHeight;
    private Color lightColor;
    private Color darkColor;
    
    @FXML 
    private AnchorPane anchor;
    
    @FXML
    private VBox vb; 
    
    @FXML
    private void handleGrid16(ActionEvent event) {
        numRows = 16;
        numCols = 16;
        
        CheckerBoard cb = new CheckerBoard(numRows, numCols, boardWidth, boardHeight, lightColor, darkColor);
        AnchorPane check = cb.getBoard();
        anchor.getChildren().addAll(check);
        
    }
    
    @FXML
    private void handleGridDefault(ActionEvent event) {
        numRows = 8;
        numCols = 8;
        
        CheckerBoard cb = new CheckerBoard(numRows, numCols, boardWidth, boardHeight, lightColor, darkColor);
        AnchorPane check = cb.getBoard();
        anchor.getChildren().addAll(check);
    }
    
    @FXML
    private void handleGrid10(ActionEvent event) {
        numRows = 10;
        numCols = 10;
        
        CheckerBoard cb = new CheckerBoard(numRows, numCols, boardWidth, boardHeight, lightColor, darkColor);
        AnchorPane check = cb.getBoard();
        anchor.getChildren().addAll(check);
    }
    @FXML
    private void handleGrid3(ActionEvent event) {
        numRows = 3;
        numCols = 3;
        
        CheckerBoard cb = new CheckerBoard(numRows, numCols, boardWidth, boardHeight, lightColor, darkColor);
        AnchorPane check = cb.getBoard();
        anchor.getChildren().addAll(check);
    }
    
    @FXML
    private void handleColorDefault(ActionEvent event) {
        lightColor = Color.RED;
        darkColor = Color.BLACK;
        
        CheckerBoard cb = new CheckerBoard(numRows, numCols, boardWidth, boardHeight, lightColor, darkColor);
        AnchorPane check = cb.getBoard();
        anchor.getChildren().addAll(check);
    }
    
    @FXML
    private void handleColorBlue(ActionEvent event) {
        lightColor = Color.SKYBLUE;
        darkColor = Color.DARKBLUE;
        
        CheckerBoard cb = new CheckerBoard(numRows, numCols, boardWidth, boardHeight, lightColor, darkColor);
        AnchorPane check = cb.getBoard();
        anchor.getChildren().addAll(check);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void start(Stage stage) {
        this.stage = stage;
        numRows = 8;
        numCols = 8;
        lightColor = Color.RED;
        darkColor = Color.BLACK;
        
        ChangeListener<Number> lambdaChangeListener = (ObservableValue<? extends Number> observable, Number oldValue, final Number newValue) -> {
            adaptSize();
//            System.out.println(anchor.getWidth());
        };
        this.stage.widthProperty().addListener(lambdaChangeListener);
        this.stage.heightProperty().addListener(lambdaChangeListener);
        
        adaptSize();
    }
    
    private void adaptSize() {
        anchor.getChildren().clear();
        double offSet = 50; //accounts for problems with rectangles getting cut off
        boardWidth = stage.getWidth();
        boardHeight = stage.getHeight() - offSet;
        CheckerBoard check = new CheckerBoard(numRows, numCols, boardWidth, boardHeight, lightColor, darkColor);
        AnchorPane board = check.getBoard();
        anchor.getChildren().add(board);
    }
}
