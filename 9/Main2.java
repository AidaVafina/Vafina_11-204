public class Main2{
    public static void main(String[] args) {
        RationalFraction number1 = new RationalFraction(6,14);
        RationalFraction number2 = new RationalFraction(4,10);

        System.out.println("Изначальное значение первой дроби: " + number1.toString());
        System.out.println("Десятичное значение первой дроби: " + number1.value());
        System.out.println("Целая часть первой дроби: " + number1.numberPart());
        System.out.println("Изначальное значение второй дроби: " + number2.toString());
        System.out.println("Десятичное значение второй дроби: " + number2.value());
        System.out.println("Целая часть второй дроби: " + number2.numberPart());

        if (number1.equals(number2)){
            System.out.println("Первая дробь равна второй");
        } else {
            System.out.println("Первая дробь не равна второй");
        }

        number1.reduce();
        System.out.println("Сокращенная первая дробь: " + number1);
        System.out.println("Сумма первой и второй дроби: " + number1.add(number2));
        number1.add2(number2);
        number1.reduce();
        System.out.println("Значение первой дроби после присвоения ей значения суммы первой и второй дроби: " + number1);
        System.out.println("Разность первой и второй дроби: " + number1.sub(number2));
        number1.sub2(number2);
        number1.reduce();
        System.out.println("Значение первой дроби после присвоения ей значения разности первой и второй дроби: " + number1);
        System.out.println("Произведение первой и второй дроби: " + number1.mult(number2));
        number1.mult2(number2);
        number1.reduce();
        System.out.println("Значение первой дроби после присвоения ей значения произведения первой и второй дроби: " + number1);
        System.out.println("В результате деления первой дроби на вторую получается дробь " + number1.div(number2));
        number1.div2(number2);
        number1.reduce();
        System.out.println("Значение первой дроби после присвоения ей значения частного первой и второй дроби: " + number1);

    }
}