import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class GenerativeAIDemo {

    // Replace this with your OpenAI API key
    private static final String API_KEY = "YOUR_API_KEY_HERE";

    public static void main(String[] args) {
        try {
            // The text prompt you want AI to expand creatively
            String prompt = "Write a short motivational quote about creativity and AI.";

            // Create JSON body
            JSONObject body = new JSONObject();
            body.put("model", "gpt-3.5-turbo"); // or "gpt-4" if available
            body.put("messages", new org.json.JSONArray()
                    .put(new JSONObject().put("role", "user").put("content", prompt))
            );

            // Create URL connection
            URL url = new URL("https://api.openai.com/v1/chat/completions");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            // Set headers
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Authorization", "Bearer " + API_KEY);
            conn.setDoOutput(true);

            // Send request
            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = body.toString().getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            // Get response
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
            StringBuilder response = new StringBuilder();
            String responseLine;

            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }

            // Parse and print output
            JSONObject jsonResponse = new JSONObject(response.toString());
            String generatedText = jsonResponse
                    .getJSONArray("choices")
                    .getJSONObject(0)
                    .getJSONObject("message")
                    .getString("content");

            System.out.println("\n🤖 Generated Creative Text:\n" + generatedText);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
