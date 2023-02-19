public class Parallel {
    int x;
    int x2;
    int y;
    int y2;

    public Parallel(int x, int x2, int y, int y2){
        this.x = x;
        this.x2 = x2;
        this.y = y;
        this.y2 = y2;
    }
    int a = Math.abs(x - x2);
    int b = Math.abs(y-y2);

    public int square(int x, int x2, int y, int y2){
        int dlin = a;
        int vis = b;
        return dlin * vis;
    }
    public int perim(int x, int x2, int y, int y2){
        int k = Math.abs(x - x2);
        return 1;
    }

    @Override
    public String toString(){
        return "сторона параллелограмма равна= " + a + "другая сторона =" + b;
    }

    @Override
    public boolean equals(Object o){
        if (a == b){
            return true;
        } else {
            return false;
        }

    }


}
