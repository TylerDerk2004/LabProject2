package edu.canisius.csc213.project2.quotes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import edu.canisius.csc213.project2.util.*;

public class PolygonStockQuoteProvider implements StockQuoteProvider{

    @Override
    public StockQuote getStockQuote(String stockQuoteEndpoint) throws IOException {
        String json = sendGetRequest(stockQuoteEndpoint);
        PolygonJsonReplyTranslator jft = new PolygonJsonReplyTranslator();
        return jft.translateJsonToFinancialInstrument(json);

    }

    public static String sendGetRequest(String endpointUrl) throws IOException{
        
            // Create a URL object
            URL url = new URL(endpointUrl);
            
            
            // Open an HttpURLConnection to the URL
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            
            // Set request method (GET by default)
            conn.setRequestMethod("GET");
            
            // Create a BufferedReader to read the content
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            
            // String to store the content
            StringBuilder content = new StringBuilder();
            String line;
            
            // Read each line of the content and append it to the StringBuilder
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            
            // Close the BufferedReader
            reader.close();

            return content.toString();
        
    }

    public String getEndpointUrl(String symbolName, String date, String apiKey) {
        Pattern pattern = Pattern.compile("/d/d/d/d-/d/d-/d/d");
        Matcher matcher = pattern.matcher(date);
        if (!date.substring(4,5).equals("-")){
            throw new IllegalArgumentException("");
        }
        return "https://api.polygon.io/v2/aggs/ticker/" + symbolName + "/range/1/day/" + date + "/" + date + "?apiKey=" + apiKey;
    }

}
