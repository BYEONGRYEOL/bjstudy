package org.example;

import java.io.*;
import java.util.StringTokenizer;

public class 이항계수3_11401 {

    static void input() throws Exception {
        int N = scan.nextInt();
        int K = scan.nextInt();
        int[][] C = new int[N+1][K+1];
        // nCk 를 구하기 위해선
        // n-1Ck + n-1Ck-1 을 알아야한다.
        for(int i = 1; i < N+1; i++){
            C[i][0] = 1;
            C[i][i] = 1;
        }
        for(int i = 2 ; i < N+1; i++){
            for(int j = 1; j < K+1 ; j++){
                C[i][j] = (C[i-1][j-1] + C[i-1][j]) % 1000000007;
            }
        }
        System.out.println(C[N][K]);
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