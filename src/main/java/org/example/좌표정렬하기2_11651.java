package org.example;

import java.io.*;
import java.util.StringTokenizer;




public class 좌표정렬하기2_11651 {

    static final String casefilepath = "C:\\Users\\sbl\\IdeaProjects\\learnjava\\src\\main\\java\\cases\\sort test.csv";
    static int compare(int[] a1, int[] a2){
        if(a1[1] == a2[1])
            return a2[0] - a1[0];
        return a2[1] - a1[1];
    }
    static void swap(int[] a, int[] b){
        int[] temp = a;
        a = b;
        b = temp;
    }

    static int divide(int[][] array, int l, int r){
        int[] pivot = array[l];
        int low = l+1;
        int high = r;

        while(low < high){
            while(low <= r && compare(array[low], pivot) >= 0){
                low++;
            }
            while(high >= l && compare(pivot, array[high]) >=0){
                high--;
            }
            // low와 high가 만나지 않았다는 것은
            // low와 high 모두 크기 비교 결과 제자리에 있지 않다는 것
            if(low <= high){
                swap(array[low], array[high]);
                low++;
                high--;
            }

        }
        // low와 high가 만났으므로, high가 pivot보다 작으면서 가장 오른쪽에 존재하는 원소이다.
        swap(array[l], array[high]);
        return high; // 피벗의 정렬 후 위치
    }

    static void quickSort(int[][] array, int l, int r){
        if(l<r){
            int mid = divide(array, l, r);
            quickSort(array, l, mid-1);
            quickSort(array, mid+1, r);

        }
    }
    static int[][] readTestCase(){
        String caseNumLine = scanf.nextLine();
        int n = Integer.parseInt(caseNumLine.substring(1,caseNumLine.indexOf(',')));

        int[][] result = new int[n][2];
        String line;
        int index = 0;
        while ((line = scanf.nextLine()) != null) {
            String[] row = line.split(","); // CSV 파일의 열 구분자에 따라 변경
            int[] intRow = new int[row.length];
            for(int i = 0 ; i  < intRow.length; i++){
                intRow[i] = Integer.parseInt(row[i]);
            }
            result[index++] = intRow;
        }
        return result;
    }
    static void input() throws Exception {


        int list[][] = readTestCase();
        System.out.println("read done");
        // 퀵 정렬 수행(left: 배열의 시작 = 0, right: 배열의 끝 = 8)
        quickSort(list, 0, list.length-1);

        // 정렬 결과 출력
        for(int i = 0 ; i < list.length; i++){
            sb.append(list[i][0]).append(' ').append(list[i][1]);
        }
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
    static FastReader scanf;

    static {
        try {
            scanf = new FastReader(casefilepath);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    static StringBuilder sb = new StringBuilder();



}