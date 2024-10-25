package probs.boj;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class boj_13311_행운의편지 {

    static void input() throws Exception {
        // n ≡ a - 1 (mod a)
        // n을 a로 나눈 나머지 = a-1를 a로 나눈 나머지
        // n을 a로 나눈 나머지 = a-1
        // n % 2 = 1 <- 1 3 5 7 9 11 13 15 17 19 21
        // n % 3 = 2 <- 2 5 8 11 14 17 20 23 26 29 32 35 38 41 44 47 50 53 56 59
        // n % 4 = 3 <- 3 7 11 15 19 23 27 31 35 39 43 47 51 55 59
        // n % 5 = 4 <- 4 9 14 19 24 29 34 39 44 49 54 59
        // n % 6 = 5 <-
        // 2부터 1000까지 모든 숫자를 소인수 분해하여 각 인수의 최대 개수로 나온 수들끼리 곱한다.
        // 최소공배수 구하기 :
        // lcm(a,b) = gcd(a,b) * a / gcd(a,b) * b / gcd(a,b)
        BigInteger n =  new BigInteger("2");
        for (int i = 3; i <= 1000; i++) {
            n = lcm(n,new BigInteger(String.valueOf(i)));
        }
        System.out.println(n.subtract(BigInteger.ONE));

        BigInteger test = n.subtract(BigInteger.ONE);

        // for (int i = 2; i <= 1000; i++) {
        //     System.out.println("test.mod(BigInteger.valueOf(i)) = " + test.mod(BigInteger.valueOf(i)));
        // }
    }

    static BigInteger lcm(BigInteger a, BigInteger b){
        return a.multiply(b).divide(a.gcd(b));
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
            br = new BufferedReader(new FileReader(s));
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