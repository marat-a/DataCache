import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        String[] tokens = br.readLine().split(" ");
        int n = Integer.parseInt(tokens[0]);
        int m = Integer.parseInt(tokens[1]);
        int[] inputValues = new int[m];

        Map<Integer, Integer> priorityMap = new HashMap<>();
        for (int i = 0; i < m; i++) {
            inputValues[i] = Integer.parseInt(br.readLine());
            if (priorityMap.containsKey(inputValues[i])) {
                priorityMap.put(inputValues[i], priorityMap.get(inputValues[i]) + 1);
            } else priorityMap.put(inputValues[i], 1);
        }
        br.close();
        int[] cache = new int[n];
        int cacheValuesQuantity = 0;
        for (int i = 0; i < m; i++) {
            while (cacheValuesQuantity<=5) {
                for (int j = 0; j < cache.length; j++) {
                    if (cache[j] == inputValues[i]){
                        priorityMap.put(inputValues[i], priorityMap.get(inputValues[i]) - 1);
                        break;
                    }
                }
                cache[cacheValuesQuantity] = inputValues[i];
                cacheValuesQuantity++;
            }
        }

        PrintWriter pw = new PrintWriter(new FileWriter("output.txt"));
        pw.close();
    }


}