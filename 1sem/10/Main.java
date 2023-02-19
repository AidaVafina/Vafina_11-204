public class Main {
    public static void main(String[] args) {
        ComplexNumber number1 = new ComplexNumber(2,3);
        ComplexNumber number2 = new ComplexNumber(4.8,2);
        System.out.println(number1.toString());
        System.out.println("сумма комплексных: " + number1.add(number2));
        number1.add2(number2);
        System.out.println("новое значение комплексного числа, равное сумме двух комплексных чисел: " + number1);
        System.out.println ("разность комплексных: " + number1.sub(number2));
        number1.sub2(number2);
        System.out.println("новое значение комплексного числа, равное разности двух комплексных чисел: " + number1);
        System.out.println("умножение комплексного числа на вещественное: " + number1.multNumber(5));
        number1.multNumber2(5);
        System.out.println("новое значение комплексного числа, равное его произведению на вещественное число: " + number1);
        System.out.println("произведение двух комплексных чисел: " + number1.mult(number2));
        number1.mult2(number2);
        System.out.println("новое значение комплексного числа, равное произведению двух комплексных чисел: " + number1);
        System.out.println("деление комплексных чисел: " + number1.div(number2));
        number1.div2(number2);
        System.out.println("новое значение комплексного числа, равное делению его на другое комплексное число: " + number1);
        System.out.println("модуль комплексного числа: " + number1.length());
        System.out.println("аргумент: " + number2.arg());
        System.out.println("возведение в степень: " + number2.pow(5));
        System.out.println("равность комплексных чисел: " + number1.equals(number2));
    }
}