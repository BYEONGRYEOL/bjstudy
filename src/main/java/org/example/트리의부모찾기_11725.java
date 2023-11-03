package org.example;

import java.io.*;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 트리의부모찾기_11725 {


    static ArrayList<Integer>[] edges;
    static int[] parents;
    static void dfs(int parent, int child){
        if(parents[child] > 0)
            return;
        parents[child] = parent;
        for(Integer i : edges[child]){
            dfs(child, i);
        }
    }
    static void input() throws Exception {
        int N = scan.nextInt();
        edges = new ArrayList[N+1];
        for(int i = 0 ; i < N+1; i++){
            edges[i] = new ArrayList<>();
        }
        parents = new int[N+1];
        for(int i = 0 ; i < N-1 ; i++){
            int p = scan.nextInt();
            int c = scan.nextInt();
            edges[p].add(c);
            edges[c].add(p);
        }
        int s = 1;
        dfs(-1, 1);
        for(int i = 2; i < N+1; i++){
            sb.append(parents[i]).append('\n');
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