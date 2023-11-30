package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj9663_Nqueen {

    static int N;
    static int[] QUEEN_POSITION;
    static int answer =0;
    static boolean valid(int row){
        for (int i = 0; i < row; i++) {
            // 현재 행과 열번호가 겹치는게 존재하는가?
            // 행 차이, 열 차이의 절댓값이 같아서 대각선으로 닿는 게 존재한느가?
            if(QUEEN_POSITION[i] == QUEEN_POSITION[row] || row-i == Math.abs(QUEEN_POSITION[row] - QUEEN_POSITION[i]))
                return false;
        }
        return true;
    }

    static void TryRow(int row){
        if(row == N){
            answer ++;
            return;
        }
        for (int col = 0; col < N; col++) {
            QUEEN_POSITION[row] = col;
            if(valid(row)){
                TryRow(row+1);
            }
        }
    }

    static void input() throws Exception {
        N = scan.nextInt();
        QUEEN_POSITION = new int[N];
        TryRow(0);
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