package problem;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.GL2GL3;
import java.util.Random;
import java.util.Vector;

public class Parabola {
    Vector2 F;
    Vector2 v0;
    double p;
    double a;
    double b;
    double c;
    boolean IsSolve;

    public Parabola(Vector2 F, Vector2 v) {
        this.F = F;
        this.v0 = v;
        a = F.y - v0.y;
        b = -2 * F.x * (F.y - v0.y);
        c = v0.y + (b * b) / (4 * a);


    }

    public static void renderParabola(GL2 gl, Vector2 F, Vector2 v0) { // F-это фокус, v0-вершина
        gl.glBegin(GL.GL_LINE_STRIP);
        for (double i = -1; i < 1; i = i + 0.01) {
            double a = F.y - v0.y;
            double b = -2 * F.x * (F.y - v0.y);
            double c = v0.y + (b * b) / (4 * a);
            double y = a * i * i + b * i + c;
            // y=ax^2+bx+c

            gl.glVertex2d(i, y);
        }
        gl.glEnd();
    }
    public static void renderParabolacolour(GL2 gl, Vector2 F, Vector2 v0, double n) { // F-это фокус, v0-вершина

        for (double i = -1; i < 1; i = i + 0.01) {
           double a = F.y - v0.y;
            double b = -2 * F.x * (F.y - v0.y);
            double c = v0.y + (b * b) / (4 * a);
            double y = a * i * i + b * i + c;
            gl.glColor3d(0, 1, n);
            // y=ax^2+bx+c

            gl.glVertex2d(i, y);
        }
        gl.glEnd();
    }
    public static Parabola getRandomParabola() {
        Random r = new Random();
        double nx1 = (double) r.nextDouble() * 2 - 1;
        double ny1 = (double) r.nextDouble() * 2 - 1;

        double ny2 = (double) r.nextDouble() * 2 - 1;
        return new Parabola(new Vector2(nx1, ny1), new Vector2(nx1, ny2));


    }

    public void render(GL2 gl) {
        renderParabola(gl, F, v0);

    }
    public void render1(GL2 gl, double n) {

        renderParabolacolour(gl, F, v0, n);}


    }


    //for (int i = 1; i <= 2; i++) {
    //  Point p = Point.getRandomPoint();
    //if (i==1) {
    //  F.x = p.x;
    // F.y = p.y;
    //v0.x = p.x; }
    //if (i==2) {
    //  v0.y = p.y; }

//}
//        for (double i = -1; i < 1; i = i + 0.01) {
//            double a = F.y - v0.y;
//            double b = -2 * F.x * (F.y - v0.y);
//            double c = v0.y + (b * b) / (4 * a);
//            double y = a * i * i + b * i + c;
// y=ax^2+bx+c

//   gl.glVertex2d(i, y);
// }
// gl.glEnd();





