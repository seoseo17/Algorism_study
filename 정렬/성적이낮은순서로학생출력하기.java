import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Student implements Comparable<Student>{
    String name;
    int score;
    public Student(String name, int score){
        this.name = name;
        this.score = score;
    }

    public int getScore(){
        return this.score;
    }

    public String getName(){
        return this.name;
    }

    @Override
    public int compareTo(Student o) {
        return this.score-o.score;
    }
}

public class Main {
    /**
     * 정렬
     * 성적이낮은순서로학생출력하기
     */

    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        List<Student> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] str = bf.readLine().split(" ");
            list.add(new Student(str[0],Integer.parseInt(str[1])));
        }

        Collections.sort(list);

        for(Student student : list){
            System.out.printf("%s ",student.getName());
        }

    }

}



