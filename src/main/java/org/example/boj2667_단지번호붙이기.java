package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class boj2667_단지번호붙이기 {


    static int numOfHouse = 0;
    static int[] dirx = {-1,1,0,0};
    static int[] diry = {0,0,-1,1};
    static void checkCluster(boolean[][] visited, int[][] array, int sx, int sy){
        if(visited[sx][sy])
            return;
        visited[sx][sy] = true;
        numOfHouse++;
        for (int k = 0; k < 4; k++) {
            int newx = sx+dirx[k];
            int newy = sy+diry[k];
            int len = array.length;
            if(newx>=0 && newx < len && newy >=0 && newy < len){
                if(!visited[newx][newy] && array[newx][newy] == 1){
                    checkCluster(visited, array, newx, newy);
                }
            }
        }
    }
    static void input() throws Exception {
        int n = scan.nextInt();
        int[][] array = new int[n][n];
        for (int i = 0; i < n; i++) {
            array[i] = Arrays.stream(scan.nextLine().split("")).mapToInt(Integer::parseInt).toArray();
        }
        boolean[][] visited = new boolean[n][n];

        int answer = 0;
        List<Integer> numOfHouses = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(!visited[i][j] && array[i][j] == 1){
                    checkCluster(visited, array, i, j);
                    numOfHouses.add(numOfHouse);
                    numOfHouse=0;
                    answer ++;
                }
            }
        }
        System.out.println(answer);
        numOfHouses.stream().sorted().forEach(System.out::println);
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