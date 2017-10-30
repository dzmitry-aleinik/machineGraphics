import java.awt.*;
import java.util.ArrayList;

/**
 * Created by HP on 11.10.2017.
 */
public interface Shape {
    public void  setBegin(int x , int y);
    public void setEnd(int x, int y);
    public ArrayList<Point> formShape();

}
