import java.util.Random;

public class Herring {
    public String eyeColor;
    public String color;
    private String name;
    public String breed;
    public int age;
    public boolean seaFish;
    public int weight;

    public Herring(String eyeColor, String color, int age, boolean seaFish, String breed, int weight){
        this.eyeColor = eyeColor;
        this.color = color;
        this.age = age;
        this.seaFish = seaFish;
        this.breed = breed;
        this.weight = weight;
    }

    public Herring(String name,int age, int weight){
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Herring createNewHerring(Herring herring1, Herring herring2){
        Random random = new Random();
        Herring babyHerring = new Herring(herring1.eyeColor, herring2.color, 0, herring1.seaFish ,herring2.breed, random.nextInt(1000));
        return babyHerring;
    }

    public static void printBabyHerring(Herring babyHerring){
        System.out.println("цвет глаз селедки: " + babyHerring.eyeColor);
        System.out.println("селедке " + babyHerring.age + " лет");
        if (babyHerring.seaFish == true){
            System.out.println("селедка живет в море");
        } else {
            System.out.println("селедка живет в реке");
        }
        System.out.println("порода селедки: " +babyHerring.breed);
        System.out.println("вес селедки: " + babyHerring.weight);
    }

    public void makeTheHerringSound(){
        System.out.println("bulbulbul");
    }

    public void determineTheRestOfHerringLife(){
        int avarageLifeExpectancy = 20;
        int restOfLife = avarageLifeExpectancy - age;
        System.out.println("Cеледке осталось жить примерно " + restOfLife + " лет");
    }

    public void determineTheSize(){
        if (weight < 300) {
            System.out.println("вес селедки ниже среднего");
        } else if (weight >= 300 && weight <= 600){
            System.out.println("у селедки нормальный вес");
        } else {
            System.out.println("вес селедки выше среднего");
        }
    }

    public void readyToBeParent(){
        if (age < 1){
            System.out.println("селедка не готова стать мамой");
        } else if (age >= 1 && age < 15){
            System.out.println("селедка готова делать новых селедок");
        }
    }
}
