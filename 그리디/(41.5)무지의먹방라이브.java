import java.util.Arrays;

정확성: 41.5
효율성: 0.0
합계: 41.5 / 100.0
class Solution {
    public int solution(int[] food_times, long k) {
        int time = 0;
        int size = food_times.length;
        int index = 0;

        while (time < k) {
            if (food_times[index] == 0) {
                index = (index + 1) % size;
                continue;
            }

            food_times[index]--;
            time++;
            index = (index + 1) %size; // 다음 음식으로 넘어감

        }

        //k 시간 후 확인
        for (int i = 0; i <size ; i++) {
            if (food_times[index] != 0){
                return index+1;
            }
            index = (index+1)%size;
        }
        return -1;
    }
}
