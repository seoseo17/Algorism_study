import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    /**
     * 기타 그래프
     * 팀결성
     */

    public static int n, m;
    public static int[] parent;

    public static int findParent(int x){
        if (x == parent[x]) return x;
        return parent[x] = findParent(parent[x]);
    }

    public static void unionParent(int a,int b){
        a = findParent(a);
        b = findParent(b);

        if (a>b) parent[a] = b;
        else parent[b] = a;
    }

    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        parent = new int[n+1];
        //부모 자기자신으로 초기화
        for (int i = 1; i <=n ; i++) {
            parent[i] = i;
        }

        for (int i = 0; i <m ; i++) {
            int x = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();

            if (x == 0){
                unionParent(a,b);
            }else {
                if (findParent(a) == findParent(b)){
                    System.out.println("YES");
                }else {
                    System.out.println("NO");
                }
            }
        }
    }
    }
