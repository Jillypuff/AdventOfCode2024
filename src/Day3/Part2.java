package Day3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part2 {

    String data;
    int totalValue;

    Part2() {
        parseData();
        parseCorrectData();
        System.out.println(totalValue);
    }

    public int multiply(String data) {
        String[] values = data.split(",");
        return Integer.parseInt(values[0]) * Integer.parseInt(values[1]);
    }

    public void parseCorrectData() {
        String regex = "mul\\(\\d+,\\d+\\)|don't\\(\\)|do\\(\\)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(data);
        boolean enabled = true;
        while (matcher.find()) {
            switch(matcher.group()) {
                case "don't()" -> enabled = false;
                case "do()" -> enabled = true;
                default -> {
                    if (enabled){
                        totalValue += multiply(matcher.group().substring(4, matcher.group().length() - 1));
                    }
                }
            }
        }
    }

    public void parseData(){
        try (BufferedReader br = new BufferedReader(new FileReader("src/Day3/data"))) {
            String line;
            while ((line = br.readLine()) != null) {
                data += line;
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Part2();
    }
}
