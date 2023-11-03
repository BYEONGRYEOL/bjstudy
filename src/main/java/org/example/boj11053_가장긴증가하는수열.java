package org.example;

import java.io.*;
import java.util.StringTokenizer;

public class boj11053_가장긴증가하는수열 {

    static void input() throws Exception {
        int n = scan.nextInt();
        int stair[] = new int[n+1];
        for(int i = 1 ; i < n+1 ; i++)
            stair[i] = scan.nextInt();
        int dp[][] = new int[n+1][2];
        dp[1][0] = 0;
        dp[1][1] = stair[1];
        dp[2][0] = stair[1];
        dp[2][1] = stair[1]+stair[2];
        for(int i =3; i<=n; i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            dp[i][1] = Math.max(dp[i-2][1], dp[i-1][0]);
        }
        System.out.println(Math.max(dp[n][0], dp[n][1]));
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