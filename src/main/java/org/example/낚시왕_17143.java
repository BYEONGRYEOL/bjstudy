package org.example;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 낚시왕_17143 {
    static int R;
    static int C;
    static int X;
    static int Y;
    static int[] dirx = {-100,-1,1,0,0};
    static int[] diry = {-100,0,0,-1,1};
    static void input() throws Exception {
        R = scan.nextInt();
        C = scan.nextInt();
        int M = scan.nextInt();
    }
    class Shark{
        int x;
        int y;
        int speed;
        int dir; // 상하좌우 1,2,3,4
        int value;
        public Shark(int x, int y, int speed, int dir, int value){
            this.x = x;
            this.y = y;
            this.speed = speed;
            this.dir = dir;
            this.value = value;
        }
        public int move(){
            int newx = this.x + dirx[this.dir] * speed;
            int newy = this.y + diry[this.dir] * speed;
            // x = 10, R = 11, newx 14? -> x = R - newx;
            newx = newx > R ? newx - R : newx;
            newy = newy > R ? newy - R : newy;

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