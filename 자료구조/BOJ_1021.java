
import java.io.*;
import java.util.*;


public class Main {

    static int N,M;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] arr = new int[M]; //뽑아내려고 하는 수의 위치
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i <M ; i++) {
            arr[i]= Integer.parseInt(st.nextToken());
        }
        LinkedList<Integer> deque = new LinkedList<>();
        for (int i = 1; i <N+1 ; i++) {
            deque.offer(i);
        }
        int count = 0;

        for (int i = 0; i < M; i++) {
            int target=arr[i];

            while (true){
                int peekFirst = deque.peekFirst();
                if (target == peekFirst){
                    deque.removeFirst();
                    break;
                }
                if (deque.indexOf(target) <= deque.size()/2 ){ //1 < 2 -> 왼쪽
                    deque.addLast(deque.removeFirst());
                    count++;
                }else {
                    deque.addFirst(deque.removeLast());
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
