package problem;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;


public class Figures {
    Vector2 F;
    Vector2 v0;
    public static void renderPoint(GL2 gl, Vector2 pos, float size) {
        gl.glPointSize(size);
        gl.glBegin(GL.GL_POINTS);
        gl.glColor3d(0, 1, 0);
        gl.glVertex2d(pos.x, pos.y);
        gl.glEnd();
    }

    public static void renderLine(GL2 gl, Vector2 pos, float width) {
        gl.glLineWidth(5);
        gl.glBegin(GL.GL_LINES);
        gl.glColor3d(0, 1, 0);
        gl.glVertex2d(pos.x, pos.y);
        gl.glEnd();
    }

    public static void renderLine(GL2 gl, Vector2 pos, Vector2 pos2, float width) {
        gl.glLineWidth(width);
        gl.glBegin(GL.GL_LINES);
        gl.glColor3d(0, 1, 0);
        gl.glVertex2d(pos.x, pos.y);
        gl.glColor3d(0.4, 1, 0.5);
        gl.glVertex2d(pos2.x, pos2.y);
        gl.glEnd();
    }

    public static void renderTriangle(GL2 gl, Vector2 pos1, Vector2 pos2, Vector2 pos3, float width) {
        gl.glLineWidth(width);
        gl.glBegin(GL.GL_TRIANGLE_FAN);
        gl.glColor3d(0, 1, 0);
        gl.glVertex2d(pos1.x, pos1.y);
        gl.glColor3d(0.4, 1, 0.5);
        gl.glVertex2d(pos2.x, pos2.y);
        gl.glColor3d(0.6, 0.7, 0.5);
        gl.glVertex2d(pos3.x, pos3.y);
        gl.glEnd();
    }

    public static void renderQuad(GL2 gl, Vector2 pos1, Vector2 pos2, Vector2 pos3, Vector2 pos4, boolean filled) {
        if (filled) {
            gl.glBegin(GL.GL_TRIANGLE_FAN);
            gl.glColor3d(0, 1, 0);
            gl.glVertex2d(pos1.x, pos1.y);
            gl.glColor3d(0.4, 1, 0.5);
            gl.glVertex2d(pos2.x, pos2.y);
            gl.glColor3d(0.6, 0.7, 0.5);
            gl.glVertex2d(pos3.x, pos3.y);
            gl.glColor3d(0, 1, 0);
            gl.glVertex2d(pos4.x, pos4.y);
            gl.glEnd();
        } else {
            gl.glBegin(GL.GL_LINE_STRIP);
            gl.glColor3d(0, 1, 0);
            gl.glVertex2d(pos1.x, pos1.y);
            gl.glColor3d(0.4, 1, 0.5);
            gl.glVertex2d(pos2.x, pos2.y);
            gl.glColor3d(0.6, 0.7, 0.5);
            gl.glVertex2d(pos3.x, pos3.y);
            gl.glColor3d(0, 1, 0);
            gl.glVertex2d(pos4.x, pos4.y);
            gl.glColor3d(0, 1, 0);
            gl.glVertex2d(pos4.x, pos4.y);
            gl.glEnd();
        }
    }

    public static void renderCircle(GL2 gl, Vector2 pos, double r, boolean filled) {
        gl.glBegin(GL.GL_TRIANGLE_FAN);
        gl.glVertex2d(pos.x, pos.y);
        int n = 3600;
        for (int i = 1; i < n; i++) {
            double a = (2 * Math.PI / n) * i;
            double x = r * Math.cos(a);
            double y = r * Math.sin(a);
            gl.glVertex2d(x, y);
        }
        gl.glEnd();
    }

    public static void renderParabola(GL2 gl, Vector2 F, Vector2 v0) { // F-это фокус, v0-вершина

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
    public static void renderParabolacolour(GL2 gl, Vector2 F, Vector2 v0) { // F-это фокус, v0-вершина

        for (double i = -1; i < 1; i = i + 0.01) {
            double a = F.y - v0.y;
            double b = -2 * F.x * (F.y - v0.y);
            double c = v0.y + (b * b) / (4 * a);
            double y = a * i * i + b * i + c;
            gl.glColor3d(0, 1, 0);
            // y=ax^2+bx+c

            gl.glVertex2d(i, y);
        }
        gl.glEnd();
    }
    public void render1(GL2 gl) {

 renderParabolacolour(gl, F, v0);
    }

}



