package org.example;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 항해시험1 {

//    static class Node{
//        int value;
//        Node r;
//        public Node(int value){
//            this.value = value;
//        }
//    }
//
//    static class CLL{
//        int len;
//        Node head;
//        Node now;
//        public CLL(int len){
//            this.len = len;
//        }
//        public void add(int value){
//            if(this.head == null){
//                this.head = new Node(value);
//                this.now = this.head;
//                return;
//            }
//            Node newNode = new Node(value);
//            this.now.r = newNode;
//            this.now = this.now.r;
//            if( value == this.len){
//                this.now.r = this.head;
//            }
//
//        }
//        public int delete(int m){
//            while(m>1){
//                this.now = this.now.r;
//                m--;
//            }
//            int result = this.now.r.value;
//            this.now.r = this.now.r.r;
//            return result;
//        }
//    }

    static int[] array;

    static void input() throws Exception {
        array = new int[201];
        while(true){
            int n = scan.nextInt();
            int m = scan.nextInt();
            int k = scan.nextInt();

            if(n==0)
                break;

            boolean[] visited = new boolean[n+1];

            int index = 0;

            for(int i =  0 ; i < k; i++){
                int count = 0;
                while(count < m){
                    index++;
                    if(index > n)
                        index = 1;
                    if(!visited[index]) {
                        count++;
                    }
                }
                visited[index] = true;
            }
            sb.append(index).append('\n');
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