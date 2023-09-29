package org.example;

import java.util.*;
import java.util.stream.*;
class Solution {
    
    static int[] array;
    public class SegTree{
        int tree[];

        public int init(int s, int e, int index){
            if(s == e){
                this.tree[index] = array[s];
                return this.tree[index];
            }
            // 이분
            int mid = (s + e) / 2;
            // 왼쪽 절반 범위는 왼쪽 자식 노드 오른쪽 절반 범위는 오른쪽 자식노드
            this.tree[index] = init(s,mid, index * 2) + init(mid+1, e, index * 2 + 1);
            return this.tree[index];
        }

        public int intervalSum(int s, int e,  int l, int r, int index){
            // 합을 구하려는 범위가 현재 노드가 관리하는 s~e 사이에 있지 않음
            if( l > e || r < s)
                return 0;
            if(l <= s && r >= e)
                return this.tree[index];
            int mid = (s + e ) /2;
            return intervalSum(s, mid, l,r, index * 2) + intervalSum(mid+1, e, l, r, index * 2 +1);
        }

        public void update(){
            
        }
        
        public SegTree(int size){
            this.tree = new int[size * 4];
        }

        public void Print(){
            IntStream.of(this.tree)
            .forEach(System.out::println);
        }

    }
    public void solution() {

        array = new int[]{1,2,3,4,5,6,7,8,9,10};
        int size =array.length;

        SegTree segTree = new SegTree(size);

        System.out.println(segTree.intervalSum(0,9, 4,6,1));
    }
}