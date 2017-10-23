import java.awt.*;
import java.util.ArrayList;

/**
 * Created by HP on 11.10.2017.
 */
public class Line implements Shape {

    private int xBegin;
    private int xEnd;
    private int yBegin;
    private int yEnd;

    public void setBegin(int x, int y) {
        this.xBegin = x;
        this.yBegin = y;


    }

    public ArrayList<Point> getLineDDA() {

        ArrayList<Point> result = new ArrayList<>();
        double L = Math.max(Math.abs(xBegin - xEnd), Math.abs(yBegin - yEnd));

        double deltaX = (xEnd - xBegin) / L;

        double deltaY = (yEnd - yBegin) / L;
        double x = xBegin;
        double y = yBegin;
        for (int i = 0; i < L; i++) {
            x += deltaX;
            y += deltaY;
            result.add(new Point((int) Math.round(x), (int) Math.round(y)));

        }
        result.add(new Point(xEnd, yEnd));
        return result;
    }

    public ArrayList<Point> getLineBrezenhem() {
        ArrayList<Point> result = new ArrayList<>();


        int deltaX = 1;
        int deltaY = 1;
        if (xEnd < xBegin) {
            deltaX = -1;

        }
        if (yEnd < yBegin) {
            deltaY = -1;
        }
        double mistake = -0.5;
        int y = yBegin;
        int x =xBegin;
        if (Math.abs(xBegin - xEnd) > Math.abs(yBegin -  yEnd)) {
            double delta = (double) Math.abs(yEnd - yBegin) / (double) Math.abs(xEnd - xBegin);

            for (x = xBegin; x != xEnd; x += deltaX) {

                mistake += delta;
                if (mistake > 0) {
                    y += deltaY;
                    mistake -= 1;
                }
                result.add(new Point(x, y));
            }
        }
        else{
            double delta = (double) Math.abs(xEnd - xBegin) / (double) Math.abs(yEnd - yBegin);
            for(y=yBegin;y != yEnd; y += deltaY ){

                mistake += delta;
                if (mistake > 0) {
                    x += deltaX;
                    mistake -= 1;
                }
                result.add(new Point(x, y));


            }

        }
        return result;
    }


    public int getxBegin() {
        return xBegin;
    }

    public int getxEnd() {
        return xEnd;
    }

    public int getyBegin() {
        return yBegin;
    }

    public int getyEnd() {
        return yEnd;
    }

    public void setEnd(int x, int y) {
        this.xEnd = x;
        this.yEnd = y;

    }


    public void draw() {
    }

}
