public class ComplexNumber {
    double realNumber;
    double imaginaryNumber;
    public ComplexNumber(){
    }

    public ComplexNumber(double realNumber, double imaginaryNumber){
        this.realNumber = realNumber;
        this.imaginaryNumber = imaginaryNumber;
    }

    public String toString(){
        return realNumber + " + " + imaginaryNumber + "*i";
    }

    public ComplexNumber add(ComplexNumber complexNumber){
        double realNumber1 = realNumber + complexNumber.realNumber;
        double imaginaryNumber1 = imaginaryNumber + complexNumber.imaginaryNumber;
        ComplexNumber newComplexNumber1 = new ComplexNumber(realNumber1,imaginaryNumber1);
        return newComplexNumber1;
    }

    public void add2(ComplexNumber complexNumber){
        realNumber = realNumber + complexNumber.realNumber;
        imaginaryNumber = imaginaryNumber + complexNumber.imaginaryNumber;
    }

    public ComplexNumber sub(ComplexNumber complexNumber){
        ComplexNumber newComplexNumber = new ComplexNumber(realNumber - complexNumber.realNumber, imaginaryNumber - complexNumber.imaginaryNumber);
        return newComplexNumber;
    }

    public void sub2(ComplexNumber complexNumber){
        realNumber = realNumber - complexNumber.realNumber;
        imaginaryNumber = imaginaryNumber - complexNumber.imaginaryNumber;
    }

    public ComplexNumber multNumber(double a){
        ComplexNumber newComplexNumber = new ComplexNumber(realNumber * a, imaginaryNumber * a);
        return newComplexNumber;
    }

    public void multNumber2(double a){
        realNumber = realNumber * a;
        imaginaryNumber = imaginaryNumber * a;
    }

    public ComplexNumber mult(ComplexNumber complexNumber){
        ComplexNumber newNum = new ComplexNumber(realNumber * complexNumber.realNumber - imaginaryNumber * complexNumber.imaginaryNumber, realNumber*complexNumber.imaginaryNumber + imaginaryNumber * complexNumber.realNumber);
        return newNum;
    }

    public void mult2(ComplexNumber complexNumber){
        double real = realNumber * complexNumber.realNumber - imaginaryNumber * complexNumber.imaginaryNumber;
        imaginaryNumber = realNumber*complexNumber.imaginaryNumber + imaginaryNumber*complexNumber.realNumber;
        realNumber = real;
    }

    public ComplexNumber div(ComplexNumber complexNumber){
        double realNum = (realNumber*complexNumber.realNumber + imaginaryNumber*complexNumber.imaginaryNumber) / (complexNumber.realNumber*complexNumber.realNumber + complexNumber.imaginaryNumber*complexNumber.imaginaryNumber);
        double imagNum = (complexNumber.realNumber*imaginaryNumber - realNumber*complexNumber.imaginaryNumber) / (complexNumber.realNumber*complexNumber.realNumber + complexNumber.imaginaryNumber*complexNumber.imaginaryNumber);
        ComplexNumber complexNumber1 = new ComplexNumber(realNum,imagNum);
        return complexNumber1;
    }

    public void div2(ComplexNumber complexNumber){
        double rea = (realNumber*complexNumber.realNumber + imaginaryNumber*complexNumber.imaginaryNumber) / (complexNumber.realNumber*complexNumber.realNumber + complexNumber.imaginaryNumber*complexNumber.imaginaryNumber);
        imaginaryNumber = (complexNumber.realNumber*imaginaryNumber - realNumber*complexNumber.imaginaryNumber) / (complexNumber.realNumber*complexNumber.realNumber + complexNumber.imaginaryNumber*complexNumber.imaginaryNumber);
        realNumber = rea;
    }

    public double length(){
        double len = Math.pow(realNumber*realNumber + imaginaryNumber*imaginaryNumber,0.5);
        return len;
    }

    public double arg(){
        double argA = imaginaryNumber / realNumber;
        return Math.atan(argA);
    }

    public ComplexNumber pow(double a){
        double r = length();
        ComplexNumber newNum = new ComplexNumber(Math.pow(r,a) * Math.cos(arg() * a),Math.pow(r,a) * Math.sin(arg()*a));
        return newNum;
    }

    public boolean equals(ComplexNumber complexNumber){
        if ((realNumber == complexNumber.realNumber) && (imaginaryNumber == complexNumber.imaginaryNumber)){
            return true;
        } else {
            return false;
        }
    }
}