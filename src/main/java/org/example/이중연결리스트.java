package org.example;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 이중연결리스트 {
    static class Node{
        Node left;
        Node right;
        int value;
        public Node(int value){
            this.value = value;
        }
    }

    static class DoubleLinkedList{
        Node head;
        Node tail;
        int size;
        public DoubleLinkedList(){
            this.size = 0;
        }
        public int size(){
            return this.size;
        }
        public void print(){
            sb.setLength(0);
            Node node = this.head;
            while(node != null){
                sb.append(node.value).append(' ');
                node = node.right;
            }
            sb.append('\n');
            이중연결리스트.print();
        }
        public void addBack(int value){
            Node addNode = new Node(value); // 추가할 노드
            if(isEmpty()){
                this.head = addNode;
                this.tail = addNode;
                return;
            }

            Node node = tail; // 끝의 노드에 바로 접근

            // 추가할노드와 원래 tail 노드를 서로 연결
            node.right = addNode;
            addNode.left = node;
            this.tail = addNode; // 추가된 노드를 tail로 지정
            //size 증가 처리
            this.size++;
        }
        public void addFront(int value){
            Node addNode = new Node(value);
            if(isEmpty()){
                this.head = addNode;
                this.tail = addNode;
                return;
            }

            Node node = head; // 맨앞의 노드에 바로 접근

            node.left = addNode;
            addNode.right = node;
            this.head = addNode; // 추가된 노드를 head로 지정

            //size 증가 처리
            this.size++;
        }
        public boolean isEmpty(){
            if(this.head == null)
                return true;
            return false;
        }

        public void delete(int index){
            if(isEmpty())
                return;
            if(this.size <= index)
                return;

            Node node = null;

            if(index < this.size / 2){ // 앞에서 부터 지우는 게 유리하다
                node = head;
                while(index > 0 && node.right != null){
                    node = node.right;
                    index --;
                }
            }
            else if(index >= this.size / 2){ // 뒤에서 부터 지우는 게 유리하다
                node = tail;
                while(index <size && node.left != null){
                    node = node.left;
                    index ++;
                }
            }
            // 지울 노드
            if(node == head){
                node.right.left = null;
                this.head = node.right;
            }
            else if(node == tail){
                node.left.right = null;
                this.tail = node.left;
            }
            else{
                node.left.right = node.right;
                node.right.left = node.left;
            }
            // size 감소 처리
            this.size --;
        }
    }
    static void input() throws Exception {
        DoubleLinkedList ddl = new DoubleLinkedList();
        int cases = scan.nextInt();
        for(int i = 0; i < cases; i++){
            int operation = scan.nextInt(); // 1 : addFront  2 : addBack 0 : delete
            int num = scan.nextInt();
            if(operation == 1){
                ddl.addFront(num);
            } else if (operation==2) {
                ddl.addBack(num);
            }
            else if(operation == 0){
                ddl.delete(num);
            }
            ddl.print();
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