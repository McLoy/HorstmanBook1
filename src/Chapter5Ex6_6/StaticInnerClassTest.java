package Chapter5Ex6_6;

import java.util.DoubleSummaryStatistics;

public class StaticInnerClassTest {
    public static void main(String[] args) {

        double[] d = new double[20];
        for (int i = 0; i < d.length; i++)
            d[i] = 100*Math.random();
        ArrayAlg.Pair p = ArrayAlg.minmax(d);
        System.out.println("min=" + p.getFirst());
        System.out.println("max=" + p.getSecond());

    }
}

class ArrayAlg {

    public static class Pair {

        /**
         * объединение двух чисел с плавающей точкой
         *
         * @param f первое число
         * @param s второе число
         */

        public Pair(double f, double s) {
            first = f;
            second = s;
        }

        public double getFirst() {
            return first;
        }

        public double getSecond() {
            return second;
        }

        private double first;
        private double second;
    }

    /**
     * Определяет минимальное и максимальное число в массиве.
     *
     * @param d Массив чисел с плавающей точкой
     * @return Пара, в которой первый элемент
     * является минимальным числом массива,
     * а второй элемент - максимальным числом.
     */

    public static Pair minmax(double[] values) {

        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;

        for (double v : values) {
            if (min > v) min = v;
            if (max < v) max = v;
        }
        return new Pair(min, max);
    }
}