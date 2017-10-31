import java.awt.*;
import java.util.ArrayList;

/**
 * Created by HP on 11.10.2017.
 */
public class Model {

     private boolean edges [][] = new boolean[2000][2000];
    private Shape shape;
    private  boolean isLine = false;
     private boolean isCircle=  false;
     private boolean isEllipse= false;
    private boolean handled = false;
    private boolean  filling = false;
    private boolean fillingProcessed=false;
    private Filling fillingComponent;


    public void setHandled(boolean h){
        this.handled = h;
    }
    public boolean isFillingProcessed() {
        return fillingProcessed;
    }

    public void setFillingProcessed(boolean fillingProcessed) {
        this.fillingProcessed = fillingProcessed;
    }

    public void setFillingComponent(Filling fillingComponent) {
        this.fillingComponent = fillingComponent;

    }

    public  Filling getFillingComponent(){
        return  fillingComponent;
    }
    public boolean isHandled(){
        return handled;
    }
    public void setShapeBegin(int x ,int y){
        shape.setBegin(x,y);

    }
    public void setShapeEnd(int x ,int y){

       shape.setEnd(x,y);
        handled = true;
    }
    public ArrayList<Point> getShape(){

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

    public void setEdges(int x, int y){
        edges[x][y]=true;
    }

    public  boolean [][] getEdges(){
        return  edges;
    }

    public void setFilling (){
        filling = true;
    }
    public void resetFilling(){
        filling = false;
    }

    public boolean isFilling (){
        return filling;
    }





}
