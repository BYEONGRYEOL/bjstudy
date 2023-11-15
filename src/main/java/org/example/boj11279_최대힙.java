package org.example;

import java.io.*;
import java.util.*;

public class boj11279_최대힙 {
    static void input() throws Exception {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int n = scan.nextInt();
        for(int i = 0 ; i < n  ; i ++){
            int operation = scan.nextInt();
            if(operation == 0){
                if(pq.isEmpty())
                    sb.append(0);
                else
                    sb.append(pq.poll());
                sb.append('\n');
            }
            else{
                pq.add(operation);
            }
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