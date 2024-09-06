import java.util.Arrays;


채점 결과
정확성: 34.8
효율성: 0.0
합계: 34.8 / 100.0

class Solution {
    public int getIndex(int index, int size) {
        if (index == size) {return index % size;}
        return index+1;
    }

    public int solution(int[] food_times, long k) {
        int answer = 0;
        int time = 0;
        int size = food_times.length-1;
        int index = 0;

        while (true) {
            if (k == time) {
                answer = index;
                break;
            }
            if (food_times[index] == 0){
                index = getIndex(index, size);
                continue;
            }
            food_times[index] -= 1;
            time++;
            index = getIndex(index, size);

        }
        if (Arrays.stream(food_times).sum() == 0) return -1;

        for (int i = answer; i < size; i++) {
            if (food_times[i] != 0){
                answer = i+1;
                break;
            }
        }
        return answer;
    }
}
