package org.example;

import java.io.*;
import java.util.StringTokenizer;

public class 동전0_11047 {

    static void input() throws Exception {
        int n =scan.nextInt();
        int objMoney = scan.nextInt();
        int[] coins = new int[n];
        for(int i = 0 ; i < n  ; i++)
            coins[i] = scan.nextInt();
        int index = n-1;
        int nowMoney = 0;
        int coinCount = 0;
        while(objMoney > 0){
            if(coins[index] > objMoney)
                index--;
            else {
                objMoney -= coins[index];
                coinCount++;
            }
        }
        System.out.println(coinCount);

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