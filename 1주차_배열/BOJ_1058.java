import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        /**1.입력받기*/
        BufferedReader bfr  = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bfr.readLine());

        char[][] friends = new char[n][n];

        for (int i = 0; i < n; i++) {
            friends[i] = bfr.readLine().toCharArray();
        }
        int maxCount = 0;

        /**2. 친구 및 친구의 친구일 경우 count*/

        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            visited[i] = true;

            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            int count = 0;
            int depth = 0;
            while (depth <2){

                int size = queue.size();

                for (int k = 0; k < size; k++) {
                    int current = queue.poll();
                    for (int j = 0; j < n; j++) {
                        if (friends[current][j] == 'Y' && !visited[j]){
                            visited[j] = true;
                            queue.add(j);
                            count++;
                        }
                    }
                }
                depth++;
            }
            if (count>= maxCount){
                maxCount = count;
            }

        }
        System.out.println(maxCount);
    }
}
