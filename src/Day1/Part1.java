package Day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Part1 {

    List<Integer> leftList = new ArrayList<>();
    List<Integer> rightList = new ArrayList<>();
    int totalDistance = 0;

    Part1(){
        parseData();
        Collections.sort(leftList);
        Collections.sort(rightList);
        for (int i = 0; i < leftList.size(); i++){
            totalDistance += getDistance(leftList.get(i), rightList.get(i));
        }
        System.out.println(totalDistance);
    }

    public int getDistance(int left, int right){
        return Math.abs(left - right);
    }

    public void parseData(){
        try (BufferedReader br = new BufferedReader(new FileReader("src/Day1/data"))) {
            String line;
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
        new Part1();
    }
}
