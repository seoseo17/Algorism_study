import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //1. 입력 받기
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        String[] strs = Integer.toString(n).split("");
        int answer = 0;

        for(int i=0;i<strs.length;i++){
            answer += Integer.parseInt(strs[i]);
        }
        System.out.println("answer = " + answer);
    }
}
