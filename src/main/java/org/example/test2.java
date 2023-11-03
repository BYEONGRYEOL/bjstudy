package org.example;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


public class test2 {

    static void permutation(char[] array, char[] output, boolean[] visited, int depth){
        if(depth == array.length){
            sb.append(output).append('\n');
            return;
        }

        for(int i = 0 ; i < array.length;i++){
            if(visited[i])
                continue;
            visited[i] = true;
            output[depth] = array[i];
            permutation(array, output, visited, depth+1);
            visited[i] = false;

        }
    }
    static void input() throws Exception
    {
        int n = scan.nextInt();
        for(int i = 0 ; i <n ; i++){
            char[] array = scan.nextLine().toCharArray();
            char[] output = new char[array.length];
            boolean[] visited = new boolean[array.length];
            sb.append(String.format("Case # %d:", i+1)).append('\n');
            permutation(array,output,visited,0);
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