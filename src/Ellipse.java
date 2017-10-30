import java.awt.*;
import java.util.ArrayList;

/**
 * Created by HP on 19.10.2017.
 */
public class Ellipse implements  Shape {
    private int xC;
    private int yC;


    private int xB;   // coordinates of the left and right corner of the rectangle
    private int yB;
    private int xE;
    private int yE;
    private int a;
    private int b;


    public Ellipse (){}

    public void setBegin(int x, int y){
        this.xB = x;
        this.yB = y;

    }
    public void setEnd(int x, int y){

        this.xE = x;
        this.yE = y;
        this.xC = (xE + xB)/2;
        this.yC  = (yE +  yB)/2;
        this.a =  Math.abs(xE-xB)/2;
        this.b = Math.abs(yE - yB)/2;

    }


    public ArrayList<Point> formShape (){
        ArrayList<Point> result = new ArrayList<>();
        int x,y,xChange,yChange, EllipseError,StoppingX,StoppingY;
        x = a;
        y=0;
        EllipseError = 0;
        xChange = a*a*(1-2*b);
        yChange = b*b;

        while (-2*x*b*b >= 2*y*a*a){
            y++;
            EllipseError+= yChange;
            yChange += 2*a*a;
            if( (2*EllipseError +xChange) >0 ){
                x--;
                EllipseError += xChange;
                xChange += 2*b*b;
            }

            result.add(new Point(x,y));
        }

        x =0 ;
        y= a;
        xChange = a*a;
        yChange =  b*b*(1-2*a);
        EllipseError = 0 ;
        while(-2*x*b*b <= 2*y*a*a ){


            x++;
            EllipseError+=xChange;
            xChange+=2*b*b;
            if( (2*EllipseError + yChange)>0){
                y--;
                EllipseError+=yChange;
                yChange += 2*a*a;
            }
            result.add(new Point (x,y));
        }


        return result;
    }



}
