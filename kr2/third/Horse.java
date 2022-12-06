package third;

public class Horse extends Animal{
    String maneColor;

    @Override
    public String voice(){
        return "igogo";
    }

    @Override
    public void run(){
        System.out.println("tigidik-tigidik");
    }
}
