package Day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Part1 {

    List<List<Integer>> levels = new ArrayList<>();
    int safeReports = 0;

    Part1() {
        parseData();
        for (List<Integer> level : levels) {
            if(checkIfSafe(level)){
                safeReports++;
            }
        }
        System.out.println(safeReports);
    }

    public boolean checkIfSafe(List<Integer> currentLevel) {
        boolean increase = true;
        if (currentLevel.get(0) > currentLevel.get(1)){
            increase = false;
        }
        for (int i = 0; i < currentLevel.size() -1; i++) {
            int current = currentLevel.get(i);
            int next = currentLevel.get(i + 1);
            if (!differByOneToThree(current, next)) {
                return false;
            }
            if (increase) {
                if (!isIncreasing(current, next)) {
                    return false;
                }
            } else {
                if (isIncreasing(current, next)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isIncreasing(int current, int next) {
        return current < next;
    }

    public boolean differByOneToThree(int current, int next) {
        return Math.abs(current - next) >= 1 && Math.abs(current - next) <= 3;
    }

    public void parseData(){
        try (BufferedReader br = new BufferedReader(new FileReader("src/Day2/data"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] lines = line.split("\\s+");
                List<Integer> level = new ArrayList<>();
                for (String number : lines){
                    level.add(Integer.parseInt(number));
                }
                levels.add(level);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Part1();
    }
}
