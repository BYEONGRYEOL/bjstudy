package org.example;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 제곱ㄴㄴ수_1016 {
    static void input() throws Exception {

//        long min = scan.nextLong();
//        long max = scan.nextLong();
//
//        boolean isSqaured[] = new boolean[(int)(max - min) + 1];
//        long divisors[] = new long[1000001];
//        for(long i = 2; i < 1000001; i++){
//            divisors[i] =
//        }
//
//        for(long num = min; num <= max; num++){
//            if(isSqaured[(int)(num-min)] == false){
//                for()
//            }
//        }
        // 바꿔 말하면 어떤 정수 x가 소수들의 곱으로만 이루어져있는 것이기도 하다.
        // 에라토스테네스의 체와 비슷한 원리로 시도해보자
        // 검사할 수의 범위가 최대 1조 지만,
        // 1조까지의 제곱수의 개수는 1000000개로 추정되고,
        // 4의 배수를 검사한 이상 16의 배수는 검사할 필요가 없다.
        // 9의 배수를 검사한 이후 81의 배수를 검사할 필요가 없다.

        // 먼저 제곱수들
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