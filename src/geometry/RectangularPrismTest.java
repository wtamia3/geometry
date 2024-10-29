package geometry;

//import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RectangularPrismTest {
	@Test
	void should_create_cube() {
		RectangularPrism _ = new RectangularPrism(10.0, 10.0, 10.0);
	}
	
	@Test
	void should_have_volume_one() {
		RectangularPrism cube = new RectangularPrism(1.0, 1.0, 1.0);
		assert(cube.volume() == 1.0);
	}
	
	@Test
	void should_calculate_surface_area() {
		RectangularPrism cube = new RectangularPrism(1.0, 1.0, 1.0);
		assert(cube.surfaceArea() == 6.0);
	}

}
