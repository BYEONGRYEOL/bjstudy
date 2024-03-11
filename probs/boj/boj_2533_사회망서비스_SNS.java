package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_2533_사회망서비스_SNS {

    static int N = 1000001;
    static int[][] dp = new int[N][2];
    static List<Integer>[] edges = new List[N];
    static boolean[] visited = new boolean[N];
    static void input() throws Exception {
        for (int i = 0; i < N; i++) {
            edges[i] = new ArrayList<>();
        }
        int n = scan.nextInt();

        for (int i = 0; i < n-1; i++) {
            int s = scan.nextInt();
            int e = scan.nextInt();
            edges[s].add(e);
            edges[e].add(s);
        }
        findRecursive(1);
        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }

    static void findRecursive(int index){
        visited[index] = true;
        dp[index][1] = 1;
        for (int next : edges[index]) {
            if(visited[next])
                continue;
            findRecursive(next);
            dp[index][0] += dp[next][1];
            dp[index][1] += Math.min(dp[next][0], dp[next][1]);
        }
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