package Day5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Part2 {

    HashMap<Integer, List<Integer>> map = new HashMap<>();
    List<List<Integer>> update = new ArrayList<>();
    int incorrectUpdatesFixed = 0;

    Part2() {
        parseData();

        for (List<Integer> list : update) {
            if (!numbersFollowOrder(list)) {
                incorrectUpdatesFixed += repairIncorrectOrders(list);
            }
        }
        System.out.println(incorrectUpdatesFixed);
    }

    public int repairIncorrectOrders (List<Integer> numbers) {
        List<Integer> tempNumbers = new ArrayList<>(numbers);
        for (int i = 0; i < tempNumbers.size(); i++) {
            int key = tempNumbers.get(i);
            List<Integer> values = map.get(key);
            if (values != null){
                for (int value : values){
                    if (tempNumbers.contains(value) && tempNumbers.indexOf(value) < i) {
                        numbers.remove((Integer) value);
                        numbers.add(value);
                        return repairIncorrectOrders(numbers);
                    }
                }
            }
        }
        int middle = tempNumbers.size() / 2;
        return tempNumbers.get(middle);
    }

    public boolean numbersFollowOrder(List<Integer> numbers){
        for (int i = 0; i < numbers.size(); i++) {
            int key = numbers.get(i);
            List<Integer> values = map.get(key);
            if (values != null){
                for (int value : values){
                    if (numbers.contains(value) && numbers.indexOf(value) < i) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public void parseData(){
        try (BufferedReader br = new BufferedReader(new FileReader("src/Day5/data"))) {
            String line;
            while ((line = br.readLine()).contains("|")) {
                String[] stringRules = line.split("\\|");
                int key = Integer.parseInt(stringRules[0]);
                int value = Integer.parseInt(stringRules[1]);
                if (!map.containsKey(key)) {
                    map.put(key, new ArrayList<>());
                }
                map.get(key).add(value);
            }
            while ((line = br.readLine()) != null) {
                String[] lines = line.split(",");
                List<Integer> list = new ArrayList<>();
                for (String s : lines) {
                    list.add(Integer.parseInt(s));
                }
                update.add(list);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Part2();
    }
}
