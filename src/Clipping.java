import java.util.ArrayList;

/**
 * Created by HP on 01.11.2017.
 */
public class Clipping {

    final int  LEFT = 8;
    final int RIGHT =4;
    final int BOTTOM = 2;
    final int TOP = 1;
    private int xLeft;
    private int yLeft;
    private int xRight;
    private int yRight;
    private Model model;
    public Clipping(int  xLeft, int yLeft, int xRight, int yRight,Model model){
        this.xLeft = xLeft;
        this.yLeft = yLeft;
        this.xRight = xRight;
        this.yRight = yRight;
        this.model = model;

    }
    public Clipping(Model model){
        this.model = model;
    }

    public void setBegin(int x , int y){
        this.xLeft = x ;
        this.yLeft = y;
    }
    public void setEnd(int x, int y){
        this.xRight = x;
        this.yRight = y;
    }


   public boolean findInnerClipping(ArrayList<Integer> codes ){
       double xL = codes.get(0);
       double yL = codes.get(1);

       double xR = codes.get(3);
        double yR = codes.get(4);
        int codeL = codes.get(2);
        int codeR = codes.get(5);

       while ((codeL!=0 || codeR!=0)  && (codeL & codeR)==0){

           int code;
           if(codeL!=0){
               code = codeL;
               if ((code & LEFT) !=0){

                   yL = (yR - yL) / (xR - xL) * (xLeft - xL) + yL ;
                   xL = xLeft;

               }
               else if ((code & RIGHT)!=0){

                   yL = (yR - yL)/(xR - xL) * (xRight - xL) + yL;
                   xL = xRight;



               }
               else if ( (code & BOTTOM) !=0){

                   xL = (xR - xL) / (yR - yL) *  ( yLeft- yL) + xL;
                   yL=yLeft;

               }
               else if ( (code & TOP)!=0){

                   xL = (xR - xL) / (yR - yL) * (yRight - yL ) + xL;

                   yL=yRight;
               }
               StringBuilder newCodeL =new StringBuilder();
               if (xL < xLeft){
                   newCodeL.append("1");
               }else {
                   newCodeL.append("0");
               }
               if(xL <= xRight){
                   newCodeL.append("0");
               }else {
                   newCodeL.append("1");
               }
               if(yL < yLeft){
                   newCodeL.append("1");
               }else{
                   newCodeL.append("0");
               }
               if(yL <= yRight){
                   newCodeL.append("0");
               }else{
                   newCodeL.append("1");
               }
               codeL = Integer.parseInt(newCodeL.toString(),2);
           }else {
               code = codeR;


               if ((code & LEFT) != 0) {

                   yR = (yR - yL) / (xR - xL) * (xLeft - xL) + xL;
                   xR = xLeft;

               } else if ((code & RIGHT) != 0) {

                   yR = (yR - yL) / (xR - xL) * (xRight - xL) + xL;
                   xR = xRight;


               } else if ((code & BOTTOM) != 0) {

                   xR = (xR - xL) / (yR - yL) * (yLeft - yL) +xL;
                   yR = yLeft;

               } else if ((code & TOP) != 0) {

                   xR = (xR - xL) / (yR - yL) * (yRight - yL) +xL;
                   yR = yRight;

               }
               StringBuilder newCodeR =new StringBuilder();
               if (xR < xLeft){
                   newCodeR.append("1");
               }else {
                   newCodeR.append("0");
               }
               if(xR <= xRight){
                   newCodeR.append("0");
               }else {
                   newCodeR.append("1");
               }
               if(yR < yLeft){
                   newCodeR.append("1");
               }else{
                   newCodeR.append("0");
               }
               if(yR <= yRight){
                   newCodeR.append("0");
               }else{
                   newCodeR.append("1");
               }
               codeR = Integer.parseInt(newCodeR.toString(),2);

           }
       }

       if (codeL==0 && codeR==0){


           codes.set(0,(int)xL);
           codes.set(1,(int)yL);
           codes.set(2,(int)xR);
           codes.set(3,(int)yR);
           codes.set(4,codeL);
           codes.set(5,codeR);
           return  true;
       }else{
           return false;
       }



    }

    public ArrayList<Shape> clippingAlgorithm(){
        ArrayList<Shape> drawnShapes = model.getDrawnShapes();
        ArrayList<Shape> result =new ArrayList<>();
        ArrayList<ArrayList<Integer>>  codesOfShapes = new ArrayList<>();



        for (int  i =0; i<drawnShapes.size();i++){

            Shape shape = drawnShapes.get(i);
            if (shape instanceof  Line) {

                Line line = (Line) shape;
                codesOfShapes.add(new ArrayList<>());
                for (int j = 0, xLine = line.getxBegin(), yLine = line.getyBegin(); j < 2; j++,xLine = line.getxEnd(),yLine = line.getyEnd()) {
                    StringBuilder code = new StringBuilder();

                     if (xLine < xLeft){
                         code.append("1");
                     }else {
                         code.append("0");
                     }
                    if(xLine <= xRight){
                        code.append("0");
                    }else {
                        code.append("1");
                    }
                    if(yLine < yLeft){
                        code.append("1");
                    }else{
                        code.append("0");
                    }
                    if(yLine <= yRight){
                        code.append("0");
                    }else{
                        code.append("1");
                    }

                    codesOfShapes.get(i).add(xLine);
                    codesOfShapes.get(i).add(yLine);
                    codesOfShapes.get(i).add(Integer.parseInt(code.toString(),2));
                }
            }

        }

         for (int  i=0 ;i<codesOfShapes.size();i++){
             int xL = codesOfShapes.get(i).get(0);
             int yL = codesOfShapes.get(i).get(1);

             int xR = codesOfShapes.get(i).get(3);
             int yR = codesOfShapes.get(i).get(4);

             int codeL = codesOfShapes.get(i).get(2);
             int codeR = codesOfShapes.get(i).get(5);



             if (codeL==0 && codeR ==0){
                 result.add(new Line(xL,yL,xR,yR));
             }
             else if ((codeL & codeR)==0){
                 if(findInnerClipping(codesOfShapes.get(i))){
                     result.add(new Line(codesOfShapes.get(i).get(0),codesOfShapes.get(i).get(1),codesOfShapes.get(i).get(2),codesOfShapes.get(i).get(3)));
                 }

             }


         }
        return result;
    }
}
