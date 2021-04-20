package problem;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;

public class ParabolaResult {

    Parabola p1;
    Parabola p2;
    double x11;
    double x22;
    double y11;
    double y22;

    public ParabolaResult(Parabola p1, Parabola p2) {
        this.p1 = p1;
        this.p2 = p2;
        x11 = (p2.b - p1.b + Math.sqrt(Math.abs(Math.pow((p2.b - p1.b), 2)) - 4 * (p1.a - p2.a) * (p1.c - p2.c))) / (2 * (p1.a - p2.a));
        x22 = (p2.b - p1.b - Math.sqrt(Math.abs(Math.pow((p2.b - p1.b), 2)) - 4 * (p1.a - p2.a) * (p1.c - p2.c))) / (2 * (p1.a - p2.a));

        y11 = p1.a * x11 * x11 + p1.b * x11 + p1.c;
        y22 = p2.a * x22 * x22 + p2.b * x22 + p2.c;
    }

    public void render(GL2 gl) {
        gl.glPointSize(10);
        gl.glBegin(GL.GL_POINTS);
            gl.glVertex2d(x11,y11);
            gl.glVertex2d(x22,y22);
        gl.glEnd();
        gl.glBegin(GL2.GL_QUAD_STRIP);
        //заливка площади цветом
        for (double i = Math.min(x11,x22); i <= Math.max(x11,x22); i += 0.01) {
            double Y1 = p1.a * i * i + p1.b * i + p1.c;
            double Y2 = p2.a * i * i + p2.b * i + p2.c;
            gl.glVertex2d(i, Y1);
            gl.glVertex2d(i, Y2);
        }
        gl.glEnd();
    }
}
