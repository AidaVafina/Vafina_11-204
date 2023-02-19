public class RationalFraction {
    public int numerator;
    public int denominator;

    public RationalFraction(){
    }

    public RationalFraction(int numerator, int denominator){
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public void reduce(){
        for (int i = numerator; i >= 1; i--) {
            if (numerator % i == 0 && denominator % i == 0) {
                numerator /= i;
                denominator /= i;
            }
        }
    }

    public RationalFraction add(RationalFraction f){
        RationalFraction newFraction = new RationalFraction((numerator * f.denominator) + (f.numerator * denominator), (denominator * f.denominator));
        newFraction.reduce();
        return newFraction;
    }

    public void add2(RationalFraction fraction){
        numerator = numerator * fraction.denominator + fraction.numerator * denominator;
        denominator = denominator * fraction.denominator;
    }

    public RationalFraction sub(RationalFraction f){
        RationalFraction newFraction = new RationalFraction(numerator*f.denominator - f.numerator*denominator, denominator * f.denominator);
        newFraction.reduce();
        return newFraction;
    }

    public void sub2(RationalFraction fraction){
        numerator = numerator*fraction.denominator - fraction.numerator * denominator;
        denominator = denominator * fraction.denominator;
    }

    public RationalFraction mult(RationalFraction fraction){
        RationalFraction newFraction = new RationalFraction(numerator*fraction.numerator,denominator*fraction.denominator);
        newFraction.reduce();
        return newFraction;
    }

    public void mult2(RationalFraction fraction){
        numerator = numerator * fraction.numerator;
        denominator = denominator * fraction.denominator;
    }

    public RationalFraction div(RationalFraction fraction){
        RationalFraction newFraction = new RationalFraction(numerator * fraction.denominator, denominator * fraction.numerator);
        newFraction.reduce();
        return newFraction;
    }

    public void div2(RationalFraction fraction){
        numerator = numerator * fraction.denominator;
        denominator = denominator * fraction.numerator;
    }

    public String toString(){
        return numerator + "/" + denominator;
    }

    public double value(){
        return (numerator * 1.0) / denominator;
    }

    public boolean equals(RationalFraction fraction){
        int min = Math.min(numerator, denominator);
        for (int i = numerator; i >= 1; i--) {
            if (numerator % i == 0 && denominator % i == 0) {
                numerator /= i;
                denominator /= i;
            }
        }
        fraction.reduce();
        if (fraction.numerator == numerator && fraction.denominator == denominator) {
            return true;
        } else {
            return false;
        }
    }

    public int numberPart(){
        return numerator / denominator;
    }
}