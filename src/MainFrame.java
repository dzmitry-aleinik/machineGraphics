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
        JMenuItem menuClipping = new JMenuItem("Clipping");
        JMenuItem menuBezier = new JMenuItem("BezierCurve");






        jMenu.add(menuLine);
        jMenu.add(menuCircle);
        jMenu.add(menuEllipse);
        jMenuTools.add(menuFilling);

        jMenuTools.add(menuClipping);
        jMenuTools.add(menuBezier);




        JDialog dialog = new JDialog();

        dialog.setSize(new Dimension(1900,1900));
        ClippingPanel clippingPanel =new ClippingPanel(model);

        dialog.add(clippingPanel);
        dialog.repaint();
        dialog.setModal(true);
       // dialog.setVisible(true);


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
                model.setFilling(true);

            }
        });

        menuClipping.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setClipping(true);


            }
        });
        menuBezier.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                 int number=  Integer.parseInt(JOptionPane.showInputDialog("Input the number of the point",3));
                model.getBezierComponent().setSize(number);
                 model.setBezier(true);
            }
        });




        addMouseListener(new MouseAdapter() {

            @Override
            public void mouseReleased(MouseEvent e) {

                if((!model.isClipping()) &&  !model.isFilling() && (model.isEllipse() || model.isCircle() || model.isLine())) {


                        model.setShapeEnd(e.getX(), e.getY() - 30);
                        repaint();

                } else if (model.isClipping()){



                    model.setClippingEnd(e.getX(),e.getY() - 30);

                    model.setClipping(false);
                    model.setClippingProcessed(true);
                    dialog.repaint();
                    dialog.setVisible(true);
                    model.setClipping(false);

                }
            }

            @Override
            public void mousePressed(MouseEvent e) {



                if( !model.isClipping() && !model.isFilling() && (model.isLine() || model.isCircle() || model.isEllipse())) {

                        model.setShapeBegin(e.getX(), e.getY() - 30);

                }  else if (model.isClipping()){
                    model.setClippingComponent(new Clipping(model));
                    model.setClippingBegin(e.getX(),e.getY() - 30);
                }

            }


            @Override
            public void mouseClicked(MouseEvent e) {
                if (model.isFilling()) {
                    model.setFillingComponent(new Filling(model, e.getX(), e.getY() - 30));
                    model.setFillingProcessed(true);
                    model.setFilling(false);
                    repaint();
                } else if (model.isBezier()) {
                    if (model.getBezierComponent().getSize() > model.getBezierComponent().numberPoint()) {
                        model.getBezierComponent().addPoint(new Point(e.getX(), e.getY() - 30));
                        if (model.getBezierComponent().getSize() == model.getBezierComponent().numberPoint()){
                            model.setBezierProcessed(true);
                            repaint();
                        }
                    }

                }
            }
        });

        }

    public static void main(String[] args) {
        new MainFrame();
    }

}
