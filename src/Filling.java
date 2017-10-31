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
            for (int i =0,xCur=point.x-1, yCur=point.y-1; i<3;i++,xCur++) {
                if (xCur > 0 && xCur < xSize && yCur > 0 && yCur < ySize) {
                    if (!edges[xCur][yCur]) {
                        result.add(new Point(xCur, yCur));
                        process.add(new Point(xCur, yCur));
                        edges[xCur][yCur]=true;
                    }
                }
            }
            for (int i=0, xCur= point.x-1, yCur = point.y+1; i<3;i++,xCur++){
                if (xCur > 0 && xCur < xSize && yCur > 0 && yCur < ySize) {
                    if (!edges[xCur][yCur]) {
                        result.add(new Point(xCur, yCur));
                        process.add(new Point(xCur, yCur));
                        edges[xCur][yCur] = true;
                    }
                }
            }

            for (int i=0, xCur= point.x-1,yCur=point.y ; i<2;i++,xCur+=2){
                if (xCur > 0 && xCur < xSize && yCur > 0 && yCur < ySize) {
                    if (!edges[xCur][yCur]) {
                        result.add(new Point(xCur, yCur));
                        process.add(new Point(xCur, yCur));
                        edges[xCur][yCur] = true;
                    }
                }
            }



        }
        return result;
    }
}
