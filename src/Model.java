/**
 * Created by HP on 11.10.2017.
 */
public class Model {
    private Shape shape;
    boolean isLine = false;
    boolean isCircle=  true;
    Model (){
        shape = new Ellipse();
    }

    public void setShapeBegin(int x ,int y){
        if(isLine) {
            ((Line) shape).setBegin(x, y);
        }
        else if ( isCircle){
            ((Ellipse)shape).setBegin(x,y);
        }
    }
    public void setShapeEnd(int x ,int y){

        if (isLine){
        ((Line)shape).setEnd(x,y);
        }
        else if (isCircle){
            ((Ellipse)shape).setEnd(x,y);
        }
    }
    public Shape getShape(){
        return shape;
    }


}
