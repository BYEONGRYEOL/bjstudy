package org.example;

import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class 회전하는큐1021 {
    static void input() throws Exception {
        // 10개짜리 큐에서
        // 2 9 5
        // 초기 1 2 3 4 5 6 7 8 9 10
        // 왼쪽이동 1회 + 2 뽑기
        // 3 4 5 6 7 8 9 10 1
        // 오른쪽 이동 3회 + 9 뽑기
        // 10 1 3 4 5 6 7 8
        Queue<Integer> q = new LinkedList<>();
        int n = scan.nextInt();
        for(int i = 1 ; i <= n ; i++)
            q.add(i);

        int k = scan.nextInt();

        int sumOfOperation = 0;
        for(int z = 0 ; z<k; z++){
            int num = scan.nextInt();
            int operationCount = 0;
            while(q.peek() != num){
                int temp = q.poll();
                q.add(temp);
                operationCount++;
            }

            // 큐의 길이가 12개, 원하는 원소가 앞에서 5번째에 있다면,
            // 왼쪽 이동 연산 4번 혹은 오른쪽 이동 연산 8번으로
            // 원하는 원소가 가장 앞에 있도록 할 수 있으며,
            // 왼쪽 이동을 하나 오른쪽 이동을 하나 숫자의 배치는 달라지지않는다.
            int minOperation = Math.min(operationCount, n - operationCount);
            sumOfOperation += minOperation;
            q.poll();
            n--;

        }
        System.out.println(sumOfOperation);

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