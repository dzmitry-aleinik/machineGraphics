import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Created by HP on 01.11.2017.
 */
public class ClippingPanel  extends JPanel{
    private  BufferedImage image=new BufferedImage(2000,2000,BufferedImage.TYPE_INT_BGR);
    private Model model;
    public ClippingPanel(Model model){
        this.model = model;
    }

    protected void paintComponent(Graphics g){
        super.paintComponent(g);


        if(model.isClippingProcessed()){

            ArrayList<Shape> result  = model.formClipping();


           for (Shape shape :result){
               Line line = (Line) shape;
               ArrayList<Point> linePoints = line.formShape();
               for(Point point : linePoints){
                   image.setRGB(point.x,point.y,200);
               }
           }
            model.setClippingProcessed(false);

        }


        g.drawImage(image, 0, 0, null);

    }


}
