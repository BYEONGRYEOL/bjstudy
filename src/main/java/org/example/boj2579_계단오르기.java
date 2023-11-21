package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2579_계단오르기 {

    static void input() throws Exception {
        int n = scan.nextInt();
        int stairs[] = new int[n];
        for (int i = 0; i < n; i++) {
            stairs[i] = scan.nextInt();
        }
        int dp[] = new int[n];

        // bottom up, 모든 i가 정답일 때를 가정하여 점화식 작성

        dp[0] = stairs[0]; // 첫계단이 목적지인 경우 당연히 밟는게 최대
        if(n==1){
            System.out.println(dp[n-1]);
            return;
        }
        dp[1] = stairs[1] + stairs[0]; // 2번째 계단이 목적지인 경우 당연히 둘다 밟는게 최대 (dp배열과는 아예 관여하지 않으므로 조건에 위배 x)
        if(n==2){
            System.out.println(dp[n-1]);
            return;
        }
        dp[2] = stairs[2] + Math.max(stairs[0], stairs[1]); // 3번째 계단이 목적지인경우, 1,2는 둘다 밟을 수 없고 둘중 하나는 밟아야 한다.
        if(n==3){
            System.out.println(dp[n-1]);
            return;
        }


        for(int i = 3 ;i< n; i++){
            // OXOO 인 경우와 OXO 인 경우
            dp[i] = Math.max(dp[i-3] + stairs[i-1] + stairs[i], dp[i-2] + stairs[i]);
        }
        System.out.println(dp[n-1]);
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