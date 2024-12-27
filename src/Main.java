public class Main {
    public static void main(String[] args) {
        try {
            // Пример создания валидного треугольника
            Triangle triangle = new Triangle(3, 4, 5);
            System.out.println("Создан треугольник: " + triangle);

            // Пример создания невалидного треугольника
            Triangle invalidTriangle = new Triangle(1, 2, 10);
            System.out.println("Создан треугольник: " + invalidTriangle);

        } catch (IllegalTriangleException e) {
            System.err.println("Ошибка создания треугольника: " + e.getMessage());
        }
    }
}

// Класс для определения треугольника
class Triangle {
    private double sideA;
    private double sideB;
    private double sideC;

    // Конструктор
    public Triangle(double sideA, double sideB, double sideC) throws IllegalTriangleException {
        if (!isValidTriangle(sideA, sideB, sideC)) {
            throw new IllegalTriangleException("Сумма длин любых двух сторон должна быть больше длины третьей стороны.");
        }
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    // Метод для проверки валидности треугольника
    private boolean isValidTriangle(double sideA, double sideB, double sideC) {
        return sideA + sideB > sideC && sideA + sideC > sideB && sideB + sideC > sideA;
    }

    // Геттеры
    public double getSideA() {
        return sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public double getSideC() {
        return sideC;
    }

    @Override
    public String toString() {
        return "Triangle [sideA=" + sideA + ", sideB=" + sideB + ", sideC=" + sideC + "]";
    }
}

// Класс исключения
class IllegalTriangleException extends Exception {
    public IllegalTriangleException(String message) {
        super(message);
    }
}
