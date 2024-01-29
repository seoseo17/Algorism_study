class Solution {
    public int solution(String my_string) {
        int answer = 0;
        
        // String str = "";
        
        String[] str = my_string.toLowerCase()
        .replaceAll("[abcdefghijklmnopqrstuvwxyz]","").split("");

        for (int i = 0; i < str.length; i++) {
            answer += Integer.parseInt(str[i]);
        }
        
        return answer;
    }
}