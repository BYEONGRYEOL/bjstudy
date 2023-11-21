package org.example;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj11047_동전0 {

    static void input() throws Exception {
        int n =scan.nextInt();
        int target = scan.nextInt();
        // A_i 는 A_{i-1} 의 배수 라는 조건 때문에,
        // 서로소인 수를 만들기 위해 작은 단위의 동전을 사용하지 않아도 된다.
        int coins[] = new int[n];
        for(int i = 0 ; i < n ; i++)
            coins[i] = scan.nextInt();
        n--;
        int result = 0;
        while(true){
            while(target >= coins[n]){
                target -= coins[n];
                result++;
            }
            if(target == 0)
                break;
            n--;
        }
        System.out.println(result);
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