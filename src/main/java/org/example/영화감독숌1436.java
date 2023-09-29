package org.example;

import java.io.*;
import java.util.StringTokenizer;

public class 영화감독숌1436 {
    static boolean isShomNumber(int n){
        boolean flag = false;
        int sixCount = 0;
        while(n>0){
            if(n/10 == 6){
                sixCount++;
            }
            else
                sixCount=0;
            if(sixCount == 3){
                flag = true;
                break;
            }
        }
        return flag;
    }
    static void input() throws Exception {
        //   666  1666  2666  3666  4666  5666  6660  6661  6662  6663  6664  6665  6666  6667  6668  6669  7666  8666  9666
        // 10666 11666 12666 13666 14666 15666 16660 16661 16662 16663 16664 16665 16666 16667 16668 16669 17666 18666 19666
        // 20666 21666 ....              25666 26660 26661 26662 26663 26664 26665 26666 26667 26668 26669 27666 28666 29666
        // 16개씩 반복되며 첫번째 수 666을 0번째라고 가정하면

        // 666   ~ 6 + 10 + 3
        // 10666 ~ 6 + 10 + 3
        // 이하동일
        // 문제는 만의 자리가 6이 되었을때인데,
        // 60666 61666 62666 63666 64666 65666 6개
        // 66600 부터 66699 100개
        // 67666 ~ 69666 3 개로
        // 60666 ~ 6 + 100 + 3
        // 70666 부터 90666 까지는 다시 6 + 10 + 3

        // 100666은?
        // 101666 102666 103666 104666 105666 106660 ~ 106669 107666 108666 109666
        // 160666 은 6 + 100 + 3
        // 660666 은 6 + 1000 + 9

        // 규칙을 다 찾고 보니까 이렇게 풀라고 있는 문제가 아닌거같다.. 666부터 검사하면 되는것을..


        int num = 666;
        int n = scan.nextInt();
        int count = 0;
        while(count < n){
            if(isShomNumber(num)){
                count++;
            }
            num++;
        }
        System.out.println(num-1);
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