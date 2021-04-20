//package problem;
//
//public class solve {
//    public void solve() {
//        ArrayList<Vector2> vectors;
//        // перебираем пары точек
//        double s0 = 0;
//        //коэффициенты двух искомых парабол
//        double A1;
//        double B1;
//        double C1;
//        double A2;
//        double B2;
//        double C2;
//
//        for (Parabola p1 : parabolas) {
//            for (Parabola p2 : parabolas) {
//                if ((Math.pow((p2.b - p1.b), 2) - 4 * (p1.a - p2.a) * (p1.c - p2.c)) > 0) {
//                    double x11 = (p2.b - p1.b + Math.sqrt(Math.abs(Math.pow((p2.b - p1.b), 2) - 4 * (p1.a - p2.a) * (p1.c - p2.c))) / (2 * (p1.a - p2.a)));
//                    double x22 = (p2.b - p1.b - Math.sqrt(Math.abs(Math.pow((p2.b - p1.b), 2)) - 4 * (p1.a - p2.a) * (p1.c - p2.c))) / (2 * (p1.a - p2.a));
//                    double y11 = p1.a * x11 * x11 + p1.b * x11 + p1.c;
//                    double y22 = p2.a * x22 * x22 + p2.b * x22 + p2.c;
//                    if (Math.abs(x11) < 1 && Math.abs(x22) < 1 && Math.abs(y11) < 1 && Math.abs(y22) < 1) {
//                        double s = Math.abs((Math.pow(x22, 3) - Math.pow(x11, 3)) * (p2.a - p1.a) / 3 + (Math.pow(x22, 2) - Math.pow(x11, 2)) * (p2.b - p1.b) / 2 + (x22 - x11) * (p2.c - p1.c));
//
//                        if (s > s0) {
//                            s0 = s;
//                            A1 = p1.a;
//                            B1 = p1.b;
//                            C1 = p1.c;
//                            A2 = p2.a;
//                            B2 = p2.b;
//                            C2 = p2.c;
//
//
//                        }
//                    }
//                }
//
//            }
//        }
//        if(s0!=0) System.out.println(s0);
//        else
//            System.out.println("Параболы не пересекаются");
//    }
//
//}
