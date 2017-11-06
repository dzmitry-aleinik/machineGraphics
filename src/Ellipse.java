import java.awt.*;
import java.util.ArrayList;

/**
 * Created by HP on 19.10.2017.
 */
// https://books.google.by/books?id=09wawLhff4QC&pg=PA56&lpg=PA56&dq=ellipse+computer+graphics&source=bl&ots=JgpO8_cWeL&sig=pEnGTIPhfrngQt8DOE4oEQaR1Wo&hl=ru&sa=X&ved=0ahUKEwjVn9rQl5jXAhURY1AKHQ5lB3A4ChDoAQglMAA#v=onepage&q=ellipse%20computer%20graphics&f=false
public class Ellipse implements  Shape {
    private int xC;
    private int yC;


    private int xB;   // coordinates of the left and right corner of the rectangle
    private int yB;
    private int xE;
    private int yE;
    private int a;
    private int b;


    public Ellipse(int xC, int yC, int xB, int yB, int yE, int xE, int a, int b) {
        this.xC = xC;
        this.yC = yC;
        this.xB = xB;
        this.yB = yB;
        this.yE = yE;
        this.xE = xE;
        this.a = a;
        this.b = b;
    }

    public Ellipse clone(){
        return  new Ellipse(xC,yC,xB,yB,yE,xE,a,b);
    }


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
        double x =0;
        double y =b;
        double d = b*b - a*a*b + a*a/4;
        int xRes = (int)x;
        int yRes = (int)y;
        result.add(new Point (xRes + xC, yRes + yC));
        result.add(new Point(xRes + xC,yRes + yC));
        result.add(new Point (xRes + xC ,-yRes + yC));
        result.add(new Point (-xRes + xC,-yRes + yC));
        result.add(new Point (-xRes + xC,yRes + yC));
        while ( a*a*(y-1/2) >b*b*(x+1)){
            if(d<0){
                d = d + b*b*(2*x+3);
                x++;
            }
            else{
                d = d+ b*b*(2*x+3) + a*a*(-2*y + 2);
                x++;
                y--;
            }
             xRes = (int)x;
             yRes = (int)y;
            result.add(new Point(xRes + xC,yRes + yC));
            result.add(new Point (xRes + xC ,-yRes + yC));
            result.add(new Point (-xRes + xC,-yRes + yC));
            result.add(new Point (-xRes + xC,yRes + yC));
        }


        d = b*b*(x+1/2)*(x+1/2) + a*a*(y-1)*(y-1) -a*a*b*b;
        while (y>0){


            if(d<0){
                d += b*b*(2*x +2) + a*a*(-2*y+3);
                x++;
                y--;

            }else {
                d = d +a*a*(-2*y + 3);
                y--;

            }
            xRes = (int)x;
             yRes = (int)y;
            result.add(new Point(xRes + xC,yRes + yC));
            result.add(new Point (xRes + xC ,-yRes + yC));
            result.add(new Point (-xRes + xC,-yRes + yC));
            result.add(new Point (-xRes + xC,yRes + yC));
        }

        return result;
    }



}
