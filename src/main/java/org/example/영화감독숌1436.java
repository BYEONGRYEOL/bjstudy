package org.example;

import java.io.*;
import java.util.StringTokenizer;

public class 영화감독숌1436 {
    static int shomNumberCount(int n){
        if(n == 0)
            return 19;
        int sixCount = 0;
        int maxConsequenceSix = 0;
        while(n>0){
            if(n%10 == 6)
                sixCount++;
            else
                sixCount=0;
            n/=10;
            maxConsequenceSix = Math.max(maxConsequenceSix, sixCount);
        }
        return 9 + (int)Math.pow(10, (maxConsequenceSix + 1));
    }
    static void input() throws Exception {
        //   666  1666  2666  3666  4666  5666  6660  6661  6662  6663  6664  6665  6666  6667  6668  6669  7666  8666  9666
        // 10666 11666 12666 13666 14666 15666 16660 16661 16662 16663 16664 16665 16666 16667 16668 16669 17666 18666 19666
        // 20666 21666 ....              25666 26660 26661 26662 26663 26664 26665 26666 26667 26668 26669 27666 28666 29666
        // 19개씩 반복되며 첫번째 수 666을 0번째라고 가정하면

        // 0~   ~ 6 + 10 + 3
        // 10000 ~ 6 + 10 + 3
        // 이하동일
        // 문제는 만의 자리가 6이 되었을때인데,
        // 60666 61666 62666 63666 64666 65666 6개
        // 66600 부터 66699 100개
        // 67666 ~ 69666 3 개로
        // 60666 ~ 6 + 100 + 3
        // 70666 부터 90666 까지는 다시 6 + 10 + 3
        // 0~99999 사이 숌넘버는 총 9 * 10 + 10 * 9 + 100개

        // 100000 부터는?
        // 101666 102666 103666 104666 105666 106660 ~ 106669 107666 108666 109666
        // 160666 은 6 + 100 + 3
        // 600666 은 6 + 1000 + 3

        // 100000~200000 사이도 또한 9 * 10 + 10 * 9 + 100개
        // 10만 단위로 280개씩있다가 600000 일때는 9 * 10 + 10 * 9 + 1000 =  1180개

        // 만약 숫자가 20 이상이라면 10666부터 검사
        // 39 이상이라면 20666 ...

        // 00 10 20 30 40 50 "60" 70 80 90
        // 100 110 120 130 140 150 "160" 170 180 190
        // -----
        // 600 610 620 630 640 650 "660" 670 680 690

        // 19 19 19 19 19 19 109 19 19 19
        // 19 19 19 19 19 19 109 19 19 19
        // 19 19 19 19 19 19 109 19 19 19
        // 19 19 19 19 19 19 109 19 19 19
        // 19 19 19 19 19 19 109 19 19 19
        // 19 19 19 19 19 19 109 19 19 19
        // 19 19 19 19 19 19 1009 19 19 19
        // 19 19 19 19 19 19 109 19 19 19
        // 19 19 19 19 19 19 109 19 19 19
        // 19 19 19 19 19 19 109 19 19 19

        // 이런식으로 진행된다는 것
        // 현재 몇번째 연산중인지를 0부터 기록해서, 6, 16 ,26 ... 66일때는 6이 두개니까 1000으로 세볼까..
        int n = scan.nextInt();
        int count = 0;

        while(true){
            // 받아온 n이 280이하라면 100000 미만의 숌 넘버,
            int nowShomNumberCount = shomNumberCount(count);
            if(n>=nowShomNumberCount){
                n -= nowShomNumberCount;
                count++;
            }
            else
                break;
        }
        // count만큼의 만의 자리를 채워줘야함
        // 현재 n의 경우

        // count = 16, n = 1~6 -> 160666 ~ 165666
        // count = 16 n = 6 ~ 105 -> 166600 ~ 166699
        int shomNumber = 0;
        if(n <= 6){
            shomNumber = count * 10000 + (n-1) * 1000 + 666;
        }
        else{
            // 현재 수가 91이고 shomNumberCount가 109라면
            if(n< shomNumberCount(count) -3){
                // 뒤에자리를 채운 경우
                int digit = 0;
                while(n / 10 > 0){
                    n /=10;
                    digit++;
                }
                // digit 만큼을 다른데다가 더 곱해줘야함
                // 예를들어 count가 166이면 1666000 부터 시작해야한다.
                shomNumber = count*10000 + (666 / (int)Math.pow(10, digit)) * (int)Math.pow(10, digit+1);
                shomNumber += n - 7;
            }
            else{
                // 106 107 108
                shomNumber = count * 10000 + ((n % 10) + 1) * 1000 + 666;
            }


        }
        System.out.println(shomNumber);

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