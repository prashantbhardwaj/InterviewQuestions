package person.prashant.questions.interview.lmr;

import lombok.Builder;
import lombok.Data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LmrInterviewQuestion {

    public static void main(String[] args){

        String csvFile = "tradesUSD.csv";
        List<TickerData> tickerDataList = new ArrayList<>();

        // Get the classloader to load the file from the classpath
        ClassLoader classLoader = LmrInterviewQuestion.class.getClassLoader();
        try (InputStream is = classLoader.getResourceAsStream(csvFile);
             BufferedReader br = new BufferedReader(new InputStreamReader(is))) {

            String line;
            while ((line = br.readLine()) != null) {
                // Use comma as separator
                String[] values = line.split(",");
                tickerDataList.add(
                        TickerData.builder()
                                .name(values[0])
                                .tradeValue(Double.parseDouble(values[1]))
                                .tradePrice(Double.parseDouble(values[2]))
                                .build()
                );
                //System.out.println(String.join(", ", values));
            }

            //getTheTop10NetValueTickers(tickerDataList);
            getTheTop10WAPTickers(tickerDataList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void getTheTop10NetValueTickers(List<TickerData> tickerDataList){

        tickerDataList.stream()
                .collect(Collectors.groupingBy(TickerData::getName))
                .entrySet()
                .stream()
                .map(es -> calculateTheNet(es))
                .sorted((pair1, pair2) -> pair2.getRight().compareTo(pair1.getRight()))
                .limit(10)
                //.collect(Collectors.toList());
        .forEach(val -> System.out.println("Ticker " + val.getLeft() + " , Net Value " + val.getRight()));
    }

    private static void getTheTop10WAPTickers(List<TickerData> tickerDataList){

        tickerDataList.stream()
                .collect(Collectors.groupingBy(TickerData::getName))
                .entrySet()
                .stream()
                .map(es -> calculateTheWeightedAveragePrice(es))
                .sorted((pair1, pair2) -> pair2.getRight().compareTo(pair1.getRight()))
                .limit(10)
                //.collect(Collectors.toList());
                .forEach(val -> System.out.println("Ticker " + val.getLeft() + " , WAP " + val.getRight()));
    }

    private static Pair<String, Double> calculateTheNet(Map.Entry<String, List<TickerData>> tickerData){
        Double netValueOdTheTicker = tickerData.getValue().stream()
                .mapToDouble(TickerData::getTradeValue)
                .sum();

        return Pair.<String, Double>builder().left(tickerData.getKey()).right(netValueOdTheTicker).build();
    }

    private static Pair<String, Double> calculateTheWeightedAveragePrice(Map.Entry<String, List<TickerData>> tickerData){
        Double netValueOdTheTicker = tickerData.getValue().stream()
                .mapToDouble(TickerData::getTradeValue)
                .sum();

        Double netQuantity = new Double(0);
        Double sumOfWeightedTrade = new Double(0);

        for (TickerData td : tickerData.getValue()){
            sumOfWeightedTrade = sumOfWeightedTrade + td.tradePrice * Math.abs(td.tradeValue/td.tradePrice);
            netQuantity = netQuantity + Math.abs(td.tradeValue/td.tradePrice);
        }

        return Pair.<String, Double>builder()
                .left(tickerData.getKey())
                .right(tickerData.getValue().size() == 1 ? tickerData.getValue().get(0).getTradePrice() : sumOfWeightedTrade/netQuantity)
                .build();
    }

    @Builder
    @Data
    private static class TickerData{
        private String name;
        private double tradeValue;
        private double tradePrice;
    }

    @Builder
    @Data
    private static class Pair<L, R>{
        private L left;
        private R right;
    }
}
