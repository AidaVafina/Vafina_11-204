
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class ApiRequestExecutor {
    public List<CatFact> getCatFactsFromApi(String url) throws IOException {
        URLConnection urlConnection =
                new URL(url).openConnection();
        urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0");
        InputStream inputStream = urlConnection.getInputStream();
        byte[] bytes = new byte[inputStream.available()];
        inputStream.read(bytes);
        String json = new String(bytes);
        List<FactsJSON> factsJSONS = new ObjectMapper().readValue(json, new TypeReference<List<FactsJSON>>() {
        });
        List<CatFact> catFacts = new ArrayList<>();
        factsJSONS.forEach(
                factsJSON -> {
                    catFacts.add(new CatFact(factsJSON.getText()));
                }
        );
        return catFacts;
    }
}
