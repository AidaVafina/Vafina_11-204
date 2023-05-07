import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.ArrayList;

import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PerformerTest {
    private ApiRequestExecutor apiRequestExecutor;
    private CatFactGetter catFactGetter;

    private CatFactPerformer catFactPerformer;

    @BeforeAll
    public void setup() throws IOException {
        apiRequestExecutor = Mockito.mock(ApiRequestExecutor.class);
        List<CatFact> catFacts = new ArrayList<>();
        catFacts.add(new CatFact("Some fact from cat"));
        Mockito.when(apiRequestExecutor.getCatFactsFromApi("https://cat-fact.herokuapp.com/facts")).thenReturn(catFacts);
        catFactGetter = new CatFactGetter();
        catFactPerformer = new CatFactPerformer(apiRequestExecutor, catFactGetter);
    }

    @Test
    public void checkFacts() throws IOException {
        String actual = "Fact 1 Some fact from cat" + "\n";
        Assertions.assertEquals(catFactPerformer.catToPrettyFormat(),actual);
    }
}
