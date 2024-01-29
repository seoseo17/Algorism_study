import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //1. 입력 받기
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int answer = 0;

        for (int i = 1; i <=n ; i++) {

            if(n % i == 0){
                answer++;
            }
        }
        System.out.println("answer = " + answer);
    }
}
