package org.example;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 블랙잭_2798 {

    static void input() throws Exception {
        // 카드의 개수가 많지 않으니 반복문으로 해결
        int n = scan.nextInt();
        int objNumber = scan.nextInt();
        int cards[] = new int[n];
        for(int i = 0 ; i < n ; i ++)
            cards[i] = scan.nextInt();

        int maxNum = 0;
        for(int i = 0 ; i < n ; i ++)
            for(int j = i+1; j<n; j++)
                for(int k = j+1; k<n;k++){
                    int num =cards[i]+cards[j]+cards[k];
                    if(num > maxNum &&num <= objNumber)
                        maxNum = num;
                }
        System.out.println(maxNum);
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