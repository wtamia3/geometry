package geometry;

public class RectangularPrism extends Geometry3D {
	double l;
	double w;
	double h;

	/**
	 * Default cube constructor.
	 * 
	 * @param l The length of the cube.
	 * @param w The width of the cube.
	 * @param h The height of the cube.
	 */
	public RectangularPrism(double l, double w, double h) {
		this.l = l;
		this.w = w;
		this.h = h;
	}

	/**
	 * Calculates the volume of the cube.
	 * 
	 * @return The volume of the cube.
	 */
	@Override
	double volume() {
		return l * w * h;
	}

	/**
	 * Calculates the surface area of the cube.
	 * 
	 * @return The surface area of the cube.
	 */
	@Override
	double surfaceArea() {
		// TODO Auto-generated method stub
		return 2 * (l * w + l * h + h * w);
	}

}
