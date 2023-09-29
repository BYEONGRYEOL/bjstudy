package org.example;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;

public class 경사로 {

    static int n;
    static int len;
    static int[][] board;

    static boolean canGoRow(int r ){
        // l == 2인 경우
        // 3 2 2 1 1 1 1 2 2 3 도 검사할수있어야함
            int flatBeforeUp =len -1;
            int flatBeforeDown = 0;
            int recentNum = board[r][0];
            for(int c=1; c < n ; c++){
                if(Math.abs(board[r][c] - recentNum) >1){
                    return false;
                }
                else if(board[r][c] - recentNum == 1){
                    // 한칸 올라가야 하는 경우이다
                    if(flatBeforeUp > 0){
                        return false;
                    }
                    else{

                        //올라 가게되면,
                        flatBeforeUp = len-1;
                        flatBeforeDown = 0;
                    }
                }
                else if(board[r][c] - recentNum == -1){
                    // 한칸 내려가야 하는 경우
                    if(flatBeforeDown > 0){
                        return false;
                    }
                    else{
                        // 내려가고 나서는
                        flatBeforeDown = len-1;
                        flatBeforeUp = 2* len - 1;
                    }
                }
                else{
                    flatBeforeUp --;
                    flatBeforeDown --;
                }
                recentNum = board[r][c];
            }
        if(flatBeforeDown > 0) return false;
        return true;

    }
    static boolean canGoCol(int c  ){
        // l == 2인 경우
        // 3 2 2 1 1 1 1 2 2 3 도 검사할수있어야함

            int flatBeforeUp =len -1;
            int flatBeforeDown = 0;
            int recentNum = board[0][c];
            for(int r=1; r < n ; r++){
                if(Math.abs(board[r][c] - recentNum) >1){
                    return false;
                }
                else if(board[r][c] - recentNum == 1){
                    // 한칸 올라가야 하는 경우이다
                    if(flatBeforeUp > 0){
                        return false;
                    }
                    else{
                        //올라 가게되면,
                        flatBeforeUp = len-1;
                    }
                }
                else if(board[r][c] - recentNum == -1){
                    // 한칸 내려가야 하는 경우
                    if(flatBeforeDown > 0){
                        return false;
                    }
                    else{
                        // 내려가고 나서는
                        flatBeforeDown = len-1;
                        flatBeforeUp = 2* len - 1;
                    }
                }
                else{
                    flatBeforeUp --;
                    flatBeforeDown --;
                }
                recentNum = board[r][c];
            }
        if(flatBeforeDown > 0) return false;
        return true;

    }


    static void input(){
        n = scan.nextInt();
        len = scan.nextInt();

        board = new int[n][n];
        int canGoCount =0;
        for(int i = 0 ; i < n ; i++)
            for(int j = 0 ; j < n ; j ++)
                board[i][j] = scan.nextInt();

        for(int r=0; r < n ; r++){
            // 행 검사
            canGoCount += canGoRow(r)? 1 : 0;
        }
        for(int c=0; c < n ; c++){
            canGoCount += canGoCol(c)? 1 : 0;
        }
        System.out.println(canGoCount);

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
    public static void main(String[] args) {
        input();
    }
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();



}