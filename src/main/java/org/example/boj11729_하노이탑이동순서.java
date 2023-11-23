package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj11729_하노이탑이동순서 {

    static int moveCount = 0;
    static void move(int s, int e, int n){
        if(n == 1){
            moveCount++;
            sb.append(s).append(' ').append(e).append('\n');
            return;
        }
        int m = 6-s-e;
        move(s, m, n-1);
        move(s, e, 1);
        move(m,e,n-1);
    }
    static void input() throws Exception {
        // 수행되는 행동을 3개로 나눔,
        // 1. 가장 아래의 원판을 제외하고 목적지가 아닌 곳으로 이동
        // 2. 가장 아래의 원판을 목적지로 이동
        // 3. 1에서 이동된 원판들을 목적지로 이동

        // 시작점 1, 목적지 3
        // 원판이 한개라면 move(1,3)
        // 원판이 두개라면 1{move(1,2)} -> 2{move(1,3)} -> 3{move(2,3)}
        // 원판이 세개라면 1{move(1,3), move(1,2), move(3,2)} -> 2{move(1,3)} -> 3{move(2,1), move(2,3), move(1,3)}
        int n = scan.nextInt();

        move(1,3,n);
        sb.insert(0, moveCount + "\n"); // 2^n - 1 번 이동할 게 뻔하지만 휴먼 에러 방지를 위해
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