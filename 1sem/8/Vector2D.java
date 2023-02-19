public class Vector2D {
    private double i;
    private double j;

    public Vector2D(double i, double j){
        this.i = i;
        this.j = j;
    }

    public Vector2D(){
    }

    public String toString(){
        return "(" + this.i + ";" + this.j + ")";
    }

    public Vector2D add(Vector2D vector2D){
        double i1 = i + vector2D.i;
        double j1 = j + vector2D.j;
        return new Vector2D(i1,j1);
    }

    public void add2(Vector2D vector2D){
        this.i += vector2D.i;
        this.j += vector2D.j;
    }

    public Vector2D sub(Vector2D vector2D){
        double i1 = i - vector2D.i;
        double j1 = j - vector2D.j;
        return new Vector2D(i1,j1);
    }

    public void sub2(Vector2D vector2D){
        this.i -= vector2D.i;
        this.j -= vector2D.j;
    }

    public Vector2D mult(double x){
        double i1 = i * x;
        double j1 = j * x;
        return new Vector2D(i1,j1);
    }

    public void mult2(double y){
        this.i *= i * y;
        this.j *= j * y;
    }

    public double length(){
        return Math.pow(Math.pow(this.i,2) + Math.pow(this.j,2), 0.5);
    }

    public double scalarProduct(Vector2D vector2D){
        return i* vector2D.i + j*vector2D.j;
    }

    public double cos(Vector2D vector2D){
        double chislit = i * j + vector2D.i*vector2D.j;
        double znam = Math.pow(Math.pow(i,2) + Math.pow(vector2D.i,2),0.5) * Math.pow(Math.pow(j,2) + Math.pow(vector2D.j,2),0.5);
        return chislit/znam;
    }


}