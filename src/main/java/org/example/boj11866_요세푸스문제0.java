package org.example;

import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class boj11866_요세푸스문제0 {
    static void input() throws Exception {
        // 1 2 3 4 5 6 7
        // 앞에서 빼서 뒤에 이어붙이는 작업
        Queue<Integer> q = new LinkedList<>();
        int n = scan.nextInt();
        for(int i = 1 ; i <= n; i++){
            q.add(i);
        }
        int k = scan.nextInt();
        int[] answer = new int[n];
        int index = 0;
        while(!q.isEmpty()){
            int moves = k;
            for(int move = 0 ; move < k-1 ; move ++) // k-1명의 사람은 그냥 뒤로 보내고
                q.add(q.poll());
            answer[index++] = q.poll(); // k번째는 정답에 추가
        }

        sb.append('<');
        for(int i = 0 ; i < n ; i ++)
            sb.append(answer[i]).append(',').append(' ');
        sb.delete(sb.length()-2, sb.length());
        sb.append('>');
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