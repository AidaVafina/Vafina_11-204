import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {

    public static void main(String[] args) {
        try {
            URL url = new URL("http://185.237.219.19:8080/homework1");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            String jsonInputString = "{\"name\": \"Aida\"}";

            try (OutputStream outputStream = conn.getOutputStream()) {
                byte[] input = jsonInputString.getBytes();
                outputStream.write(input, 0, input.length);
            }

            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                StringBuilder response = new StringBuilder();
                String responseLine;
                while ((responseLine = bufferedReader.readLine()) != null) {
                    response.append(responseLine.trim());
                }
                System.out.println("Response from server: " + response.toString());
            }
            conn.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}