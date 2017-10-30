import java.awt.*;
import java.util.ArrayList;

/**
 * Created by HP on 11.10.2017.
 */
public class Model {
    private Shape shape;
    private  boolean isLine = false;
     private boolean isCircle=  false;
     private boolean isEllipse= false;
    private boolean handled = false;

    public boolean isHandled(){
        return handled;
    }
    public void setShapeBegin(int x ,int y){
        shape.setBegin(x,y);
        handled = true;
    }
    public void setShapeEnd(int x ,int y){

       shape.setEnd(x,y);
        handled = true;
    }
    public ArrayList<Point> getShape(){
        handled = false;
        return shape.formShape();

    }

    public boolean isLine(){
        return isLine;
    }
    public boolean isCircle(){
        return isCircle;
    }
    public boolean isEllipse(){
        return isEllipse;
    }
    public void setLine(){
        shape = new Line();
        isLine = true;
        isCircle = false;
        isEllipse = false;
    }
    public void setCircle(){
        shape = new Circle();
        isLine = false;
        isCircle =true;
        isEllipse = false;
    }
    public void setEllipse(){
        shape = new Ellipse();
        isLine = false ;
        isCircle = false;
        isEllipse = true;
    }




}
