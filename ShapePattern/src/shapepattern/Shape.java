/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shapepattern;


import com.sun.prism.shape.ShapeRep;
import java.util.Random;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 *
 * @author Jacob, Bastian, Dusan & Kristofer
 */

/* Here we have the shapes (Triangle, Rectangle & Circle classes and the grid patterns as well   
   And we have a function that checks the list as well 
*/
public class Shape 
{   
    int counter=0;
    int size;
    GraphicsContext context;
    int height=20;
    int width=0;
    int widthDifferent=50;
    int heightDifferent=44;
    ObservableList<String> list;
   
    // Triangle class, draws the triangle
    public void triangle(int x, int y,GraphicsContext context) 
    {
       double[] xPoints = {width,width+x,width-x};
       double[] yPoints = {height,height+y,height+y};
       context.beginPath();
       context.strokePolygon(xPoints, yPoints, 3);
    }
    
    public void gridPaneRandom()
    {
       Random rand =new Random ();
       width = rand.nextInt(300); 
       height = rand.nextInt(300);
    }
    
    // Rectangle class, draws the rectangle
    public void rectangle (int x, int y,GraphicsContext context) 
    {
       double[] xPoints = {width,width+x,width+x,width};
       double[] yPoints = {height,height,height+y,height+y};
       context.beginPath();
       context.strokePolygon(xPoints, yPoints, 4);
    }
    
    // Circle class, draws the circle
    public void circle(int x, int y,GraphicsContext context) 
    {
       context.strokeOval(width, height, x, y);
    }
    
    // Shape list checks the the pattern, if it's cross, grid or random
    public void shapeList(ObservableList<String> list,GraphicsContext context, String pane)
    { 
       this.context=context;
       this.list=list;
       
       for (int i = 0; i < list.size(); i++) 
       {  
       
            if(pane.contains("Cross"))
            {
                crossPane();
                addObjects(list,i);
            }
            else if(pane.contains("Grid"))
            {
                grid();
                addObjects(list,i);
            }
            else if(pane.contains("Random"))
            {
                gridPaneRandom();
                addObjects(list,i);
                height=0;
                width=0;
            }
       }
    }
    
    // Checks the list 
    public void addObjects(ObservableList<String> list, int i)
    {
        context.setFill(Color.WHITE);
        context.setStroke(Color.BLACK);
        context.setLineWidth(1);
        list.get(i);
        String str = list.get(i);
        String[] part = str.split("(?<=\\D)(?=\\d)");
        System.out.println(part[0]);
        System.out.println(part[1]);
        Integer size= Integer.parseInt(part[1]);
        
        if (part[0].contains("Triangle")) 
        {
            triangle(size, size, context);
        }
        else if (part[0].contains("Rectangle")) 
        {
            rectangle(size, size*2, context);
        }
        else if (part[0].contains("Circle")) 
        {
            circle(size, size, context);
        }
    }
    
    // Function for the grid
    public void grid()
    { 
        double newline= context.getCanvas().getWidth() - size;
        width=width+widthDifferent;
        if (width>newline)
        {
            width=widthDifferent;
            height=height+heightDifferent;
        }
    }
    
    // Function for the cross pattern
    private void crossPane() 
    {
        width=(int) (context.getCanvas().getWidth()/2);
        height=(int) (context.getCanvas().getWidth()/2);
        
        if( counter!=0 && counter%4==0)
        {
            width=width-counter*widthDifferent/4;
            height=height-counter*heightDifferent/4;
        }
        
        else if(counter%4==1)
        {
            width=width-(3+counter)*widthDifferent/4;
            height=height+(3+counter)*heightDifferent/4;
        }
        
        else  if(counter%4==2)
        {
            width=width+(2+counter)*widthDifferent/4;
            height=height-(2+counter)*heightDifferent/4;
        }
        
        else  if(counter%4==3)
        {
            width=width+(1+counter)*widthDifferent/4;
            height=height+(1+counter)*heightDifferent/4;
        }
        counter++;
    }
}

