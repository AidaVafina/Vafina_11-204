import java.io.IOException;

public class CatFactPerformer {
    private ApiRequestExecutor apiRequestExecutor;
    private CatFactGetter catFactGetter;

    public CatFactPerformer(ApiRequestExecutor apiRequestExecutor, CatFactGetter catFactGetter) {
        this.apiRequestExecutor = apiRequestExecutor;
        this.catFactGetter = catFactGetter;
    }

    public String catToPrettyFormat() throws IOException {
        return catFactGetter.getCatsFacts(apiRequestExecutor.getCatFactsFromApi("https://cat-fact.herokuapp.com/facts"));
    }
}
