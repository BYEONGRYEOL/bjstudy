package org.example;

import java.io.*;
import java.sql.Array;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 좌표정렬하기_11650 {

    static void input() throws Exception {
        int n = scan.nextInt();
        ArrayList<int[]> list = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            list.add(new int[]{scan.nextInt(), scan.nextInt()});
        }
        list.sort((a1,a2) -> {
            if(a1[0]==a2[0]){
                return a1[1] - a2[1];
            }
            return a1[0]-a2[0];
        });
        list.stream().forEach((array) ->{
            sb.append(array[0]).append(' ').append(array[1]).append('\n');
        });

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