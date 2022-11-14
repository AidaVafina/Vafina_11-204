public class Main {
    public static void main(String[] args) {
        Herring herring1 = new Herring("голубой", "черный", 0, true, "Тихоокеанская", 400);
        Herring herring2 = new Herring("зеленый", "серый", 15, false, "Атлантическая", 678);

        try {
            System.out.println(herring1.determineTheRestOfHerringLife());
        } catch (HerringException e){
            e.printStackTrace();
        }

        try {
            System.out.println(herring1.calculateTheRatioOfWeightsOfHerrings(herring2));
        } catch (HerringException e){
            e.printStackTrace();
        }
    }
}
