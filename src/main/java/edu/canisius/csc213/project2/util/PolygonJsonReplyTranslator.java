package edu.canisius.csc213.project2.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.canisius.csc213.project2.quotes.*;


import java.io.IOException;
import java.nio.file.Paths;
import java.util.Map;

public class PolygonJsonReplyTranslator {

    public StockQuote translateJsonToFinancialInstrument(String json) throws IOException {
        
        //Creating mapper
        ObjectMapper mapper = new ObjectMapper();
        
        JsonNode jsonNode = mapper.readTree(json);
        JsonNode results = jsonNode.get("results").get(0);

        //Pulling each value from JSON, and assigning it to respective variable
        String symbol = jsonNode.get("ticker").asText();
        double closePrice = results.get("c").asDouble();
        double highestPrice = results.get("h").asDouble();
        double lowestPrice = results.get("l").asDouble();
        int numberOfTransactions = results.get("n").asInt();
        double openPrice = results.get("o").asDouble();
        long timeStamp = results.get("t").asLong();
        double tradingVolume = results.get("v").asDouble();
        
        return new StockQuote(symbol, closePrice, highestPrice, 
        lowestPrice, numberOfTransactions, openPrice, 
        timeStamp, tradingVolume);
        
    }
}
