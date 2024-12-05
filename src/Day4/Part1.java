package Day4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Part1 {

    int height;
    int length;
    StringBuilder stringData =  new StringBuilder();
    char[][] data;
    int totalFound = 0;

    Part1() {
        parseData();
        data = new char[height][length];
        populateArray();
        checkForXMAS();
        System.out.println(totalFound);
    }

    public void checkForXMAS(){
        for (int i = 0; i < height; i++){
            for (int j = 0; j < length; j++){
                // Check right
                if (j <= length - 4 &&
                        spellsXMAS(data[i][j], data[i][j+1], data[i][j+2], data[i][j+3]))           totalFound++;
                // Check downright
                if (j <= length - 4 && i <= height -4 &&
                        spellsXMAS(data[i][j], data[i+1][j+1], data[i+2][j+2], data[i+3][j+3]))     totalFound++;
                // Check down
                if (i <= height - 4 &&
                        spellsXMAS(data[i][j], data[i+1][j], data[i+2][j], data[i+3][j]))           totalFound++;
                // Check downleft
                if (i <= length - 4 && j >= 3 &&
                        spellsXMAS(data[i][j], data[i+1][j-1], data[i+2][j-2], data[i+3][j-3]))     totalFound++;
                // Check left
                if (j >= 3 &&
                        spellsXMAS(data[i][j], data[i][j-1], data[i][j-2], data[i][j-3]))           totalFound++;
                // Check upleft
                if (i >= 3 && j >= 3 &&
                        spellsXMAS(data[i][j], data[i-1][j-1], data[i-2][j-2], data[i-3][j-3]))     totalFound++;
                // Check up
                if (i >= 3 &&
                        spellsXMAS(data[i][j], data[i-1][j], data[i-2][j], data[i-3][j]))           totalFound++;
                // Check upright
                if (i >= 3 && j <= length - 4 &&
                        spellsXMAS(data[i][j], data[i-1][j+1], data[i-2][j+2], data[i-3][j+3]))     totalFound++;
            }
        }
    }

    public boolean spellsXMAS(char X, char M, char A, char S){
        return X == 'X' && M == 'M' && A == 'A' && S == 'S';
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
        new Part1();
    }
}
