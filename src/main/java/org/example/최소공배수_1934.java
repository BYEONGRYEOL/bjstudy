package org.example;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 최소공배수_1934 {
    // 인터넷 안보고 풀어보기!!!!
    static int GCD(int a, int b){
        // 입력이 72, 54라면?
        // 나눠지지 않으므로 54, 18에 대해서 재검사
        return (a % b == 0) ? b : GCD(b, a%b);
    }
    static int LCM(int a, int b){
        //최소공배수 = a * b / GCD(a,b)
        // 왜냐면 a/GCD * b/GCD * GCD가 겹치는 인수들을 걸러내는 방법이므로
        return a * b / GCD(a,b);
    }
    static void input() throws Exception {
        int caseNum = scan.nextInt();
        for(int z= 0 ; z < caseNum ; z++){
            sb.append(LCM(scan.nextInt(), scan.nextInt())).append('\n');
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