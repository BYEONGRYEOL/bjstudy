package org.example;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;



public class boj1517_버블소트 {
    static long swapCount =0;
    static int[] sorted;
    static void merge(int[] array,  int l, int m, int r){
        long inversionCount = 0;
        int i = 0;
        int lindex = l;
        int rindex = m+1;
        int sortedIndex = l;
        while(lindex <=m && rindex <=r){
            // 왼쪽 배열이 sorted에 들어갈때는 여태까지
            // 오른쪽 배열이 먼저 오게 된 경우가 있는 만큼의 교차점이 생기게 된다.
            if(array[lindex] <= array[rindex]){
                sorted[sortedIndex++] = array[lindex++];
                swapCount += inversionCount;
            }
            // 반면 여태까지 어떻게 진행되었든 오른쪽 배열이 sorted에 들어갈 때는 추가되지 않음
            // 오른쪽 배열이 sorted에 들어간, 그러니까 inversion이 일어난 횟수 카운트
            else{
                sorted[sortedIndex++] = array[rindex++];
                inversionCount++;
            }

        }
        // left 구역이든 right 구역이든 남아있는 값들을 복사해야한다.
        if(lindex > m) { // left Index가 m을 넘어갔다면 오른쪽이 남아있는 것
            for (i = rindex; i <= r; i++) {
                sorted[sortedIndex++] = array[i];
            }
        }
        else{
            for(i = lindex; i <= m; i++){
                sorted[sortedIndex++] = array[i];
                swapCount += inversionCount;
            }
        }


        for(i=l; i <= r; i++)
            array[i] = sorted[i];
    }

    static void mergeSort(int[] array, int l, int r){
        if(l < r){
            int m = (l+r)/2;
            mergeSort(array, l, m);
            mergeSort(array, m+1, r);
            merge(array, l, m, r);
        }
    }
    static void input() throws Exception {
        int n = scan.nextInt();
        int[] array = new int[n];
        sorted = new int[n];
        for(int i = 0 ; i < n ; i ++)
            array[i] = scan.nextInt();

        mergeSort(array, 0, n-1);
        System.out.println(swapCount);
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
