package proj0.stddraw;

import proj0.examples.StdDraw;

public class Try {
    public static void main(String[] args) {
        StdDraw.setScale(-10,10);
        StdDraw.enableDoubleBuffering();
        while (true) {
            double mousexx = 0;
            double mouseyy = StdDraw.mouseY();
            double left = 0 - 1;
            double right = 0 + 1;
            double up = StdDraw.mouseY() + 1;
            double down = StdDraw.mouseY() - 1;
            StdDraw.line(mousexx, up, left, mouseyy);
            StdDraw.line(left, mouseyy, mousexx, down);
            StdDraw.line(mousexx, down, right, mouseyy);
            StdDraw.line(right, mouseyy, mousexx, up);

            StdDraw.clear();
            StdDraw.setPenColor(StdDraw.BLUE);
            StdDraw.filledCircle(mousexx, mouseyy, 0.2);
            StdDraw.show();
            StdDraw.pause(10);
        }
//        double mousexx = 0;
//        double mouseyy = 0;
//        double left = -1;
//        double right = 0+ 1;
//        double up = 0+1;
//        double down = 0-1;
//        StdDraw.line(mousexx,up,left,mouseyy);
//        StdDraw.line(left,mouseyy,mousexx,down);
//        StdDraw.line(mousexx,down,right,mouseyy);
//        StdDraw.line(right,mouseyy,mousexx,up);

    }
}
