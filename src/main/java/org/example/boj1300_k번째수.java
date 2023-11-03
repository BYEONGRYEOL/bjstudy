package org.example;

import java.io.*;
import java.util.StringTokenizer;

public class boj1300_k번째수 {

    static void input() throws Exception {
        // 1 2   3  4  5
        // 2 4   6  8 10
        // 3 6   9 12 15
        // 4 8  12 16 20
        // 5 10 15 20 25 30
        // // 1 2 3 4 5 6 7
        // 1행에서 x보다 작거나 같은 수의 개수는 x/1개
        // 2행에서 x보다 작거나 같은 수의 개수는 x/2개
        // 1 2 3 4 5 6
        // 2 4 6 8 10
        // 3 6 9
        // 4 8
        // 5 10
        // 6
        // 이 문제에서 15번째 수인 12를 찾고자하면,
        // 1행에서 12/1=12이 아닌 n(=4)개,
        // 2행에서 12/2=6이 아닌 n(=4)개,
        // 그러르모 i행에서 x보다 작거나 같은 수의 개수는 min(x/i, n)개이다.
        // sum of min(n, x/i) = k 가 되는 최소의 x값 찾기

        long n = scan.nextInt();
        int k = scan.nextInt();
        long l = 1;
        long r = n*n;
        long m = 0;
        while(l<r){
            m = (l+r)/2;
            long count = lessThanCount(n, m);
            if(count < k)  l = m+1;
            else if( count >= k) r = m;
        }
        System.out.println(l);
    }
    static long lessThanCount(long n, long x){
        long count = 0;
        for(int i = 1 ;i <=n;i++){
            count +=Math.min(n, x/i);
        }
        return count;
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