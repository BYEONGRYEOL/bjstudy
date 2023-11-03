package org.example;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj2887_행성터널 {

    static int[] parent;

    static int findParent(int c){
        if(parent[c] == c) return c;
        return findParent(parent[c]);
    }

    static boolean merge(int a, int b){
        int c = findParent(a);
        int p = findParent(b);
        if(p==c) return false;

        if(p>c)
            parent[p] = c;
        else
            parent[c] = p;
        return true;
    }

    static void input() throws Exception {
        int n = scan.nextInt();
        int[][] nodes = new int[n][4];
        int[][] edges = new int[n*3+1][3];
        edges[0] = new int[]{-1,-1,Integer.MAX_VALUE};

        parent = new int[n+1];
        for(int i = 1; i < n+1; i ++)
            parent[i] = i;

        for(int i =0 ; i < n  ; i ++){
            nodes[i] = new int[]{i, scan.nextInt(), scan.nextInt(), scan.nextInt()};
        }


        Arrays.sort(nodes, (a1, a2) -> {
            return a1[1]-a2[1];
        });

        for(int i = 1 ; i < n ; i++){
            edges[i] = new int[]{nodes[i-1][0], nodes[i][0], nodes[i][1] - nodes[i-1][1] };
        }
        Arrays.sort(nodes, (a1, a2) -> {
            return a1[2]-a2[2];
        });

        for(int i = 1 ; i < n ; i++){
            edges[n+i] = new int[]{nodes[i-1][0], nodes[i][0], nodes[i][2] - nodes[i-1][2] };
        }

        Arrays.sort(nodes, (a1, a2) -> {
            return a1[3]-a2[3];
        });

        for(int i = 1 ; i < n ; i++){
            edges[n * 2 +i] = new int[]{nodes[i-1][0], nodes[i][0], nodes[i][3] - nodes[i-1][3] };
        }

        Arrays.sort(edges, (a1,a2)->{
            return a1[2] - a2[2];
        });

        int usedEdgeNum = 0;
        int totalCost = 0;
        for(int i = 0 ; i < n*3 ; i ++) {
            if(usedEdgeNum == n-1)
                break;
            int a = edges[i][0];
            int b = edges[i][1];
            int cost = edges[i][2];
            if(merge(a,b)) {
                totalCost += cost;
                usedEdgeNum++;
            }
        }

        System.out.println(totalCost);


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
