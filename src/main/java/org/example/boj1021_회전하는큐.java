package org.example;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj1021_회전하는큐 {

    static void input() throws Exception {
        Queue<Integer> q = new LinkedList<>();
        int answer = 0;
        int n = scan.nextInt();
        int m = scan.nextInt();
        for(int i= 1 ; i <= n ; i ++)
            q.add(i);
        for(int i = 0 ; i <  m; i ++){
            int target = scan.nextInt();
            int len = q.size();
            // 현재 숫자가 큐으ㅟ 맨 앞에 있기 위해 필요한 2번 연산의 수
            int operationCount = 0;
            while(q.peek() != target){
                q.add(q.poll());
                operationCount++;
            }
            // while문탈출시 q.peek은 target이다
            q.poll();
            answer += Math.min(len - operationCount, operationCount); // 2번 3번 연산의 선택은 최소로

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