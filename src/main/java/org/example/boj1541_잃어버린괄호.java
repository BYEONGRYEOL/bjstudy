package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;
import java.util.regex.*;

public class boj1541_잃어버린괄호 {

    static void input() throws Exception {
        // 맨 앞에 나온 수는 어쩔 수 없고
        //이후로 - 기호가 등장하는 순간부터 그 뒤는 모두 음수로 변경 가능하다.
        // 첫 -를 찾자
        String fomula = scan.nextLine();

        List<Integer> nums = new ArrayList<>();
        List<Character> operations = new ArrayList<>();

        Matcher numMatcher = Pattern.compile("[\\d]+").matcher(fomula);
        while(numMatcher.find())
            nums.add(Integer.parseInt(numMatcher.group()));

        Matcher operationMatcher = Pattern.compile("[+-]").matcher(fomula);
        while(operationMatcher.find())
            operations.add(operationMatcher.group().charAt(0)); // 어차피 기호는 한글자

        int minusIndex = -1;
        for(int i = 0 ; i < operations.size(); i++){
            if(Objects.equals(operations.get(i), '-')){
                minusIndex = i;
                break;
            }
        }
        // minus를 못찾은 경우
        if(minusIndex == -1){
            System.out.println(nums.stream().mapToInt(Integer::intValue).sum());
            return;
        }
        int sum = 0;
        for(int i = 0 ; i< nums.size(); i++){
            if( i <=minusIndex)
                sum += nums.get(i);
            else
                sum -= nums.get(i);
        }
        System.out.println(sum);

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