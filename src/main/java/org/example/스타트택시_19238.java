//package org.example;
//import java.util.*;
//import java.util.Map.Entry;
//import java.util.regex.*;
//import java.io.*;
//import java.util.stream.*;
//
//public class 스타트택시_19238 {
//
//    static class State{
//        int x;
//        int y;
//        int d;
//        public State(int x, int y, int d){
//            this.x = x;
//            this.y = y;
//            this.d = d;
//        }
//    }
//
//    static int n;
//    static int[][] board;
//    static boolean visited[][];
//    static int[] dirx = {-1,1,0,0};
//    static int[] diry = {0,0,-1,1};
//
//    static int getDistanceToDestination(){
//
//    }
//
//    static String findNextBoarder(Map<String, int[]> missions, int x, int y){
//        Queue<State> q = new LinkedList<>();
//        q.add(new State(x,y,0));
//        int minD = Integer.MAX_VALUE;
//        int minIndex = 401;
//        String result = "";
//        while(!q.isEmpty()){
//            State now = q.poll();
//            if(minD < now.d)
//                break;
//            String pos = String.format("%02d%02d", now.x, now.y);
//            if(missions.containsKey(pos)){
//                minD = now.d;
//                if(missions.get(pos)[0] < minIndex){
//                    result = pos;
//                    minIndex = missions.get(pos)[0];
//                }
//            }
//            for(int k = 0 ; k < 4; k ++){
//                int newx = now.x +dirx[k];
//                int newy = now.y + diry[k];
//                if(newx >=0 && newx < n && newy>=0 && newy < n && board[newx][newy] == 0){
//                    q.add(new State(newx,newy,now.d+1));
//                }
//            }
//        }
//        return result;
//    }
//
//    static void input() throws Exception{
//        n = scan.nextInt();
//        int m = scan.nextInt();
//        int fuel = scan.nextInt();
//        board = new int[n][n];
//        visited = new boolean[n][n];
//
//        for(int i = 0 ; i <  n ; i ++)
//            for(int j = 0 ; j < n ; j ++)
//                board[i][j] = scan.nextInt();
//
//        int x = scan.nextInt()-1;
//        int y = scan.nextInt()-1;
//
//
//        Map<String, int[]> missions = new HashMap<>();
//        for(int i = 1 ; i < m+1 ; i++){
//            String key = String.format("%02d%02d", scan.nextInt()-1, scan.nextInt()-1); // 손님 위치
//            missions.put(key, new int[]{i, scan.nextInt()-1, scan.nextInt()-1}); // 손님의 목적지
//        }
//
//
//        for(int i = 0 ; i < m; i ++){
//            String nextBoarder = findNextBoarder(missions, x,y);
//            int boardingx = Integer.parseInt(nextBoarder.substring(0,2));
//            int boardingy = Integer.parseInt(nextBoarder.substring(2,4));
//            int destx =missions.get(nextBoarder)[1];
//            int desty =missions.get(nextBoarder)[2];
//            int boardingDistance = Math.abs(x - boardingx) + Math.abs(y - boardingy);
//            int destinationDistance =  Math.abs(destx - boardingx) + Math.abs(desty - boardingy);
//
//            System.out.println(nextBoarder);
//            if(fuel < boardingDistance + destinationDistance){
//                System.out.println(-1);
//                return;
//            }
//            fuel += destinationDistance - boardingDistance;
//            x = destx;
//            y = desty;
//            missions.remove(nextBoarder);
//
//            System.out.println(fuel);
//        }
//
//        System.out.println(fuel);
//    }
//
//
//    // # region defaultregion
//    public static void main(String[] args) throws Exception {
//        input();
//    }
//
//
//    static void print() {
//        System.out.println(sb.toString());
//    }
//
//    static FastReader scan = new FastReader();
//    static StringBuilder sb = new StringBuilder();
//
//    static class FastReader {
//        BufferedReader br;
//        StringTokenizer st;
//
//        public FastReader() {
//            br = new BufferedReader(new InputStreamReader(System.in));
//        }
//
//        public FastReader(String s) throws FileNotFoundException {
//            br = new BufferedReader(new FileReader(new File(s)));
//        }
//
//        String next() {
//            while (st == null || !st.hasMoreElements()) {
//                try {
//                    st = new StringTokenizer(br.readLine());
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            return st.nextToken();
//        }
//
//        int nextInt() {
//            return Integer.parseInt(next());
//        }
//
//        long nextLong() {
//            return Long.parseLong(next());
//        }
//
//        double nextDouble() {
//            return Double.parseDouble(next());
//        }
//
//        String nextLine() {
//            String str = "";
//            try {
//                str = br.readLine();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            return str;
//        }
//    }
//
//    // #endregion
//}