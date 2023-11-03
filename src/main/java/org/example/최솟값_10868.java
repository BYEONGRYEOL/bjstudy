package org.example;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 최솟값_10868 {

    static int N;
    static int M;
    static int[] array;
    static int[] minArray;
    static int initSegTree(int s, int e, int index){
        if(s == e)
            return minArray[index] = array[s];
        int m = (s+e) / 2;
        minArray[index] =Math.min(initSegTree(s,m,index*2), initSegTree(m+1,e, index * 2 + 1));
        return minArray[index];
    }

    static int getMinValue(int s, int e, int l , int r, int index){
        if(l > e || r < s)
            return 1000000000;
        if(l <= s && r >= e)
            return minArray[index];

        int m = (s+e) / 2;
        return Math.min(getMinValue(s,m,l,r,index * 2), getMinValue(m+1,e,l,r,index*2+1));
    }
    static void input() throws Exception {
        N = scan.nextInt();
        M = scan.nextInt();
        array = new int[N];
        minArray = new int[N * 4];
        Arrays.fill(minArray, Integer.MAX_VALUE / 2);
        for(int i = 0; i < N; i++){
            array[i] = scan.nextInt();
        }
        initSegTree(0,N-1,1);
        for(int i =  0; i < M; i ++){
            sb.append(getMinValue(0,N-1,scan.nextInt()-1, scan.nextInt()-1, 1)).append('\n');
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