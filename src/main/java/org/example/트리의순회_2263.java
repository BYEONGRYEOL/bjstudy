package org.example;

import java.io.*;
import java.util.StringTokenizer;

public class 트리의순회_2263 {
    static int len;
    static int[] inorder;
    static int[] postorder;

    static int findRootIndex(int s, int e, int targetIndex){
        // postorder[e] 가 현재 탐색 범위 클러스터의 root node
        for(int i = s; i <= e; i++){
            if(inorder[i] == postorder[targetIndex])
                return i;
        }
        return -1;
    }
    static void preorder(int s, int e, int targetIndex, int rightFindDepth){

        int nowRootIndex = findRootIndex(s, e, targetIndex - rightFindDepth);
        if(nowRootIndex == -1)
            return;
        sb.append(inorder[nowRootIndex]).append(' '); // 중

        preorder(s, nowRootIndex-1, nowRootIndex-1, rightFindDepth); // 전
        preorder(nowRootIndex+1, e,targetIndex, rightFindDepth+1); // 후
    }

    static void input() throws Exception {
        // 먼저 postorder의 맨 끝이 root 노드이다.
        // root Node를 찾았으니 inorder에서 rootNode의 위치를 찾아 반으로 나눈다.
        // inorder   : 4 6 5 2 8 7 9 10 1 3 12 11 13
        // postorder : 6 5 4 8 10 9 7 2 12 13 11 3 1
        // 위의 상황이였다면, root Node는 1이되고 inorder 순회에서 1을 기준으로 좌 우로 나눈다.
        // left : 4 6 5 2 8 7 9 10 // right : 3 12 11 13
        // postorder : 6 5 4 8 10 9 7 2 12 13 11 3 postorder 또한 같은 크기만큼으로 배열을 나누면 left, right 두개로 다시 나눌 수 있다.
        // inorder의 경우 8개, 4개로 나뉘었고,
        // index는 0~7 / 9~12
        // postorder의 경우 12개 연속이다.
        // index 0~7에 대해서 조사할때
        // 2를 기준으로 나뉜다.
        // inorder의 경우 4 6 5 3개 // 8 7 9 10 4개로 나뉘었고
        // index는 0~2 // 4~7
        // postorder의 경우 이를 0~2에서 검사한다.

        //inorder 4~7의 경우
        // postorder 3~6에서 검사한다.
        // 나누어진 두 개의 node cluster에도 root가 있을 것이므로 계산해보면

        // left
        // inorder   : 4 6 5 2 8 7 9 10
        // postorder : 6 5 4 8 10 9 7 2
        // 이번에도 postorder의 마지막 노드가 root 노드임이 계산됨
        len = scan.nextInt();
        inorder = new int[len];
        postorder = new int[len];
        for(int i = 0 ; i <len ; i++)
            inorder[i] = scan.nextInt();
        for(int i = 0 ; i <len ; i++)
            postorder[i] = scan.nextInt();

        preorder(0,len-1, len-1, 0);
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