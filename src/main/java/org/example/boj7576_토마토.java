package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj7576_토마토 {

    static int[] dirx = {-1,1,0,0};
    static int[] diry = {0,0,-1,1};

    static int MAX_DAY = 1000000000;
    static void input() throws Exception {
        int n = scan.nextInt();
        int m = scan.nextInt();
        int [][] board = new int[m][n];
        int visited[][] = new int[m][n];
        for (int i = 0; i <m ; i++) {
            Arrays.fill(visited[i], MAX_DAY);
        }
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = scan.nextInt();
                if(board[i][j] ==1){
                    q.add(new int[]{i,j,0});
                }
                else if(board[i][j] == -1){
                    visited[i][j] = 0;
                }
            }
        }


        while(!q.isEmpty()){
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            int day = now[2];
            if(day >= visited[x][y]){
                continue;
            }
            visited[x][y] = day;
            for (int k = 0; k < 4; k++) {
                int newx = x + dirx[k];
                int newy = y + diry[k];
                if(newx >=0 && newx < m && newy>=0 && newy<n && board[newx][newy] == 0){
                    if(visited[newx][newy] > day+1){
                        q.add(new int[]{newx,newy,day+1});
                    }
                }
            }
        }

        int maxDay = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(visited[i][j] == MAX_DAY){
                    System.out.println(-1);
                    return;
                }
                maxDay = Math.max(maxDay, visited[i][j]);
            }
        }

        System.out.println(maxDay);


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