/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shapepattern;

import java.awt.Color;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 *
 * @author mr.Andersen
 */
public class ShapePatternController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private ComboBox<String> selectShape;
    @FXML
    private TextField sizeInput;
    @FXML
    private Button addToListbox;
    @FXML
    private ListView<String> listBox;
    private ObservableList<String> allListBox;
     
    @FXML
    private Canvas canvas = new Canvas();
    @FXML
    private Button drawShapes;
    private String rectangle;
    GraphicsContext gc = canvas.getGraphicsContext2D();
    int i=0;
    @FXML
    private ComboBox<String> gridPane;
    int counter=0;
  
    @FXML
    private void handleButtonAction(ActionEvent event) 
    {
        
        
        Integer listBox= Integer.parseInt(sizeInput.getText());
        rectangle = selectShape.getValue();
        selectShape.getValue();
        Shape shape= new Shape();
        allListBox.add(rectangle + " " + listBox); 
        counter=0;
       
     }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        allListBox = FXCollections.observableArrayList();
        listBox.setItems(allListBox);
        selectShape.getItems().removeAll(selectShape.getItems());
        selectShape.getItems().addAll("Triangle", "Circle","Rectangle");
        selectShape.getSelectionModel().select("Triangle");
         gridPane.getItems().removeAll(gridPane.getItems());
        gridPane.getItems().addAll("Cross", "Grid","Random");
        gridPane.getSelectionModel().select("Grid");
     }    
    @FXML
    private void DrawShapes(ActionEvent event) {
     
        Shape draw=new Shape();
        draw.shapeList(allListBox,canvas.getGraphicsContext2D(),gridPane.getValue());
        counter=0;
    }


    @FXML
    private void clearing(ActionEvent event) {
       
     canvas.getGraphicsContext2D().clearRect(0, 0, canvas.getWidth(),canvas.getHeight());
     allListBox.clear();
     
    }
}
