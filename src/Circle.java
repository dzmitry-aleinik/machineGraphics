import java.awt.*;
import java.util.ArrayList;

/**
 * Created by HP on 30.10.2017.
 */
public class Circle implements Shape {

    private int xCenter;
    private int yCenter;
    private double R;

    public void setBegin(int x, int y){
        this.xCenter = x;
        this.yCenter = y;
    }
    public void setEnd(int x, int y){
        this.R = Math.sqrt( (xCenter - x)*(xCenter - x) + (yCenter - y)*(yCenter - y) );
    }


    public void setRadius(int x, int y){


    }
    public ArrayList<Point> formShape(){
        ArrayList<Point> result = new ArrayList<>();
        double xCur =  0 ;
        double yCur = R;
        int x = (int)xCur;
        int y = (int)yCur;
        result.add( new Point (x + xCenter,y + yCenter));
        result.add( new Point (y + xCenter,  x + yCenter ));
        result.add( new Point (y + xCenter, -x + yCenter));
        result.add( new Point(x + xCenter, -y + yCenter));
        result.add( new Point(-x +xCenter,-y + yCenter));
        result.add( new Point(-y + xCenter, -x + yCenter));
        result.add( new Point(-y + xCenter, x + yCenter));
        result.add( new Point (-x + xCenter, y + yCenter));
        double delta =  3 - 2*yCur;
        while(xCur < yCur ){
            xCur += 1;
            if (delta <0){

                delta += 4*xCur+6;
            }
            else{

                yCur -= 1;
                delta += 4*(xCur - yCur) + 10;
            }
             x = (int)xCur;
             y = (int)yCur;

            result.add( new Point (x + xCenter,y + yCenter));
            result.add( new Point (y + xCenter,  x + yCenter ));
            result.add( new Point (y + xCenter, -x + yCenter));
            result.add( new Point(x + xCenter, -y + yCenter));
            result.add( new Point(-x +xCenter,-y + yCenter));
            result.add( new Point(-y + xCenter, -x + yCenter));
            result.add( new Point(-y + xCenter, x + yCenter));
            result.add( new Point (-x + xCenter, y + yCenter));
        }
        return result;
    }

}
