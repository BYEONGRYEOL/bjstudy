package org.example;

import java.io.*;
import java.util.StringTokenizer;


public class boj1011_FlymetotheAlphaCentauri {


    static void input() throws Exception {
        // 현재 이동 길이를 k라고하면
        // 다음은 k-1 k k+1 중 하나

        // 1
        // 1
        // 2
        // 1 1
        // 3
        // 1 1 1
        // 4
        // 1 2 1
        // 5
        // 1 2 1 1
        // 6
        // 1 2 2 1
        // 7
        // 1 2 2 1 1
        // 1 2 3 2 1로 돌아오는 것이 5개의 최대이동
        // 9
        // 1 2 3 4 3 2 1
        // 16
        // 1 2 3 4 5 4 3 2 1
        // 25
        // 제곱수가 될 때 최소이동횟수가 2씩 늘어난다.

        // 10 ~ 16인 경우 반을 나눠서 6,7
        // 17 ~ 25 인 경우 반을 나눠서8, 9

        int cases = scan.nextInt();
        for(int i = 0 ; i < cases; i++){
            long x = scan.nextInt();
            long y = scan.nextInt();
            long d = y - x;
            int root = (int)Math.pow(d - 1, 0.5);
            // 이러면 10~16 의 범위를 9~15로 바꿀 수 있다.
            // 모두 루트를 씌웠을 때 3.xxx 로 표현
            // 현재 숫자가 9~15의 범위에서 중앙을 기준으로 어느쪽에 가까운지?
            // (9+15)/2 를 해봐야 암
            double mid = (Math.pow(root, 2) + Math.pow(root+1, 2))/2;

            sb.append((d>=mid)? root*2+1 : root *2).append('\n');
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
    static FastReader scanf;

    static StringBuilder sb = new StringBuilder();



}