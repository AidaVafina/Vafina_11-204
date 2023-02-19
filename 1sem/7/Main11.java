public class Main11 {
    public static void main(String[] args) {
        Herring herring1 = new Herring("голубой", "черный", 10, true,"Тихоокеанская",400);
        Herring herring2 = new Herring("зеленый", "серый", 15, false, "Атлантическая",670);
        Herring babyherring = Herring.createNewHerring(herring1,herring2);
        Herring.printBabyHerring(babyherring);

        babyherring.determineTheRestOfHerringLife();
        babyherring.makeTheHerringSound();
        babyherring.determineTheSize();
        babyherring.readyToBeParent();










    }
}