package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class boj2108_통계학 {

    static int range(int[] array){
        int min=4000;
        int max = -4000;
        for (int i = 0; i < array.length; i++) {
            min = Math.min(min, array[i]);
            max = Math.max(max, array[i]);
        }
        return max-min;
    }
    static int mode(int[] array){
        if(array.length == 1)
            return array[0];
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            countMap.put(array[i], countMap.getOrDefault(array[i], 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> sortedMap = countMap.entrySet().stream().sorted((e1, e2) -> {
            if(e2.getValue() == e1.getValue())
                return e1.getKey() - e2.getKey();
            return e2.getValue() - e1.getValue();
        }).collect(Collectors.toList());

        if(sortedMap.get(0).getValue() == sortedMap.get(1).getValue())
            return sortedMap.get(1).getKey();
        return sortedMap.get(0).getKey();
    }
    static int median(int[] array){
        Arrays.sort(array);
        return array[array.length/2];
    }
    static int mean(int[] array){
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            result += array[i];
        }
        return Math.round(result / (float)array.length);
    }
    static void input() throws Exception {
        int n = scan.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scan.nextInt();
        }
        sb.append(mean(array)).append('\n');
        sb.append(median(array)).append('\n');
        sb.append(mode(array)).append('\n');
        sb.append(range(array)).append('\n');
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