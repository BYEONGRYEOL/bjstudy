package org.example;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;

public class Turret1002 {

    static void input(){
        int caseNum = scan.nextInt();
        for(int z = 0; z < caseNum; z++){
            // 문제 조건 정리
            int x1 = scan.nextInt();
            int y1 = scan.nextInt();
            int r1 = scan.nextInt();
            int x2 = scan.nextInt();
            int y2 = scan.nextInt();
            int r2 = scan.nextInt();

            // 문제 이해를 위해 그림을 그려보니까
            // 두 원이 몇개의 점에서 만나는지를 물어보는 것이다.
            // 두 원의 중심 사이의 거리가 중요
            double d_CenterOfCircle = Math.pow((x1-x2) * (x1-x2) + (y1-y2) * (y1-y2), 0.5);

            if(d_CenterOfCircle == 0 && r1 == r2) // case6 겹침
                sb.append(-1);
            else if(d_CenterOfCircle > r1+r2) //case5 멀어서 안만남
                sb.append(0);
            else if(d_CenterOfCircle < Math.abs(r1-r2)) //case2 포함관계에 안만남
                sb.append(0);
            else if(d_CenterOfCircle == Math.abs(r1-r2)) // case3 내접
                sb.append(1);
            else if(d_CenterOfCircle == r1+r2) // case4 외접
                sb.append(1);
            else // case1 나머지는 두점에서 만남
                sb.append(2);
            //테스트케이스간 줄넘김
            sb.append('\n');
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
    public static void main(String[] args) {
        input();
    }
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();



}