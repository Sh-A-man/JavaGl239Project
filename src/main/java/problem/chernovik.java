package problem;

public class chernovik {
    public void getmanyRandomParabolas(int k) {
        for (int z = 1, z < k, int z++) {

            public void getRandomParabola(Vector2 F, Vector2 v0) {
                for (int i = 1; i <= 2; i++) {
                    Point p = Point.getRandomPoint();
                    if (i==1) {
                        F.x = p.x;
                        F.y = p.y;
                        v0.x = p.x; }
                    if (i==2) {
                        v0.y = p.y; }

                }
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



        }}














    public void getRandomParabola(Vector2 F, Vector2 v0) {
        for (int i = 1; i <= 2; i++) {
            Point p = Point.getRandomPoint();
            if (i==1) {
                F.x = p.x;
                F.y = p.y;
                v0.x = p.x; }
            if (i==2) {
                v0.y = p.y; }

            }
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

