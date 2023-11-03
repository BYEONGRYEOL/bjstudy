package org.example;

import java.io.*;
import java.util.*;

public class 낚시왕_17143 {
    static int R;
    static int C;
    static int X;
    static int Y;
    static int[] dirx = {-100,-1,1,0,0};
    static int[] diry = {-100,0,0,-1,1};
    static int[][] board;
    static ArrayList<Shark> sharks;
    static void input() throws Exception {
        R = scan.nextInt();
        C = scan.nextInt();
        int M = scan.nextInt();
        board = new int[R+1][C+1];
        sharks = new ArrayList<>();
        for(int i = 0; i < M; i++){
            int x = scan.nextInt();
            int y = scan.nextInt();
            int s = scan.nextInt();
            int d = scan.nextInt();
            int z = scan.nextInt();
            sharks.add(new Shark(x,y,s,d,z));
            board[x][y] = z;
        }

        int sizeSum = 0;
        for(int col = 1 ; col < C+1; col++){
            sizeSum += catchShark(col);
            for(int i = 0 ; i <M ; i ++){
                sharks.get(i).move();
            }
        }

    }
    static int catchShark(int col){
        for(int row = 1; row<R+1; row++){
            if(board[row][col] >0){
                int size = board[row][col];
                board[row][col] = 0;
                return size;
            }
        }
        return 0;
    }
    static class Shark{
        int x;
        int y;
        int speed;
        int dir; // 상하좌우 1,2,3,4
        int size;
        public Shark(int x, int y, int speed, int dir, int value){
            this.x = x;
            this.y = y;
            this.speed = speed;
            this.dir = dir;
            this.size = value;
        }
        private boolean isAlive(){
            return board[this.x][this.y] == this.size;
        }
        public void move(){
            if(isAlive() == false)
                return;
            board[this.x][this.y] = 0;

            int newx = this.x;
            int newy = this.y;

            if(this.dir == 1){
                // 이동할 칸 수 / 끝과 끝 거리 = 짝수라면 방향 그대로, 홀수라면 방향 변경aaaa
                int moveCellNum = this.speed % ((C-1) * 2);
            }
            int alreadySize = board[newx][newy];
            if(alreadySize > this.size){
                return;
            }
            board[newx][newy] = this.size;

        }

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