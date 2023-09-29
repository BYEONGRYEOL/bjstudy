package org.example;

import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class 요세푸스문제0_11866 {
    static void input() throws Exception {
        Queue<Integer> q = new LinkedList<>();
        int n = scan.nextInt();
        int k = scan.nextInt();
        // k-1만큼의 큐 회전이 필요하다.
        for(int i = 1 ; i<=n;i++)
            q.add(i);

        sb.append('<');
        while(!q.isEmpty()){
            for(int z=0;z<k-1;z++){
                int temp = q.poll();
                q.add(temp);
            }
            sb.append(q.poll()).append(',').append(' ');
        }
        // 마지막 ", " 제거
        sb.delete(sb.length() -2, sb.length());
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