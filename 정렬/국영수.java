
import java.io.*;
import java.util.*;

class Node implements Comparable<Node>{
    String name;
    int korean;
    int english;
    int math;

    public Node(String name, int korean, int english,int math){
        this.name = name;
        this.korean = korean;
        this.english = english;
        this.math = math;
    }
    @Override
    public int compareTo(Node o){
//        if (this.korean == o.korean){
//            if (this.english == o.english){
//                if (this.math == o.math){
//                    return this.name.compareTo(o.name);
//                }
//                return o.math - this.math;
//            }
//            return this.english - o.english;
//        }
//        return o.korean - this.korean;
        
        int korMinus = this.korean - o.korean; // 내림차순
        if (korMinus <0){
            return 1;
        }else if (korMinus == 0){
            int engMinus  = this.english - o.english; //오름차순
            if (engMinus>0) return 1;
            else if (engMinus == 0){
                int mathMinus = this.math - o.math; //내림차순
                if (mathMinus<0) return 1;
                else if (mathMinus == 0){
                    return this.name.compareTo(o.name);
                }
            }
        }
        return -1;
    }
}

public class Main {
    /**
     * 정렬
     * 국영수
     */
    static int N;
    static List<Node> list = new ArrayList<>();


    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        //이름과 국어, 영어, 수학
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int kor = Integer.parseInt(st.nextToken());
            int eng = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());
            list.add(new Node(name,kor,eng,math));
        }

        Collections.sort(list);

        for (Node node : list){
            System.out.println(node.name);
        }

    }
    }
