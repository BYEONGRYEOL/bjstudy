package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1010_다리놓기 {

    static void input() throws Exception {
        // 다리끼리 서로 겹쳐질 수 없다.
        // 연결될 point M과 point N이 결정되면, 서로 겹치지 않게 이어야한다. -> 순서 없이 M,N point를 선택하면 된다.
        // 30C15 같은 큰 수의 경우 팩토리얼을 활용하면 계산과정에 overflow가 날 수도 있다.
        
        int C[][] = new int[31][31];
        for(int i = 1; i  <31; i ++){ // 파스칼삼각형 끝점들
            C[i][0] = 1;
            C[i][i] = 1;
        }
        for(int i = 2; i < 31; i++){
            for(int j = 1; j<i; j++){
                C[i][j] = C[i-1][j-1] + C[i-1][j];
            }
        }
        int T = scan.nextInt();
        for(int i = 0 ; i < T; i ++){
            int N = scan.nextInt();
            int M = scan.nextInt();
            sb.append(C[M][N]).append('\n');
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