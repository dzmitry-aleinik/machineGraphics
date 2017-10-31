import java.awt.*;
import java.util.LinkedList;

/**
 * Created by HP on 31.10.2017.
 */
public class Filling {
    private Model model;

    private int x;
    private  int y ;
    private int xSize;
    private int ySize;
    public Filling (Model model, int x ,int y){
        this.model=model;
        xSize = model.getEdges()[0].length;
        ySize = model. getEdges().length;
        this.x = x;
        this.y = y;
    }


    public LinkedList<Point>  BoundaryFill(){


        boolean [][] edges = model.getEdges();

        LinkedList<Point> process = new LinkedList<>();
        LinkedList<Point> result = new LinkedList<>();
        process.add(new Point (x,y));
        while (!process.isEmpty()){
            Point point = process.poll();
             int xCur = point.x;
             int yCur = point.y-1;
            if (xCur > 0 && xCur < xSize && yCur > 0 && yCur < ySize) {
                if (!edges[xCur][yCur]) {
                    result.add(new Point(xCur, yCur));
                    process.add(new Point(xCur, yCur));
                    edges[xCur][yCur]=true;
                }

            }
            xCur = point.x;
            yCur = point.y+1;
            if (xCur > 0 && xCur < xSize && yCur > 0 && yCur < ySize) {
                if (!edges[xCur][yCur]) {
                    result.add(new Point(xCur, yCur));
                    process.add(new Point(xCur, yCur));
                    edges[xCur][yCur]=true;
                }

            }
            xCur = point.x-1;
            yCur = point.y;
            if (xCur > 0 && xCur < xSize && yCur > 0 && yCur < ySize) {
                if (!edges[xCur][yCur]) {
                    result.add(new Point(xCur, yCur));
                    process.add(new Point(xCur, yCur));
                    edges[xCur][yCur]=true;
                }
                else {
                    System.out.println(xCur + " " + yCur);
                }
            }
            xCur = point.x + 1;
            yCur = point.y;
            if (xCur > 0 && xCur < xSize && yCur > 0 && yCur < ySize) {
                if (!edges[xCur][yCur]) {
                    result.add(new Point(xCur, yCur));
                    process.add(new Point(xCur, yCur));
                    edges[xCur][yCur]=true;
                }

            }








        }

        return result;
    }
}
