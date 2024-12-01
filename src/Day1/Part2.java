package Day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Part2 {

    List<Integer> leftList = new ArrayList<>();
    List<Integer> rightList = new ArrayList<>();
    int similarityScore = 0;

    Part2(){
        parseData();
        Collections.sort(leftList);
        Collections.sort(rightList);
        int timesOverlapped;
        for (int i : leftList){
            timesOverlapped = getAmountOfTimesValuesOverlap(i);
            similarityScore += getSimilarityScore(i, timesOverlapped);
        }
        System.out.println(similarityScore);
    }

    public int getAmountOfTimesValuesOverlap(int data){
        int total = 0;
        for (int i : rightList) {
            if (i == data){
                total++;
            }
        }
        return total;
    }

    public int getSimilarityScore(int value, int multiplier){
        return value * multiplier;
    }

    public void parseData(){
        try (BufferedReader br = new BufferedReader(new FileReader("src/Day1/data"))) {
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] lines = line.split("\\s+");
                leftList.add(Integer.parseInt(lines[0]));
                rightList.add(Integer.parseInt(lines[1]));
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Part2();
    }
}
