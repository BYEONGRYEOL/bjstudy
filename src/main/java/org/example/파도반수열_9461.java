package org.example;

import java.io.*;
import java.util.StringTokenizer;

public class 파도반수열_9461 {
    static void input() throws Exception {

        // 초기값
        // 인덱스     0 1 2 3 4
        // 값        1 1 1 2 2
        // 인덱스 5의 값 2는 0번째 index + 4번째 index를 합하여 나온 값이다.
        long dp[] = new long[101];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        dp[5] = 2;

        for(int i =  6;  i < 101; i++){
            dp[i] = dp[i-5] + dp[i-1];
        }

        int t = scan.nextInt();
        for(int i = 0 ; i < t ; i ++)
            sb.append(dp[scan.nextInt()]).append('\n');
        print();
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