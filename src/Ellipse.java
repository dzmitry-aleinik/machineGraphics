import java.awt.*;
import java.util.ArrayList;

/**
 * Created by HP on 19.10.2017.
 */
public class Ellipse implements  Shape {
    private int xC;
    private int yC;
    private double R;

    private int xB;   // coordinates of the left and right corner of the rectangle
    private int yB;
    private int xE;
    private int yE;



    public void setBegin(int x, int y){
        this.xB = x;
        this.yB = y;

    }
    public void setEnd(int x, int y){

        this.xE = x;
        this.yE = y;
        this.xC = (xE + xB)/2;
        this.yC  = (yE +  yB)/2;

    }




     public void  setCenter( int x, int y){
        this.xC = x;
        this.yC = y;

    }

    public void setRadius(int x, int y){
       this.R = (int)Math.sqrt( (xC - x)*(xC - x) + (yC - y)*(yC - y) );

    }
    public void draw(){}
    public ArrayList<Point> getCircle(){
        ArrayList<Point> result = new ArrayList<>();
        double xCur =  0 ;
        double yCur = R;
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
             int x = (int)xCur;
             int y = (int)yCur;

             result.add( new Point (x + xC,y + yC));
             result.add( new Point (y + xC,  x + yC ));
             result.add( new Point (y + xC, -x + yC));
             result.add( new Point(x + xC, -y + yC));
             result.add( new Point(-x +xC,-y + yC));
             result.add( new Point(-y + xC, -x + yC));
             result.add( new Point(-y + xC, x + yC));
             result.add( new Point (-x + xC, y + yC));
         }
        return result;
    }
    public ArrayList<Point> getEllipse(){
        ArrayList<Point> result = new ArrayList<>();

         int a = Math.abs(xE - xB)/2;
         int b = Math.abs(yE - yB)/2;
         int x = 0;
          int y = b;

        int delta = 2*b*b + a*a*(1-2*b);

        do{
            x += 1;
            if (delta >= 0){
                delta += 4*a*a*8*(1-y);
                y--;

            }else{

                delta +=  b*b*((4*x) + 6);





            }
            result.add( new Point (x + xC,y + yC));
            result.add(new Point (x + xC, -y + yC));
            result.add(new Point (-x + xC, -y + yC));
            result.add(new Point (-x + xC, y + yC));


        }while (y!=0);

        return result;
    }

}
