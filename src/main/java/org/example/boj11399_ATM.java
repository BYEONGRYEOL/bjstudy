package org.example;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj11399_ATM {

    static void input() throws Exception {
        // 당연히 작업 시간이 짧은 사람부터 out되어야 한다.
        int n = scan.nextInt();
        int[] array = new int[n];
        for(int i = 0 ; i<  n ; i++)
            array[i] = scan.nextInt();

        Arrays.sort(array); // 오름차순

        int answer = 0;
        int waitingTime = 0;
        for(int i = 0 ; i < n ; i++){
            waitingTime += array[i];
            answer += waitingTime;
        }
        System.out.println(answer);
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