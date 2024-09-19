
import java.io.*;
import java.util.*;


public class Main {

    /**
     * 이진탐색 공유기 설치
     */
    static int N, C;
    static int[] house;


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        house = new int[N];
        for (int i = 0; i < N; i++) {
            house[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(house);

        solve();
    }

    static void solve() {
        int str = 0;
        int end = house[N - 1]-house[0];
        int result = 0;
        while (str <= end) {
            int count = 1;
            int index = 0;
            int mid = (str + end) / 2;

            for (int i = 1; i < N; i++) {
                if (house[i] - house[index] >= mid) {
                    count++;
                    index = i;
                }
            }
            if (count >= C) {
                result = mid;
                str = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        System.out.println(result);
    }
}
