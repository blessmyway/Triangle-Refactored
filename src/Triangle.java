package src;

import java.util.Objects;

/**
 * Рефакторинг класу Triangle з дотриманням Java Naming Conventions та валідацією.
 */
public class Triangle {
    private double a;
    private double b;
    private double c;

    public Triangle() {
        this(3.0, 4.0, 5.0);
    }

    public Triangle(double a, double b, double c) {
        validateSides(a, b, c);
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() { return a; }
    public void setA(double a) {
        validateSides(a, this.b, this.c);
        this.a = a;
    }

    public double getB() { return b; }
    public void setB(double b) {
        validateSides(this.a, b, this.c);
        this.b = b;
    }

    public double getC() { return c; }
    public void setC(double c) {
        validateSides(this.a, this.b, c);
        this.c = c;
    }

    public double getPerimeter() {
        return a + b + c;
    }

    public double getArea() {
        double p = getPerimeter() / 2.0;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    private static void validateSides(double a, double b, double c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException("Сторони повинні бути більшими за 0");
        }
        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new IllegalArgumentException("Сума двох сторін має бути більшою за третю");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Double.compare(triangle.a, a) == 0 &&
               Double.compare(triangle.b, b) == 0 &&
               Double.compare(triangle.c, c) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, c);
    }

    @Override
    public String toString() {
        return String.format("Triangle{a=%.2f, b=%.2f, c=%.2f}", a, b, c);
    }
}
