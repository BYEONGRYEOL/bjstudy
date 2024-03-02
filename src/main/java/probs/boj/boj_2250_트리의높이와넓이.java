package probs.boj;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class boj_2250_트리의높이와넓이 {
    static Node[] nodes;
    static class Node{
        public int l;
        public int r;
        public Node(int l, int r){
            this.l = l;
            this.r = r;
        }
        int depth;
        int index;
    }
    static class Tree{
        static int column = 1;
        static int maxDepth = 0;
        static HashMap<Integer, int[]> minMaxByDepth = new HashMap<>();
        public void explore(int index, int depth){
            maxDepth = Math.max(depth, maxDepth);
            // 전 중 후 순회
            if(nodes[index].l >0){
                // l 노드가 있는 경우임
                explore(nodes[index].l, depth+1);
                // 트리를 훼손하지만 한번만 탐색할거니까 ㄱㅊ
            }
            // 모든 l 노드를 탐색하고 돌아온 상태 
            nodes[index].depth = depth;
            nodes[index].index = column++;
            if(minMaxByDepth.containsKey(depth)){
                minMaxByDepth.get(depth)[0] = Math.min(minMaxByDepth.get(depth)[0], column);
                minMaxByDepth.get(depth)[1] = Math.max(minMaxByDepth.get(depth)[1], column);
            }
            else{
                minMaxByDepth.put(depth, new int[]{column, column});
            }
            if(nodes[index].r > 0){
                explore(nodes[index].r, depth+1);
            }
        }

        public int[] getMax(){
            int depth = 1;
            int[] answer = new int[2];
            answer[0] = depth;
            answer[1] = 0;
            while(minMaxByDepth.containsKey(depth)){
                if(answer[1] < minMaxByDepth.get(depth)[1] - minMaxByDepth.get(depth)[0]){
                    answer[1] = minMaxByDepth.get(depth)[1] - minMaxByDepth.get(depth)[0];
                    answer[0] = depth;
                }
                depth++;
            }
            return answer;
        }

    }

    static void input() throws Exception {
        int n = scan.nextInt();
        nodes = new Node[n+1];
        for(int i = 1 ; i <= n; i++){
            nodes[scan.nextInt()] = new Node(scan.nextInt(), scan.nextInt());
        }


        boolean isRoot[] = new boolean[n+1];
        Arrays.fill(isRoot, true);
        isRoot[0] = false;
        for(int i = 1 ; i <=n; i++){
            if(nodes[i].l > -1){
                isRoot[nodes[i].l] = false;
            }
            if(nodes[i].r > -1){
                isRoot[nodes[i].r] = false;
            }
        }
        int rootNode = 0;
        for(int i = 1; i <=n; i++){
            if(isRoot[i])
                rootNode = i;
        }

        Tree tree = new Tree();
        tree.explore(rootNode, 1);
        int[] answer = tree.getMax();
        sb.append(answer[0]).append(' ').append(answer[1] + 1);
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