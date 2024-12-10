package geometry;

import java.util.LinkedList;  // Ensure this import is present
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        LinkedList<Geometry2D> geometries2D = new LinkedList<>();
        LinkedList<Geometry3D> geometries3D = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an option: add, remove, find, exit");
            String option = scanner.nextLine().trim().toLowerCase();

            if (option.equals("exit")) {
                break;
            }

            switch (option) {
                case "add":
                    handleAdd(scanner, geometries2D, geometries3D);
                    break;
                case "remove":
                    handleRemove(scanner, geometries2D, geometries3D);
                    break;
                case "find":
                    handleFind(scanner, geometries2D, geometries3D);
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }

        scanner.close();
    }

    private static void handleAdd(Scanner scanner, LinkedList<Geometry2D> geometries2D, LinkedList<Geometry3D> geometries3D) {
        System.out.println("Add 2D or 3D geometry?");
        String type = scanner.nextLine().trim().toLowerCase();

        if (type.equals("2d")) {
            System.out.println("Enter type (rectangle, circle, triangle):");
            String shape = scanner.nextLine().trim().toLowerCase();
            switch (shape) {
                case "rectangle":
                    System.out.println("Enter width and height:");
                    double width = scanner.nextDouble();
                    double height = scanner.nextDouble();
                    scanner.nextLine(); // consume newline
                    geometries2D.add(new Rectangle(width, height));
                    break;
                case "circle":
                    System.out.println("Enter radius:");
                    double radius = scanner.nextDouble();
                    scanner.nextLine(); // consume newline
                    geometries2D.add(new Circle(radius));
                    break;
                case "triangle":
                    System.out.println("Enter base and height:");
                    double base = scanner.nextDouble();
                    double triHeight = scanner.nextDouble();
                    scanner.nextLine(); // consume newline
                    geometries2D.add(new Triangle(base, triHeight));
                    break;
                default:
                    System.out.println("Invalid shape");
            }
        } else if (type.equals("3d")) {
            System.out.println("Enter type (sphere, triangularprism):");
            String shape = scanner.nextLine().trim().toLowerCase();
            switch (shape) {
                case "sphere":
                    System.out.println("Enter radius:");
                    double radius = scanner.nextDouble();
                    scanner.nextLine(); // consume newline
                    geometries3D.add(new Sphere(radius));
                    break;
                case "triangularprism":
                    System.out.println("Enter base, height, and length:");
                    double base = scanner.nextDouble();
                    double triHeight = scanner.nextDouble();
                    double length = scanner.nextDouble();
                    scanner.nextLine(); // consume newline
                    geometries3D.add(new TriangularPrism(base, triHeight, length));
                    break;
                default:
                    System.out.println("Invalid shape");
            }
        } else {
            System.out.println("Invalid type");
        }
    }

    private static void handleRemove(Scanner scanner, LinkedList<Geometry2D> geometries2D, LinkedList<Geometry3D> geometries3D) {
        System.out.println("Remove 2D or 3D geometry?");
        String type = scanner.nextLine().trim().toLowerCase();

        if (type.equals("2d")) {
            System.out.println("Enter index to remove:");
            int index = getValidIndex(scanner);  // Call the helper method for validation
            if (index >= 0 && index < geometries2D.size()) {
                Geometry2D geometryToRemove = geometries2D.get(index);  // Using LinkedList's get method
                geometries2D.remove(geometryToRemove);
                System.out.println("Removed: " + geometryToRemove);
            } else {
                System.out.println("Invalid index");
            }
        } else if (type.equals("3d")) {
            System.out.println("Enter index to remove:");
            int index = getValidIndex(scanner);  // Call the helper method for validation
            if (index >= 0 && index < geometries3D.size()) {
                Geometry3D geometryToRemove = geometries3D.get(index);  // Using LinkedList's get method
                geometries3D.remove(geometryToRemove);
                System.out.println("Removed: " + geometryToRemove);
            } else {
                System.out.println("Invalid index");
            }
        } else {
            System.out.println("Invalid type");
        }
    }

    private static void handleFind(Scanner scanner, LinkedList<Geometry2D> geometries2D, LinkedList<Geometry3D> geometries3D) {
        System.out.println("Find 2D or 3D geometry?");
        String type = scanner.nextLine().trim().toLowerCase();

        if (type.equals("2d")) {
            System.out.println("Enter index to find:");
            int index = getValidIndex(scanner);  // Call the helper method for validation
            if (index >= 0 && index < geometries2D.size()) {
                Geometry2D geometry = geometries2D.get(index);  // Using LinkedList's get method
                System.out.println("Found: " + geometry);
            } else {
                System.out.println("Invalid index");
            }
        } else if (type.equals("3d")) {
            System.out.println("Enter index to find:");
            int index = getValidIndex(scanner);  // Call the helper method for validation
            if (index >= 0 && index < geometries3D.size()) {
                Geometry3D geometry = geometries3D.get(index);  // Using LinkedList's get method
                System.out.println("Found: " + geometry);
            } else {
                System.out.println("Invalid index");
            }
        } else {
            System.out.println("Invalid type");
        }
    }

    // Helper method to get a valid index
    private static int getValidIndex(Scanner scanner) {
        int index = -1;
        while (true) {
            try {
                index = scanner.nextInt();
                scanner.nextLine(); // consume newline
                break;  // exit the loop if input is valid
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // clear buffer
            }
        }
        return index;
    }
}
