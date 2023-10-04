package org.example;

import java.io.*;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ATM_11399 {

    static void input() throws Exception {
        // 괄호를 왜 잃어버렸지? ㅋㅋㅋ

        // 숫자들을 다 빼내서 연산자들의 순서를 바꿔보기에는, 괄호를 생성하는 작업이라서
        // 인접한 숫자끼리만 연산을 할 수 있다.
        // 인간의 풀이로 한다면 +기호가 -기호 뒤에있다면 미리 다 더해서 -뒤에 올 숫자를 크게 만들어주면 될텐데..
        // +밖에 없거나 - 밖에 없으면 그냥 연산
        // -뒤에 +가 없는 경우도 그냥 연산
        // -뒤에 +가 있다면 -로 치환
        // -뒤에 +, -가 반복되더라도 어떤 +가 -로 치환 가능한지만 생각하면된다.

        String s = scan.nextLine();
        // (연속된 어떤 숫자) 혹은 (+- 기호중 한개) 가 나오는 경우 split 하는 정규식
        // 1. 정규식 규칙 정의
        String regex = "\\d+|[+-]";
        // 2. 패턴 컴파일
        Pattern pattern = Pattern.compile(regex);
        // 3. matcher
        Matcher matcher = pattern.matcher(s);

        boolean minusFlag = false;
        int answer = 0;
        
        
        // 홀수 인덱스가 기호겠지만 -30 + 40 이라는 문제에도 대응할 수 있도록, 
        // 해당 문제의 조건과는 관련 없이 문자인지 숫자인지 검사하여 행동하도록 구현
        while(matcher.find()){
            String element = matcher.group();
            if(element.matches("\\d+")){
                // 숫자인경우
                if(minusFlag) // 이전에 한번이라도 -기호가 나온 적이 있다면
                    answer -= Integer.parseInt(element);
                else // 한번도 - 기호가 나온 적이 없다면
                    answer += Integer.parseInt(element);
            }
            else{
                if(element.equals("-"))
                    minusFlag = true;
            }
        }

        System.out.println(answer);
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