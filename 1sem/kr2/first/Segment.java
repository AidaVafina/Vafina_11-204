package first;

public class Segment {
    int x1;
    int y1;
    int x2;
    int y2;

    public Segment(int x1, int y1, int x2, int y2){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public double countLen(){
        double len = Math.sqrt((x2 -x1)*(x2-x1) + (y2-y1)*(y2-y1));
        return len;
    }

    public String toString(){
        return "(" + this.x1 + ";" + this.y1 + ")" + "(" + this.x2 + ";" + this.y2 + ")";
    }

    public boolean equals(Segment segment){
        if (countLen() == segment.countLen()){
            return true;
        } else {
            return false;
        }
    }

    public double square(){
        double sq = Math.abs(this.x2 - this.x1) * Math.abs(this.y2-this.y1);
        return sq;
    }


}