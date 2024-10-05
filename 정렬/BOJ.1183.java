public class Main {

    static int N;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" ");
            int A = Integer.parseInt(str[0]);
            int B = Integer.parseInt(str[1]);
            arr[i] = A-B;
        }
        Arrays.sort(arr);

        int medianLow = arr[(N-1)/2]; // 홀수 일 경우 가운데
        int medianHigh = arr[N/2];//짝수이면
        System.out.println(medianHigh-medianLow+1);
    }
}
