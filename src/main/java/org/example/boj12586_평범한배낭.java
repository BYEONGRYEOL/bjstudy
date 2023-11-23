package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj12586_평범한배낭 {

    static void input() throws Exception {
        int n = scan.nextInt();
        int maxW = scan.nextInt();
        int w[] = new int[n];
        int v[] = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scan.nextInt();
            v[i] = scan.nextInt();
        }
        int dp[] = new int[maxW+1];
        // 무게  6 4 3  5
        // 가치 13 8 6 12
        for(int i = 0 ; i < n ; i ++){
            for(int nowW = maxW; nowW >= w[i]; nowW--){
                //현재 물건을 넣었을 때의 최대값과 다른 물건으로 만들어 둔 최대값을 비교한다.
                dp[nowW] = Math.max(dp[nowW], dp[nowW-w[i]] + v[i]);
                // i=0일떄 w=6,v=13인 물건으로 dp[7], dp[6]이 13으로 갱신됨,
                // i=1일떄 w=4,v=8인 물건으로 dp[7], dp[6]은 13 유지, dp[5], dp[4]가 8로 갱신됨
                // i=2일떄 w=3,v=6인 물건으로 dp[7]이 dp[4](=8) + v(=6) = 14로 갱신됨, dp[3]이 6으로 갱신됨
                // ----
            }
        }

        System.out.println(dp[maxW]);


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