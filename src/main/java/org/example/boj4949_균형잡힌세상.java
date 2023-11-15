package org.example;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj4949_균형잡힌세상 {

    static void input(){
        while(true){
            String s = scan.nextLine();
            if(".".equals(s)){
                break;
            }
            Stack<Character> stack = new Stack<>();
            boolean rightParenthesisFlag = true;
            for(int i = 0 ; i < s.length(); i ++){
                switch(s.charAt(i)){
                    case '(':
                        stack.push('(');
                        break;
                    case ')':
                        if(!stack.isEmpty() && stack.peek() == '(')
                            stack.pop();
                        else
                            rightParenthesisFlag = false;
                        break;
                    case '[':
                        stack.push('[');
                        break;
                    case ']':
                        if(!stack.isEmpty() && stack.peek() == '[')
                            stack.pop();
                        else
                            rightParenthesisFlag = false;
                        break;
                }
                if(!rightParenthesisFlag)
                    break;
            }

            if(rightParenthesisFlag && stack.isEmpty())
                sb.append("yes").append('\n');
            else
                sb.append("no").append('\n');
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