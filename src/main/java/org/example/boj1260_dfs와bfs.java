package org.example;

import java.io.*;
import java.util.*;

public class boj1260_dfs와bfs {
    static int N;
    static int M;
    static boolean[] visited;
    static int S;
    static ArrayList<Integer>[] edges;

    static void dfs(int node){
        sb.append(node).append(' ');
        visited[node] = true;
        for(Integer next : edges[node]){
            if(!visited[next]){
                dfs(next);
            }
        }
    }
    static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        while(!q.isEmpty()){
            Integer now = q.poll();
            if(visited[now])
                continue;
            visited[now] = true;
            sb.append(now).append(' ');
            for(Integer next : edges[now]){
                if(!visited[next]){
                    q.add(next);
                }
            }
        }
    }
    static void input() throws Exception {
        N = scan.nextInt();
        M = scan.nextInt();
        S = scan.nextInt();
        edges = new ArrayList[N+1];
        visited = new boolean[N+1];
        for(int i = 1 ; i < N+1; i ++){
            edges[i] = new ArrayList<>();
        }

        for(int i = 0 ; i  < M; i++){
            int s = scan.nextInt();
            int e = scan.nextInt();
            edges[s].add(e);
            edges[e].add(s);
        }
        for(int i = 1 ; i < N+1; i ++){
            edges[i].sort((i1,i2)->i1-i2);
        }

        dfs(S);
        print();
        sb.setLength(0);
        sb.append('\n');
        Arrays.fill(visited, false);
        bfs(S);
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