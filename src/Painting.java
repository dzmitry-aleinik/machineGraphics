import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Created by HP on 11.10.2017.
 */
public class Painting extends JPanel  {
    boolean start = true;
    private  Model model;
    BufferedImage image=new BufferedImage(2000,2000,BufferedImage.TYPE_INT_BGR);

    public Painting(Model model) {
        this.model = model;



    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(!start) {
            Ellipse ellipse = (Ellipse)model.getShape();
            //g.drawLine(line.getxBegin(), line.getyBegin(), line.getxEnd(), line.getyEnd());
             ArrayList<Point> lineDDA= ellipse.getEllipse();
            for (int i=0; i<lineDDA.size()-1;i++){
                image.setRGB(lineDDA.get(i).x,lineDDA.get(i).y,200);
            }
            g.drawImage(image, 0, 0, null);

        }
        start=false;
    }
}
