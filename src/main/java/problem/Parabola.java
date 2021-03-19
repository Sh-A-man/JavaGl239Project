package problem;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.GL2GL3;
import java.util.Vector;

public class Parabola {
    Vector2 F;
    Vector2 v0;
    double p;

    public Parabola(Vector2 F, Vector2 v) {
        this.F = F;
        this.v0 = v;

    }

    public static void renderParabola(GL2 gl, Vector2 F, Vector2 v0) { // F-это фокус, v0-вершина
        gl.glColor3d(1, 1, 1);
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
}



