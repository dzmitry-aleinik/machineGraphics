import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.LinkedList;

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


            if (model.isFillingProcessed()){

                LinkedList<Point>  fillingPoints = model.getFillingComponent().BoundaryFill();
                while(!fillingPoints.isEmpty()){
                   Point point = fillingPoints.poll();
                    image.setRGB(point.x,point.y,200);

                }

                model.setFillingProcessed(false);
            }
            else if (model.isHandled()) {


                ArrayList <Point> newShape =model.getShape();

                model.setHandled(false);

                for (int i = 0; i < newShape.size() - 1; i++) {
                     model.setEdges(newShape.get(i).x,newShape.get(i).y);
                     image.setRGB(newShape.get(i).x, newShape.get(i).y, 200);
                }
                System.out.println(model.getDrawnShapes());

            }





            g.drawImage(image, 0, 0, null);



    }
}
