//package org.example;
//
//import java.io.*;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.StringTokenizer;
//
//public class 멀티탭스케쥴링_1700 {
//
//    static void input() throws Exception {
//        int n = scan.nextInt();
//        int k = scan.nextInt();
//        int using[] = new int[n];
//        int useCount = 0;
//        Map<Integer, Integer> remain = new HashMap<>();
//        int[] array = new int[k];
//        for(int i = 0 ; i  < k ; i++){
//            array[i] = scan.nextInt();
//            remain.put(array[i], remain.getOrDefault(array[i], 0) + 1);
//        }
//
//        int unPlugCount = 0;
//        for(int i  =0 ; i  < k ; i ++){
//            int product = array[i];
//            remain.put(product, remain.get(product) -1);
//
//            if(useCount < n){
//                using[useCount++] = product;
//                continue;
//            }
//
//            boolean continueFlag = false;
//            for(int j = 0 ; j < n ; j ++){
//                if(using[j] == product){
//                    continueFlag = true;
//                }
//            }
//            if(continueFlag)
//                continue;
//
//            int unplug = 0;
//            for(int j = 0; j<n; j++){
//                // 현재 using[j] 가 뒤에 또 언제 등장하는지 찾을 예정
//                int latestUseIndex = -1;
//                for(int l = i+1 ; j < k; j ++){
//                    if(using[array[j]] ){
//                        unplug = array[j];
//                        if(remain.get(unplug) <= 0){
//                            break;
//                        }
//                    }
//                }
//            }
//
//            using[unplug] = false;
//            using[product] = true;
//            unPlugCount++;
//        }
//        System.out.println(unPlugCount);
//    }
//    static long lessThanCount(long n, long x){
//        long count = 0;
//        for(int i = 1 ;i <=n;i++){
//            count +=Math.min(n, x/i);
//        }
//        return count;
//    }
//    static void print(){
//        System.out.print(sb.toString());
//    }
//    static class FastReader {
//        BufferedReader br;
//        StringTokenizer st;
//        public FastReader() {
//            br = new BufferedReader(new InputStreamReader(System.in));
//        }
//        public FastReader(String s) throws FileNotFoundException {
//            br = new BufferedReader(new FileReader(new File(s)));
//        }
//        String next() {
//            while (st == null || !st.hasMoreElements()) {
//                try {
//                    st = new StringTokenizer(br.readLine());
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            return st.nextToken();
//        }
//        int nextInt() {
//            return Integer.parseInt(next());
//        }
//        long nextLong() {
//            return Long.parseLong(next());
//        }
//        double nextDouble() {
//            return Double.parseDouble(next());
//        }
//        String nextLine() {
//            String str = "";
//            try {
//                str = br.readLine();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            return str;
//        }
//    }
//
//    public static void main(String[] args) throws Exception {
//        input();
//    }
//    static FastReader scan = new FastReader();
//    static StringBuilder sb = new StringBuilder();
//
//
//
//}