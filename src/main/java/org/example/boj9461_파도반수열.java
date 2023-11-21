package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj9461_파도반수열 {

    static void input() throws Exception {
        // 신기하게도 integer overflow가 난다
        int T = scan.nextInt();
        long padovan[] = new long[101];
        padovan[1] = 1;
        padovan[2] = 1;
        padovan[3] = 1;
        padovan[4] = 2;
        padovan[5] = 2; // 이상하게도 4번삼각형하고만 맞닿아있다.
        padovan[6] = padovan[6-1] + padovan[6-5]; // n=6부터 제대로된 규칙
        for (int j = 6; j <101 ; j++) {
            padovan[j] = padovan[j-1] + padovan[j-5];
        }
        for(int i = 0 ; i < T; i++){
            sb.append(padovan[scan.nextInt()]).append('\n');
        }
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