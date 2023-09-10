import com.fasterxml.jackson.databind.ObjectMapper;
import jdk.internal.org.objectweb.asm.TypeReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.*;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = new FileInputStream("beers.txt");
        byte[] bytes = new byte[inputStream.available()];
        inputStream.read(bytes);
        String json = new String(bytes);
        List<Beer> beer = new ObjectMapper().readValue(json, List.class);
    }


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Beer {
        Integer id;
        String name;
        String tagline;
        Integer abv;

        public Beer(int id, String name, String tagline, Integer adv) {
            this.id = id;
            this.name = name;
            this.tagline = tagline;
            this.abv = adv;
        }
    }
}
