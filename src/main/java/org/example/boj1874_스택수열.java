package org.example;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj1874_스택수열 {

    static void input(){
        int n = scan.nextInt();
        Stack<Integer> s = new Stack<>();
        int pointedNum = 1;
        boolean flag = true;
        for(int i = 0 ; i < n ; i ++){
            int num = scan.nextInt();
            // 현재 1, num이 될때 까지 push해야한다.
            while(num >= pointedNum){
                s.push(pointedNum++);
                sb.append('+').append('\n');
            }
            if(s.isEmpty()) { // 중간에 스택이 비었음
                flag = false;
                break;
            }
            if(s.peek() == num){ // 순서가 꼬임
                s.pop();
                sb.append('-').append('\n');
            }
            else{
                flag = false;
                break;
            }
        }
        if(flag)
            print();
        else{
            System.out.println("NO");
        }
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
    public static void main(String[] args) {
        input();
    }
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
}