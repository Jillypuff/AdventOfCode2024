package Day4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Part2 {

    int height;
    int length;
    StringBuilder stringData =  new StringBuilder();
    char[][] data;
    int totalFound = 0;

    Part2() {
        parseData();
        data = new char[height][length];
        populateArray();
        checkForX_MAS();
        System.out.println(totalFound);
    }

    public void checkForX_MAS(){
        for (int i = 1; i < height - 1; i++){
            for (int j = 1; j < length - 1; j++){
                boolean firstHalf = false;
                if (spellsMAS(data[i-1][j-1], data[i][j], data[i+1][j+1])
                        || spellsMAS(data[i+1][j+1], data[i][j], data[i-1][j-1])){
                    firstHalf = true;
                }
                if (spellsMAS(data[i+1][j-1], data[i][j], data[i-1][j+1])
                        || spellsMAS(data[i-1][j+1], data[i][j], data[i+1][j-1])){
                    if (firstHalf){
                        totalFound++;
                    }
                }
            }
        }
    }

    public boolean spellsMAS(char M, char A, char S){
        return M == 'M' && A == 'A' && S == 'S';
    }

    public void populateArray() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < length; j++) {
                data[i][j] = stringData.charAt(i * height + j);
            }
        }
    }

    public void parseData(){
        try (BufferedReader br = new BufferedReader(new FileReader("src/Day4/data"))) {
            String line;
            line = br.readLine();
            length = line.length();
            stringData.append(line);
            int counter = 1;
            while ((line = br.readLine()) != null) {
                stringData.append(line);
                counter++;
            }
            height = counter;
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Part2();
    }
}
