
import java.util.List;

public class CatFactGetter {
    public String getCatsFacts(List<CatFact> catFacts) {
        String factString = "";
        for (int i = 0; i < catFacts.size(); i++) {
            factString = factString + "Fact " + (i + 1) + " " + catFacts.get(i).getText() + "\n";
        }
        return factString;
    }
}
