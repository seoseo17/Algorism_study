import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    /**1467 방번호*/
    static int count;
    static int[] numbers = new int[10];

    public static void main(String[] args) throws Exception{
        // 한 세트에는 0번부터 9번까지 숫자가 하나씩 들어있다

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int roomNumber = Integer.parseInt(br.readLine());
        int max = 0;
        while (roomNumber > 0){
            int number = roomNumber%10;
            roomNumber = roomNumber/10;

            if (number == 6 || number == 9){
                if (numbers[6] <= numbers[9]){
                    numbers[6] += 1;
                }else {
                    numbers[9] +=1;
                }
                continue;
            }
            numbers[number] +=1;
        }
        for (int i : numbers){
            max = Math.max(i,max);
        }
        System.out.println(max);
    }
}


