import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by HP on 11.10.2017.
 */
public class MainFrame extends JFrame {
    public MainFrame(){
        this.setVisible(true);
        this.setSize(new Dimension(2000,2000));
        this.setLocationRelativeTo(null);
        Model model =new Model();
        Painting panel =new Painting(model);
        this.add(panel);


        addMouseListener(new MouseAdapter() {

            @Override
            public void mouseReleased(MouseEvent e) {
                model.setShapeEnd(e.getX(),e.getY()-30);
                repaint();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                model.setShapeBegin(e.getX(),e.getY()-30);

            }
        });

    }

    public static void main(String[] args) {
        new MainFrame();
    }

}
