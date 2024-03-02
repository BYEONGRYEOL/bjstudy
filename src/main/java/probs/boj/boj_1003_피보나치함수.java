package probs.boj;

import java.io.*;
import java.util.StringTokenizer;

public class boj_1003_피보나치함수 {

    static void input() throws Exception {
        int n = scan.nextInt();
        int k = scan.nextInt();
        int[] w = new int[n];
        int[] v = new int[n];
        for(int i = 0 ; i < n ; i ++){
            w[i] = scan.nextInt();
            v[i] = scan.nextInt();
        }
        // 무게 제한을 늘려가며 과거의 답에서 현재의 답을 도출
        // 각각의 인덱스는 검사중인 물건을 뜻함
        // 무게제한 1
        // 0 0 0 0
        // 무게제한 2
        // 0 0 0 0
        // 무게제한 3
        // 0 0 6 6
        // 무게제한 4
        // 0 8 8 8
        // 무게제한 5
        // 0 8 8 12
        // 무게제한 6
        // 13 13 13 13
        // 무게제한 7
        // 13 13 14 14 무게제한이 3일 적에도 6을 담았었으니
        int[][] dp = new int[k+1][n];
        for(int i = 1; i <=k; i++){
            for(int j = 0; j < n ; j ++){
                if(w[j] > k) //담을 수 없다면 이전 최댓값 불러오기
                    dp[i][j] = dp[i-1][j];
                else{
                    // 담을 수 있다면
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - w[j]] +v[j]);
                }
            }
        }
        System.out.println(dp[n][k]);

    }

    static void print(){
        System.out.print(sb.toString());
    }
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt() {
            return Integer.parseInt(next());
        }
        long nextLong() {
            return Long.parseLong(next());
        }
        double nextDouble() {
            return Double.parseDouble(next());
        }
        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static void main(String[] args) throws Exception {
        input();
    }
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();



}