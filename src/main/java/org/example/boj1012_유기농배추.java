package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj1012_유기농배추 {

    static int[] dirx = {-1,1,0,0};
    static int[] diry = {0,0,-1,1};
    static void clustering(boolean[][] board, boolean[][] visited, int i, int j){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i,j});
        while(!q.isEmpty()){
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            if(visited[x][y])
                continue;

            visited[x][y] = true;

            for (int k = 0; k < 4; k++) {
                int newx = x + dirx[k];
                int newy = y+diry[k];
                if(newx >=0 && newx < board.length && newy >=0 && newy <board[0].length && board[newx][newy])
                    q.add(new int[]{newx,newy});
            }
        }
    }


    static void input() throws Exception {
        int testCase = scan.nextInt();
        for (int t = 0; t < testCase ; t++) {
            int m = scan.nextInt();
            int n = scan.nextInt();
            int k = scan.nextInt();
            boolean[][] board = new boolean[n][m];
            boolean[][] visited = new boolean[n][m];
            for (int i = 0; i < k; i++) {
                int y = scan.nextInt();
                int x = scan.nextInt();
                board[x][y] = true;
            }

            int numOfCluster = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (!visited[i][j] && board[i][j]) {
                        numOfCluster++;
                        clustering(board, visited, i, j);
                    }
                }
            }
            sb.append(numOfCluster).append('\n');
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