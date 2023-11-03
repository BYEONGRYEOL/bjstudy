package org.example;

import java.io.*;
import java.util.*;

public class 암호만들기_1759 {

    static char[] s;
    static int L;
    static int C;
    static char[] result;
    static void dfs(int i, int depth){
        if(depth == L){
            if(checkValid())
                sb.append(result).append('\n');
            return;
        }
        if(i == C)
            return;
        result[depth] = s[i];
        dfs(i+1, depth+1);
        dfs(i+1, depth);

    }
    static boolean checkValid(){
        int vowelCount = 0;
        for(int i = 0; i < L;i++){
            if(result[i] == 'a'||result[i] == 'e'||result[i] == 'i'||result[i] == 'o'||result[i] == 'u'){
                vowelCount++;
            }
        }
        return vowelCount > 0 && L - vowelCount > 1;
    }
    static void input() throws Exception {
        ArrayList<Character> vowels = new ArrayList<>();
        ArrayList<Character> consonents = new ArrayList<>();
         L = scan.nextInt();
         C = scan.nextInt();
        s = scan.nextLine().replaceAll(" ", "").toCharArray();
        Arrays.sort(s);
        result = new char[L];

        dfs(0,0);
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