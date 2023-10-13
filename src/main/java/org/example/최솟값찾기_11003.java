package org.example;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최솟값찾기_11003 {
    static void input() throws Exception {
        // 1 5 2 4 3 7
        // l= 5 0번째 인덱스는 5번째 인덱스를 검사할때 는 고려x
        // 5 2 4 3 7
        int n = scan.nextInt();
        int l = scan.nextInt();
        int array[][] = new int[n][2];
        for(int i = 0 ; i < n ; i ++)
            array[i] = new int[]{scan.nextInt(), i};
        PriorityQueue<int[]> pq = new PriorityQueue<>((a1,a2) -> a1[0] - a2[0]);
        for(int i = 0; i < n ; i ++){
            pq.add(array[i]);
            // 0번째에 들어간 수라면 l=5일때 i= 4일때 까지만 유효하다
            while(pq.peek()[1] <= i - l)
                pq.poll();
            sb.append(pq.peek()[0]).append(' ');
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