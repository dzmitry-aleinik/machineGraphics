import java.awt.*;
import java.util.ArrayList;

/**
 * Created by HP on 07.11.2017.
 */
public class BezierCurve {
    private ArrayList<Point> points ;
    private int size ;
    public void setSize (int n){
        size = n;
    }
    public int getSize()
    {
        return size;
    }    public BezierCurve(){
        points = new ArrayList<>();
    }
    private long factorial (long n){
        if (n<=1){
            return 1;
        }
        else {
            return n* factorial(n-1);
        }
    }

    public void addPoint(Point point){
        points.add(point);
    }
    public int numberPoint(){
        return  points.size();
    }

    private double bernsteinBasis(int n, int i ,double t ){
        return factorial(n)/(factorial(i)*factorial(n-i))*Math.pow(1-t,n-i)*Math.pow(t,i);
    }
    public ArrayList<Point>  getBezierCurve( Double step){
        ArrayList<Point> result = new ArrayList<>();
        int n = points.size();
        int j =0;
        for (double t =0; t<1; t+=step,j++){

            result.add(new Point());

            for (int i =0; i < n;i++){
                 double coefficient =  bernsteinBasis(n-1,i,t);
                result.get(j).x += (int)(points.get(i).x * coefficient);
                  result.get(j).y +=(int)(points.get(i).y * coefficient);
            }
        }

        return result;
    }



}
