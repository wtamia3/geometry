package geometry;

public class TriangularPrism extends Geometry3D {
    private double base;
    private double height;
    private double length;

    public TriangularPrism(double base, double height, double length) {
        this.base = base;
        this.height = height;
        this.length = length;
    }

    @Override
    public double volume() {
        return 0.5 * base * height * length;
    }

    @Override
    public double surfaceArea() {
        // Simplified surface area calculation
        return base * height + 2 * (base * length + height * length);
    }

    @Override
    public String toString() {
        return "TriangularPrism [base=" + base + ", height=" + height + ", length=" + length + "]";
    }
}
