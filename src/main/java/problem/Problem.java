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
    }

    /**
     * Добавить точку
     *
     * @param x      координата X точки
     * @param y      координата Y точки
     * @param setVal номер множества
     */
    public void addPoint(double x, double y, int setVal) {
        Point point = new Point(x, y, setVal);
        points.add(point);
    }

    /**
     * Решить задачу
     */
    public void solve() {
            ArrayList<Vector> vectors;
        // перебираем пары точек
        double s0 = 0;
        for (Parabola p1: parabolas) {
            for (Parabola p2:parabolas) {
                    if ((p2.b-p1.b),2)-4(p1.a-p2.a)(p1.c-p2.c) > 0) {
                    double x11 = (p2.b-p1.b+Math.sqrt(Math.abs((p2.b-p1.b),2)-4(p1.a-p2.a)(p1.c-p2.c)))/(2*(p1.a-p2.a));
                    double x22 = (p2.b-p1.b-Math.sqrt(Math.abs((p2.b-p1.b),2)-4(p1.a-p2.a)(p1.c-p2.c)))/(2*(p1.a-p2.a));
                    double y11 = p1.a*x11*x11+p1.b*x11+p1.c;
                    double y22 = p2.a*x22*x22+p2.b*x22+p2.c;
                    }
                    double s = Math.abs(((x22, 3)-(x11, 3))*(p2.a-p1.a)/3 + ((x22, 2)-(x11, 2))*(p2.b-p1.b)/2 + (x22-x11)*(p2.c-p1.c));
                    if(s>s0) s0 = s;
            }
                }
        out.println(s0);
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
    public void addRandomPoints(int n) {
        for (int i = 0; i < n; i++) {
            Point p = Point.getRandomPoint();
            points.add(p);
        }
    }
    public void addRandomParabola(int n){
        for (int i=0;i<n;i++){
            Point a = Point.getRandomPoint();
            Point b = Point.getRandomPoint();
            parabolas.add(new Parabola(new Vector2(a.x,a.y), new Vector2(b.x,b.y)));
        }
    }
    /**
     * Очистить задачу
     */
    public void clear() {
        points.clear();
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
        for (Parabola p: parabolas){
            p.render(gl);
        }
        //Figures.renderLine(gl, new Vector2(0.5, 1),new Vector2(0.6,0), 1);
        //Figures.renderTriangle(gl,new Vector2(-0.9,0),new Vector2(-0,0),1),new Vector2(0.4,0.5), false);
        //Figures.renderQuad(gl,new Vector2(-0.9,0),new Vector(-0,0),1),new Vector2(0.4,0.5), false);
        //Figures.renderCircle(gl, new Vector2(0, 0), 0.5, field false);
        //Figures.renderParabola(gl, new Vector2);
    }
}
