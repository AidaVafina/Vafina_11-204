package first;

public class Main {
    public static void main(String[] args) {
        Segment segment1 = new Segment(2,4,5,2);
        Segment segment2 = new Segment(1,6,3,2);

        System.out.println(segment1.countLen());
        System.out.println(segment1.toString());

        if (segment1.equals(segment2)){
            System.out.println("отрезки равны");
        } else {
            System.out.println("отрезки не равны");
        }

        System.out.println(segment1.square());

    }
}
