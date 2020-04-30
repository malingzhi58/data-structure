package proj0.stddraw;

import proj0.examples.StdDraw;

public class MyAttractor {
    /**
     * double mousexx = StdDraw.mouseX();
     *             double mouseyy = StdDraw.mouseY();
     *             double left = StdDraw.mouseX()- 5;
     *             double right = StdDraw.mouseX()+ 5;
     *             double up = StdDraw.mouseY()+5;
     *             double down = StdDraw.mouseY()-5;
     *             StdDraw.line(mousexx,up,left,mouseyy);
     *             StdDraw.line(left,mouseyy,mousexx,down);
     *             StdDraw.line(mousexx,down,right,mouseyy);
     *             StdDraw.line(right,mouseyy,mousexx,up);
     * @param args
     */




    public static void main(String[] args) {
        double rx = 0.0, ry = 0.0;   // position
        double vx = 0.0, vy = 0.0;   // velocity
        double mass = 1.0;           // mass
        double dt   = 0.5;           // time quantum
        double drag = 0.1;           // mess around with this a bit
        double attractionStrength = 0.01;

        // do the animation
        StdDraw.enableDoubleBuffering();
        while (true) {

            // compute the attractive force to the mouse, accounting for drag
            double dx = StdDraw.mouseX() - rx;
            double dy = StdDraw.mouseY() - ry;
            double fx = (dx * attractionStrength) - (drag * vx);
            double fy = (dy * attractionStrength) - (drag * vy);

            double mousexx = StdDraw.mouseX();
            double mouseyy = StdDraw.mouseY();
            double left = StdDraw.mouseX()- 100;
            double right = StdDraw.mouseX()+ 100;
            double up = StdDraw.mouseY()+100;
            double down = StdDraw.mouseY()-100;
            StdDraw.line(mousexx,up,left,mouseyy);
            StdDraw.line(left,mouseyy,mousexx,down);
            StdDraw.line(mousexx,down,right,mouseyy);
            StdDraw.line(right,mouseyy,mousexx,up);

            // Euler step: update velocity, then position
            vx += fx * dt / mass;
            vy += fy * dt / mass;
            rx += vx * dt;
            ry += vy * dt;

            // draw particle
            StdDraw.clear();
            StdDraw.setPenColor(StdDraw.BLUE);
            StdDraw.filledCircle(rx, ry, 0.02);
            StdDraw.show();
            StdDraw.pause(10);
        }
    }
}