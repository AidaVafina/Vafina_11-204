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

    public int determineTheRestOfHerringLife() throws HerringException{
        int avarageLifeExpectancy = 20;
        int restOfLife = avarageLifeExpectancy - age;
        if (age < 0){
            throw new HerringException("age cannot be less than 0");
        }
        return restOfLife;
    }

    public int getAge() throws HerringException{
        if (age < 0){
            throw  new HerringException("age cannot be less than 0");
        }
        return age;
    }

    public int calculateTheRatioOfWeightsOfHerrings(Herring herring1) throws HerringException{
        try {
            return weight / herring1.weight;
        } catch (Exception e){
            throw new HerringException("herring weight is not equal to 0");
        }
    }
}