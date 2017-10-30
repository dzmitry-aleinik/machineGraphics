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



            if (model.isHandled()) {
                ArrayList <Point> newShape =model.getShape();
                for (int i = 0; i < newShape.size() - 1; i++) {
                    image.setRGB(newShape.get(i).x, newShape.get(i).y, 200);
                }
            }
            g.drawImage(image, 0, 0, null);



    }
}
