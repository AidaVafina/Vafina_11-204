package third;

public class Main {
    public static void main(String[] args) {
        Cat kitten = new Cat();
        Horse horse = new Horse();
        System.out.println(kitten.voice());
        System.out.println(horse.voice());
        horse.run();
        kitten.run();
    }
}
