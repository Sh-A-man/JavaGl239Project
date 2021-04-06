package problem;

import javax.media.opengl.GL2;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Класс задачи
 */
public class Problem {
    /**
     * текст задачи
     */
    public static final String PROBLEM_TEXT = "ПОСТАНОВКА ЗАДАЧИ:\n" +
            "Заданы два множества точек в пространстве.\n" +
            "Требуется построить пересечения и разность этих множеств";

    /**
     * заголовок окна
     */
    public static final String PROBLEM_CAPTION = "Итоговый проект ученика 10-7 Иванова Ивана";

    /**
     * путь к файлу
     */
    private static final String FILE_NAME = "points.txt";

    /**
     * список точек
     */
    private ArrayList<Point> points;
    private ArrayList<Parabola> parabolas;

    /**
     * Конструктор класса задачи
     */
    public Problem() {
        points = new ArrayList<>();
        parabolas = new ArrayList<>();
    }

    /**
     * Добавить точку
     *
     * @param x координата X точки
     * @param y координата Y точки
     */
    public void addPoint(double x, double y, double x2, double y2) {
        Parabola point = new Parabola(new Vector2(x, y), new Vector2(x2, y2));
        parabolas.add(point);
    }

    /**
     * Решить задачу
     */
    public void solve() {
        ArrayList<Vector2> vectors;
        // перебираем пары точек
        double s0 = 0;
        for (Parabola p1 : parabolas) {
            for (Parabola p2 : parabolas) {
                if ((Math.pow((p2.b - p1.b), 2) - 4 * (p1.a - p2.a) * (p1.c - p2.c)) > 0) {
                    double x11 = (p2.b - p1.b + Math.sqrt(Math.abs(Math.pow((p2.b - p1.b), 2) - 4 * (p1.a - p2.a) * (p1.c - p2.c))) / (2 * (p1.a - p2.a)));
                    double x22 = (p2.b - p1.b - Math.sqrt(Math.abs(Math.pow((p2.b - p1.b), 2)) - 4 * (p1.a - p2.a) * (p1.c - p2.c))) / (2 * (p1.a - p2.a));
                    double y11 = p1.a * x11 * x11 + p1.b * x11 + p1.c;
                    double y22 = p2.a * x22 * x22 + p2.b * x22 + p2.c;
                    if (Math.abs(x11) < 1 && Math.abs(x22) < 1 && Math.abs(y11) < 1 && Math.abs(y22) < 1) {
                        double s = Math.abs((Math.pow(x22, 3) - Math.pow(x11, 3)) * (p2.a - p1.a) / 3 + (Math.pow(x22, 2) - Math.pow(x11, 2)) * (p2.b - p1.b) / 2 + (x22 - x11) * (p2.c - p1.c));

                        if (s > s0) s0 = s;
                    }
                }

            }
        }
        if(s0!=0)
            System.out.println(s0);
        else
            System.out.println("Параболы не пересекаются");
    }

    /**
     * Загрузить задачу из файла
     */
    public void loadFromFile() {
        points.clear();
        try {
            File file = new File(FILE_NAME);
            Scanner sc = new Scanner(file);
            // пока в файле есть непрочитанные строки
            while (sc.hasNextLine()) {
                double x = sc.nextDouble();
                double y = sc.nextDouble();
                int setVal = sc.nextInt();
                sc.nextLine();
                Point point = new Point(x, y, setVal);
                points.add(point);
            }
        } catch (Exception ex) {
            System.out.println("Ошибка чтения из файла: " + ex);
        }
    }

    /**
     * Сохранить задачу в файл
     */
    public void saveToFile() {
        try {
            PrintWriter out = new PrintWriter(new FileWriter(FILE_NAME));
            for (Point point : points) {
                out.printf("%.2f %.2f %d\n", point.x, point.y, point.setNumber);
            }
            out.close();
        } catch (IOException ex) {
            System.out.println("Ошибка записи в файл: " + ex);
        }
    }

    /**
     * Добавить заданное число случайных точек
     *
     * @param n кол-во точек
     */
    public void addRandomParabolas(int n) {
        for (int i = 0; i < n; i++) {
            Parabola p = Parabola.getRandomParabola();
            parabolas.add(p);
        }
    }

    public void addRandomPoints(int n) {
        for (int i = 0; i < n; i++) {
            Parabola p = Parabola.getRandomParabola();
            parabolas.add(p);
        }
    }


    /**
     * Очистить задачу
     */
    public void clear() {
        points.clear();
        parabolas.clear();
    }

    /**
     * Нарисовать задачу
     *
     * @param gl переменная OpenGL для рисования
     */
    public void render(GL2 gl) {
        for (Point point : points) {
            point.render(gl);
        }

        for (Parabola parabola : parabolas) {
            parabola.render(gl);
        }
        //Figures.renderLine(gl, new Vector2(0.5, 1),new Vector2(0.6,0), 1);
        //Figures.renderTriangle(gl,new Vector2(-0.9,0),new Vector2(-0,0),1),new Vector2(0.4,0.5), false);
        //Figures.renderQuad(gl,new Vector2(-0.9,0),new Vector(-0,0),1),new Vector2(0.4,0.5), false);
        //Figures.renderCircle(gl, new Vector2(0, 0), 0.5, field false);
        //Parabola p = new Parabola(new Vector2(0,0.8), new Vector2(0, 0));
       // Parabola.renderParabola(gl, new Vector2(0, 1), new Vector2(0, -0.85));


    }
}
