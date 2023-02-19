public class Main1 {
    public static void main(String[] args) {
        Vector2D vector2D1 = new Vector2D(3,5);
        Vector2D vector2D2 = new Vector2D(7,2);

        Vector2D newVector2D = vector2D1.add(vector2D2);
        System.out.println("новый вектор, полученный в результате сложения 1 и 2 вектора, имеет координаты " + newVector2D.toString());

        vector2D1.add2(vector2D2);
        System.out.println("новое значение вектора 1, равное сумме 1 и 2 векторов: " + vector2D1);

        Vector2D vector2D4 = vector2D1.sub(vector2D2);
        System.out.println("новый вектор, равный разности 1 и 2 векторов: " + vector2D4.toString());

        vector2D1.sub2(vector2D2);
        System.out.println("новое значение вектора 1, равное разности 1 и 2 вектора: " + vector2D1);

        Vector2D vector2D5 = vector2D2.mult(6);
        System.out.println("новый вектор, равный произведению вектора 2 на число 6" + vector2D5);

        vector2D2.mult2(3);
        System.out.println("новое значение вектора 2, равное произведению этого вектора на 3" + vector2D2);

        System.out.println("длина вектора 2 равна " + vector2D2.length());

        System.out.println("скалярное произведение 1 и 2 вектора равно " + vector2D1.scalarProduct(vector2D2));

        System.out.println("cos угла между 1 и 2 векторов равен " + vector2D1.cos(vector2D2));

        if (vector2D1.equals(vector2D2)){
            System.out.println("вектор 1 равен вектору 2");
        } else {
            System.out.println("вектор 1 не равен вектору 2");
        }

    }

}