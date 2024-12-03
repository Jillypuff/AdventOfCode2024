package Day3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 {

    String data;
    List<String> correctData = new ArrayList<>();
    int totalValue;

    Part1() {
        parseData();
        parseCorrectData();
        for (String s : correctData) {
            totalValue += multiply(s.substring(4, s.length() - 1));
        }
        System.out.println(totalValue);
    }

    public int multiply(String data) {
        String[] values = data.split(",");
        return Integer.parseInt(values[0]) * Integer.parseInt(values[1]);
    }

    public void parseCorrectData() {
        String regex = "mul\\(\\d+,\\d+\\)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(data);
        while (matcher.find()) {
            correctData.add(matcher.group());
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
        new Part1();
    }
}
