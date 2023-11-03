package org.example;

import java.io.*;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Stream;


public class test1 {

    static void input() throws Exception
    {
        int n = scan.nextInt();
        int[][] times = new int[n][3];
        for(int i = 0 ; i <  n ; i ++){
            times[i] = new int[]{scan.nextInt(),scan.nextInt(),scan.nextInt()};

        }
        Arrays.sort(times, (a1, a2) -> {
            if(a1[0] == a2[0]){
                if(a1[1] == a2[1]){
                    return a1[2] - a2[2];
                }
                return a1[1]- a2[1];
            }
            return a1[0] - a2[0];
        });
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < 3; j ++){
                sb.append(times[i][j]).append(' ');
            }
            sb.append('\n');
        }
        print();
    }
    static long lessThanCount(long n, long x){
        long count = 0;
        for(int i = 1 ;i <=n;i++){
            count +=Math.min(n, x/i);
        }
        return count;
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