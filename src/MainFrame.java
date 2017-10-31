import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by HP on 11.10.2017.
 */
public class MainFrame extends JFrame {
    public MainFrame(){
        this.setVisible(true);
        this.setSize(new Dimension(1900,1900));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Model model =new Model();
        Painting panel =new Painting(model);
        this.add(panel);
        JMenuBar menuBar = new JMenuBar();

        setJMenuBar(menuBar);
        JMenu jMenu =new JMenu("Shapes");
        JMenu jMenuTools = new JMenu("Tools");
        menuBar.add(jMenu);
        menuBar.add(jMenuTools);

        JMenuItem menuLine = new JMenuItem("Line");
        JMenuItem menuCircle = new JMenuItem("Circle");
        JMenuItem menuEllipse = new JMenuItem("Ellipse");
        JMenuItem menuFilling = new JMenuItem("Filling");



        jMenu.add(menuLine);
        jMenu.add(menuCircle);
        jMenu.add(menuEllipse);
        jMenuTools.add(menuFilling);
        menuLine.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setLine();
            }
        });
        menuCircle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setCircle();
            }
        });
        menuEllipse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setEllipse();
            }
        });
        menuFilling.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setFilling();

            }
        });




        addMouseListener(new MouseAdapter() {

            @Override
            public void mouseReleased(MouseEvent e) {

                if(!model.isFilling()) {
                    if (model.isEllipse() || model.isCircle() || model.isLine()) {
                        model.setShapeEnd(e.getX(), e.getY() - 30);
                        repaint();
                    }
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {



                if(!model.isFilling()) {
                    if (model.isLine() || model.isCircle() || model.isEllipse()) {
                        model.setShapeBegin(e.getX(), e.getY() - 30);
                    }
                }

            }


            @Override
            public void mouseClicked(MouseEvent e) {
                if (model.isFilling()){
                    model.setFillingComponent(new Filling(model,e.getX(),e.getY()-30));
                    model.setFillingProcessed(true);
                    model.resetFilling();
                    repaint();
                }

            }
        });

    }

    public static void main(String[] args) {
        new MainFrame();
    }

}
