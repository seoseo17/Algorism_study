package main.java;


class Test {
    public int test(int[][] dots) {
        int answer = 0;
        //{1, 1}, {2, 1}, {2, 2}, {1, 2}
        //00,01    1011    20 21
        //1, 임의의 초기값 지정
        int minX = 256;
        int minY = 256;
        int maxX = -256;
        int maxY = -256 ;

        for (int i = 0; i < dots.length; i++) {
            minX = Math.min(minX, dots[i][0]);
            maxX = Math.max(maxX, dots[i][0]);
            minY = Math.min(minY,dots[i][1]);
            maxY = Math.max(maxY,dots[i][1]);
        }

        answer = Math.abs((maxX-minX) *(maxY-minY));
        System.out.println(answer);
        return answer;
    }
}
