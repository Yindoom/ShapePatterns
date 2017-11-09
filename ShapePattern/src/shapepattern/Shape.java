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
 * @author jacob
 */
public class Shape {
int size;
GraphicsContext context;
int hight=20;
int width=0;
int widthDifferent=50;
int hightDifferent=44;
ObservableList<String> list;
        
   
//GraphicsContext context
   
    public void triangle(int x, int y,GraphicsContext context) {
     
      double[] xPoints = {width,width+x,width-x};
      double[] yPoints = {hight,hight+y,hight+y};
      context.beginPath();
      context.strokePolygon(xPoints, yPoints, 3);
  
 }
    
    public void gridpaneRandom()
    {
       Random rand =new Random ();
        width = rand.nextInt(300); 
        hight = rand.nextInt(300);
    }
        public void reangle (int x, int y,GraphicsContext context) {
       
      double[] xPoints = {width,width+x,width+x,width};
      double[] yPoints = {hight,hight,hight+y,hight+y};
      context.beginPath();
      context.strokePolygon(xPoints, yPoints, 4);
      }
         public void circle(int x, int y,GraphicsContext context) {
        context.strokeOval(width, hight, x, y);
 }
    public void shapeList(ObservableList<String> list,GraphicsContext context, String pane)
    { 
      this.context=context;
      this.list=list;
      for (int i = 0; i < list.size(); i++) {  
    if(pane.contains("Cross")){
     crossPane();
     addObjects(list,i);
    }
    else if(pane.contains("Grid")){
        grid();
        addObjects(list,i);
        
    }
    else if(pane.contains("Random")){
        gridpaneRandom();
        addObjects(list,i);
        hight=0;
        width=0;
    }}}
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
            if (part[0].contains("Triangle")) {
            triangle(size, size, context);
        }
            else if (part[0].contains("Rectangle")) {
               reangle(size, size*2, context);
            }
            else if (part[0].contains("Circle")) {
                circle(size, size, context);
            }
}

public void grid()
{ 
    int newline=250;
    width=width+widthDifferent;
    if (width>newline)
    {
    width=widthDifferent;
    hight=hight+hightDifferent;
    }
}
int counter=0;
    private void crossPane() {
          width=(int) (context.getCanvas().getWidth()/2);
     hight=(int) (context.getCanvas().getWidth()/2);
     if( counter!=0 && counter%4==0)
             {
             width=width-counter*widthDifferent/4;
             hight=hight-counter*hightDifferent/4;
             }
     else if(counter%4==1)
     {
       width=width-(3+counter)*widthDifferent/4;
       hight=hight+(3+counter)*hightDifferent/4;
     }
     else  if(counter%4==2)
     {
       width=width+(2+counter)*widthDifferent/4;
       hight=hight-(2+counter)*hightDifferent/4;
     }
     else  if(counter%4==3)
     {
       width=width+(1+counter)*widthDifferent/4;
       hight=hight+(1+counter)*hightDifferent/4;
     }
     counter++;
     
    }

}

