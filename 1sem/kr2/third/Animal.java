// наследование
package third;

public class Animal {
    String name;
    int age;

    public Animal(String name, int age){
        this.name = name;
        this.age = age;
    }

    public Animal(){
    }

    public String voice(){
        return "sound";
    }

    public void run(){
        System.out.println("top top top");
    }

}
